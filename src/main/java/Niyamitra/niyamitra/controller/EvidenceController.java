package Niyamitra.niyamitra.controller;

import Niyamitra.niyamitra.dto.EvidenceDTO;
import Niyamitra.niyamitra.entity.EvidenceEntity;
import Niyamitra.niyamitra.service.EvidenceService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/evidences")
@CrossOrigin(origins = "*")
public class EvidenceController {

    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    // ✅ UPLOAD
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<EvidenceDTO> createEvidence(
            @RequestParam String control,
            @RequestParam String period,
            @RequestParam MultipartFile file,
            @RequestParam(required = false) String notes
    ) throws IOException {

        return ResponseEntity.ok(
                evidenceService.createEvidence(control, period, file, notes)
        );
    }

    // ✅ GET ALL
    @GetMapping
    public List<EvidenceDTO> getAll() {
        return evidenceService.getAllEvidences();
    }

    // ✅ DOWNLOAD
    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> download(@PathVariable Long id) {

        EvidenceEntity e = evidenceService.getEvidenceEntity(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" + e.getFileName() + "\"")
                .contentType(MediaType.parseMediaType(e.getFileType()))
                .contentLength(e.getFileData().length)
                .body(e.getFileData());
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        evidenceService.deleteEvidence(id);
    }
    
 // ✅ APPROVE / REJECT (STATUS UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<EvidenceDTO> updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return ResponseEntity.ok(
                evidenceService.updateStatus(id, status)
        );
    }

}
