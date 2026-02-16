package Niyamitra.niyamitra.dto;

import java.time.LocalDate;
import java.util.List;

import Niyamitra.niyamitra.enums.ReportFormat;
import Niyamitra.niyamitra.enums.ReportType;

import lombok.Data;

@Data
public class ComplianceReportDTO {

    private Long bankId;
    private ReportType reportType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String regulator;
    private List<String> includeSections;
    private ReportFormat format;
    private String additionalNotes;
    private Long generatedBy;
}
