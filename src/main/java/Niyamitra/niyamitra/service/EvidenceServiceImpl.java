package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.EvidenceDTO;
import Niyamitra.niyamitra.entity.EvidenceEntity;
import Niyamitra.niyamitra.repository.EvidenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceRepository evidenceRepository;

    public EvidenceServiceImpl(EvidenceRepository evidenceRepository) {
        this.evidenceRepository = evidenceRepository;
    }

    @Override
    public EvidenceEntity getEvidenceEntity(Long id) {
        return evidenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evidence not found"));
    }

    // ✅ CREATE (UPLOAD)
    @Override
    public EvidenceDTO createEvidence(
            String control,
            String period,
            MultipartFile file,
            String notes
    ) throws IOException {

        EvidenceEntity entity = new EvidenceEntity();
        entity.setControl(control);
        entity.setPeriod(period);
        entity.setNotes(notes);

        entity.setFileData(file.getBytes());
        entity.setFileName(file.getOriginalFilename());
        entity.setFileType(file.getContentType());

        entity.setStatus("SUBMITTED");

        // ✅ AUTO USERNAME (without security)
        entity.setUsername("SYSTEM");

        // ✅ AUTO CURRENT TIME
        entity.setTime(Time.valueOf(LocalTime.now()));

        return toDto(evidenceRepository.save(entity));
    }

    @Override
    public EvidenceDTO getEvidenceById(Long id) {
        return toDto(getEvidenceEntity(id));
    }

    @Override
    public List<EvidenceDTO> getAllEvidences() {
        return evidenceRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    // ✅ UPDATE
    @Override
    public EvidenceDTO updateEvidence(
            Long id,
            String control,
            String period,
            MultipartFile file,
            String notes
    ) throws IOException {

        EvidenceEntity entity = getEvidenceEntity(id);

        entity.setControl(control);
        entity.setPeriod(period);
        entity.setNotes(notes);

        if (file != null && !file.isEmpty()) {
            entity.setFileData(file.getBytes());
            entity.setFileName(file.getOriginalFilename());
            entity.setFileType(file.getContentType());
        }

        return toDto(evidenceRepository.save(entity));
    }
    
    @Override
    public EvidenceDTO updateStatus(Long id, String status) {

        EvidenceEntity entity = getEvidenceEntity(id);

        // VALIDATION (optional but good)
        if (!status.equalsIgnoreCase("VERIFIED")
                && !status.equalsIgnoreCase("REJECTED")
                && !status.equalsIgnoreCase("SUBMITTED")) {
            throw new RuntimeException("Invalid status");
        }

        entity.setStatus(status.toUpperCase());

        return toDto(evidenceRepository.save(entity));
    }


    // ✅ DELETE
    @Override
    public void deleteEvidence(Long id) {
        evidenceRepository.deleteById(id);
    }

    // 🔁 ENTITY → DTO
    private EvidenceDTO toDto(EvidenceEntity e) {
        EvidenceDTO dto = new EvidenceDTO();
        dto.setId(e.getId());
        dto.setControl(e.getControl());
        dto.setPeriod(e.getPeriod());
        dto.setNotes(e.getNotes());
        dto.setStatus(e.getStatus());
        dto.setFileName(e.getFileName());
        dto.setFileType(e.getFileType());
        dto.setUsername(e.getUsername());
        dto.setTime(e.getTime()); // ✅ SEND TIME
        return dto;
    }
}
