package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.EvidenceDTO;
import Niyamitra.niyamitra.entity.EvidenceEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EvidenceService {

    EvidenceDTO createEvidence(
            String control,
            String period,
            MultipartFile file,
            String notes
    ) throws IOException;

    EvidenceDTO getEvidenceById(Long id);

    EvidenceEntity getEvidenceEntity(Long id); // 🔴 download साठी IMPORTANT

    List<EvidenceDTO> getAllEvidences();

    EvidenceDTO updateEvidence(
            Long id,
            String control,
            String period,
            MultipartFile file,
            String notes
    ) throws IOException;

    EvidenceDTO updateStatus(Long id, String status);
    void deleteEvidence(Long id);
    
    
}
