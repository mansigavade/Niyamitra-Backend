package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.GenerateReportDTO;
import Niyamitra.niyamitra.entity.GenerateReport;
import Niyamitra.niyamitra.repository.GenerateReportRepository;
import Niyamitra.niyamitra.service.GenerateReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenerateReportServiceImpl implements GenerateReportService {

    private final GenerateReportRepository repository;

    //------------------------------------------
    // CREATE
    //------------------------------------------

    @Override
    public GenerateReportDTO createReport(GenerateReportDTO dto) {

        GenerateReport report = mapToEntity(dto);

        return mapToDTO(repository.save(report));
    }

    //------------------------------------------
    // READ ALL
    //------------------------------------------

    @Override
    public List<GenerateReportDTO> getAllReports() {

        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    //------------------------------------------
    // READ BY ID
    //------------------------------------------

    @Override
    public GenerateReportDTO getReportById(Long id) {

        GenerateReport report = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        return mapToDTO(report);
    }

    //------------------------------------------
    // UPDATE
    //------------------------------------------

    @Override
    public GenerateReportDTO updateReport(Long id, GenerateReportDTO dto) {

        GenerateReport report = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        report.setBankId(dto.getBankId());
        report.setReportType(dto.getReportType());
        report.setStatus(dto.getStatus());
        report.setStartDate(dto.getStartDate());
        report.setEndDate(dto.getEndDate());
        report.setSections(dto.getSections());
        report.setNotes(dto.getNotes());
        report.setGeneratedBy(dto.getGeneratedBy());
        report.setFileUrl(dto.getFileUrl());

        return mapToDTO(repository.save(report));
    }

    //------------------------------------------
    // DELETE
    //------------------------------------------

    @Override
    public void deleteReport(Long id) {

        repository.deleteById(id);
    }

    //------------------------------------------
    // MAPPER (VERY CLEAN APPROACH)
    //------------------------------------------

    private GenerateReportDTO mapToDTO(GenerateReport report) {

        return GenerateReportDTO.builder()
                .id(report.getId())
                .bankId(report.getBankId())
                .reportType(report.getReportType())
                .status(report.getStatus())
                .startDate(report.getStartDate())
                .endDate(report.getEndDate())
                .sections(report.getSections())
                .notes(report.getNotes())
                .generatedBy(report.getGeneratedBy())
                .fileUrl(report.getFileUrl())
                .build();
    }

    private GenerateReport mapToEntity(GenerateReportDTO dto) {

        return GenerateReport.builder()
                .bankId(dto.getBankId())
                .reportType(dto.getReportType())
                .status(dto.getStatus())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .sections(dto.getSections())
                .notes(dto.getNotes())
                .generatedBy(dto.getGeneratedBy())
                .fileUrl(dto.getFileUrl())
                .build();
    }
}
