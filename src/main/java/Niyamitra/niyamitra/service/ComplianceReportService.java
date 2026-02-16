package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.ComplianceReportDTO;
import Niyamitra.niyamitra.entity.ComplianceReport;

import java.util.List;

public interface ComplianceReportService {

    ComplianceReport createReport(ComplianceReportDTO dto);

    ComplianceReport getReport(Long id);

    List<ComplianceReport> getAllReports();

    List<ComplianceReport> getReportsByBank(Long bankId);

    ComplianceReport updateReport(Long id, ComplianceReportDTO dto);

    void deleteReport(Long id);
}
