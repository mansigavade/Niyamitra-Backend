package Niyamitra.niyamitra.controller;

import Niyamitra.niyamitra.dto.GenerateReportDTO;
import Niyamitra.niyamitra.service.GenerateReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generated-reports")
@RequiredArgsConstructor
@CrossOrigin("*") // allow frontend
public class GenerateReportController {

    private final GenerateReportService service;

    //------------------------------------------
    // CREATE
    //------------------------------------------

    @PostMapping
    public GenerateReportDTO createReport(
            @RequestBody GenerateReportDTO dto) {

        return service.createReport(dto);
    }

    //------------------------------------------
    // READ ALL
    //------------------------------------------

    @GetMapping
    public List<GenerateReportDTO> getAllReports() {

        return service.getAllReports();
    }

    //------------------------------------------
    // READ BY ID
    //------------------------------------------

    @GetMapping("/{id}")
    public GenerateReportDTO getReport(
            @PathVariable Long id) {

        return service.getReportById(id);
    }

    //------------------------------------------
    // UPDATE
    //------------------------------------------

    @PutMapping("/{id}")
    public GenerateReportDTO updateReport(
            @PathVariable Long id,
            @RequestBody GenerateReportDTO dto) {

        return service.updateReport(id, dto);
    }

    //------------------------------------------
    // DELETE
    //------------------------------------------

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {

        service.deleteReport(id);
    }
}
