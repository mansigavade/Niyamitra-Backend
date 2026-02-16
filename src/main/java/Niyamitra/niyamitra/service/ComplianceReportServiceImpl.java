package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.ComplianceReportDTO;
import Niyamitra.niyamitra.entity.ComplianceReport;
import Niyamitra.niyamitra.repository.ComplianceReportRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceReportServiceImpl implements ComplianceReportService {

    private final ComplianceReportRepository repository;

    // ✅ Constructor Injection (BEST PRACTICE)
    public ComplianceReportServiceImpl(ComplianceReportRepository repository) {
        this.repository = repository;
    }

    /* =====================================================
                    CREATE REPORT
    ===================================================== */

    @Override
    public ComplianceReport createReport(ComplianceReportDTO dto) {

        ComplianceReport report = new ComplianceReport();

        // 🔥 MAP DTO → ENTITY
        report.setBankId(dto.getBankId());
        report.setReportType(dto.getReportType());
        report.setStartDate(dto.getStartDate());
        report.setEndDate(dto.getEndDate());
        report.setRegulator(dto.getRegulator());
        report.setIncludeSections(dto.getIncludeSections());
        report.setFormat(dto.getFormat());
        report.setAdditionalNotes(dto.getAdditionalNotes());
        report.setGeneratedBy(dto.getGeneratedBy());

        return repository.save(report);
    }

    /* =====================================================
                    GET REPORT BY ID
    ===================================================== */

    @Override
    public ComplianceReport getReport(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Report not found with id: " + id));
    }

    /* =====================================================
                    GET ALL REPORTS
    ===================================================== */

    @Override
    public List<ComplianceReport> getAllReports() {
        return repository.findAll();
    }

    /* =====================================================
                    GET REPORTS BY BANK
    ===================================================== */

    @Override
    public List<ComplianceReport> getReportsByBank(Long bankId) {
        return repository.findByBankId(bankId);
    }

    /* =====================================================
                    UPDATE REPORT
    ===================================================== */

    @Override
    public ComplianceReport updateReport(Long id, ComplianceReportDTO dto) {

        ComplianceReport report = getReport(id);

        report.setBankId(dto.getBankId());
        report.setReportType(dto.getReportType());
        report.setStartDate(dto.getStartDate());
        report.setEndDate(dto.getEndDate());
        report.setRegulator(dto.getRegulator());
        report.setIncludeSections(dto.getIncludeSections());
        report.setFormat(dto.getFormat());
        report.setAdditionalNotes(dto.getAdditionalNotes());
        report.setGeneratedBy(dto.getGeneratedBy());

        return repository.save(report);
    }

    /* =====================================================
                    DELETE REPORT
    ===================================================== */

    @Override
    public void deleteReport(Long id) {

        ComplianceReport report = getReport(id);

        repository.delete(report);
    }
}
