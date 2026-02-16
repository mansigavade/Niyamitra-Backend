package Niyamitra.niyamitra.controller;

import Niyamitra.niyamitra.dto.FindingAuditDto;
import Niyamitra.niyamitra.service.FindingAuditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/findings")
@CrossOrigin("*")
public class FindingAuditController {

    private final FindingAuditService service;

    public FindingAuditController(FindingAuditService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<FindingAuditDto> create(@RequestBody FindingAuditDto dto) {
        return new ResponseEntity<>(service.createFinding(dto), HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<FindingAuditDto>> getAll() {
        return ResponseEntity.ok(service.getAllFindings());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<FindingAuditDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFindingById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FindingAuditDto> update(
            @PathVariable Long id,
            @RequestBody FindingAuditDto dto) {
        return ResponseEntity.ok(service.updateFinding(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteFinding(id);
        return ResponseEntity.ok("Finding deleted successfully");
    }
}
