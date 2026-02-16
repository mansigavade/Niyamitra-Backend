package Niyamitra.niyamitra.controller;

import Niyamitra.niyamitra.dto.AuditDto;
import Niyamitra.niyamitra.service.AuditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audits")
@CrossOrigin(origins = "*")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<AuditDto> createAudit(@RequestBody AuditDto dto) {
        return ResponseEntity.ok(auditService.createAudit(dto));
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AuditDto> getAudit(@PathVariable Long id) {
        return ResponseEntity.ok(auditService.getAuditById(id));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<AuditDto>> getAllAudits() {
        return ResponseEntity.ok(auditService.getAllAudits());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<AuditDto> updateAudit(
            @PathVariable Long id,
            @RequestBody AuditDto dto) {
        return ResponseEntity.ok(auditService.updateAudit(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAudit(@PathVariable Long id) {
        auditService.deleteAudit(id);
        return ResponseEntity.ok("Audit deleted successfully");
    }
}
