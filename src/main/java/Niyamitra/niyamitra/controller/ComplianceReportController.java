package Niyamitra.niyamitra.controller;

import Niyamitra.niyamitra.dto.ComplianceReportDTO;
import Niyamitra.niyamitra.entity.ComplianceReport;
import Niyamitra.niyamitra.service.ComplianceReportService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
public class ComplianceReportController {

    private final ComplianceReportService service;

    public ComplianceReportController(
            ComplianceReportService service) {
        this.service = service;
    }

    /* ===============================
       CREATE
    =============================== */

    @PostMapping
    public ResponseEntity<ComplianceReport> create(
            @RequestBody ComplianceReportDTO dto) {

        return ResponseEntity.ok(
                service.createReport(dto));
    }

    /* ===============================
       GET BY ID
    =============================== */

    @GetMapping("/{id}")
    public ResponseEntity<ComplianceReport> get(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getReport(id));
    }

    /* ===============================
       GET BY BANK
    =============================== */

    @GetMapping("/bank/{bankId}")
    public ResponseEntity<List<ComplianceReport>> getByBank(
            @PathVariable Long bankId) {

        return ResponseEntity.ok(
                service.getReportsByBank(bankId));
    }

    /* ===============================
       UPDATE
    =============================== */

    @PutMapping("/{id}")
    public ResponseEntity<ComplianceReport> update(
            @PathVariable Long id,
            @RequestBody ComplianceReportDTO dto) {

        return ResponseEntity.ok(
                service.updateReport(id, dto));
    }

    /* ===============================
       DELETE
    =============================== */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        service.deleteReport(id);

        return ResponseEntity.ok("Report deleted successfully");
    }
}
