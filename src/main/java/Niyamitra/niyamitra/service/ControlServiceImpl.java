package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.ControlDTO;
import Niyamitra.niyamitra.entity.ControlEntity;
import Niyamitra.niyamitra.repository.ControlRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ControlServiceImpl implements ControlService {

    private final ControlRepository controlRepository;

    public ControlServiceImpl(ControlRepository controlRepository) {
        this.controlRepository = controlRepository;
    }

    @Override
    public ControlDTO createControl(ControlDTO dto) {
        ControlEntity entity = dtoToEntity(dto);
        return entityToDto(controlRepository.save(entity));
    }

    @Override
    public ControlDTO getControlById(Long id) {
        ControlEntity entity = controlRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Control not found"));
        return entityToDto(entity);
    }

    @Override
    public List<ControlDTO> getAllControls() {
        return controlRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ControlDTO updateControl(Long id, ControlDTO dto) {

        ControlEntity entity = controlRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Control not found"));

        // master fields
        if (dto.getControlName() != null) entity.setControlName(dto.getControlName());
        if (dto.getFrequency() != null) entity.setFrequency(dto.getFrequency());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
        if (dto.getOwner() != null) entity.setOwner(dto.getOwner());
        if (dto.getRiskCategory() != null) entity.setRiskCategory(dto.getRiskCategory());
        if (dto.getMap() != null) entity.setMap(dto.getMap());
        if (dto.getTitle() != null) entity.setTitle(dto.getTitle());

        // auditor fields ✅
        if (dto.getStatus() != null) entity.setStatus(dto.getStatus());
        if (dto.getChecklist() != null) entity.setChecklist(dto.getChecklist());
        if (dto.getResult() != null) entity.setResult(dto.getResult());
        if (dto.getTestedSize() != null) entity.setTestedSize(dto.getTestedSize());
        if (dto.getObservation() != null) entity.setObservation(dto.getObservation());

        return entityToDto(controlRepository.save(entity));
    }

    @Override
    public void deleteControl(Long id) {
        controlRepository.deleteById(id);
    }

    // ================= MAPPERS =================

    private ControlEntity dtoToEntity(ControlDTO dto) {
        ControlEntity e = new ControlEntity();
        e.setControlName(dto.getControlName());
        e.setFrequency(dto.getFrequency());
        e.setDescription(dto.getDescription());
        e.setOwner(dto.getOwner());
        e.setRiskCategory(dto.getRiskCategory());
        e.setMap(dto.getMap());
        e.setTitle(dto.getTitle());
        e.setStatus(dto.getStatus());
        e.setChecklist(dto.getChecklist());
        e.setResult(dto.getResult());
        e.setTestedSize(dto.getTestedSize() != null ? dto.getTestedSize() : 0);
        e.setObservation(dto.getObservation());
        return e;
    }

    private ControlDTO entityToDto(ControlEntity e) {
        ControlDTO dto = new ControlDTO();
        dto.setId(e.getId());
        dto.setControlName(e.getControlName());
        dto.setFrequency(e.getFrequency());
        dto.setDescription(e.getDescription());
        dto.setOwner(e.getOwner());
        dto.setRiskCategory(e.getRiskCategory());
        dto.setMap(e.getMap());
        dto.setTitle(e.getTitle());
        dto.setStatus(e.getStatus());
        dto.setChecklist(e.getChecklist());
        dto.setResult(e.getResult());
        dto.setTestedSize(e.getTestedSize());
        dto.setObservation(e.getObservation());
        return dto;
    }
}

