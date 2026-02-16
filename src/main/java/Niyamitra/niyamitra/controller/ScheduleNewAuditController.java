package Niyamitra.niyamitra.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Niyamitra.niyamitra.dto.ScheduleNewAuditDTO;
import Niyamitra.niyamitra.service.ScheduleNewAuditService;

import java.util.List;

@RestController
@RequestMapping("/api/scheduled-audits")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ScheduleNewAuditController {

    private final ScheduleNewAuditService service;

    // CREATE
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody ScheduleNewAuditDTO dto) {

        return ResponseEntity.ok(service.save(dto));
    }

    // READ ALL
    @GetMapping
    public List<ScheduleNewAuditDTO> getAll() {
        return service.getAllAudits();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ScheduleNewAuditDTO getById(
            @PathVariable Long id) {

        return service.getAuditById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id) {

        service.deleteAudit(id);

        return ResponseEntity.ok("Deleted Successfully");
    }
}
