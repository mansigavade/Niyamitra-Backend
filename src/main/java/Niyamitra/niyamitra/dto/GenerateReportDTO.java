package Niyamitra.niyamitra.dto;

import Niyamitra.niyamitra.enums.ReportStatus;
import Niyamitra.niyamitra.enums.ReportType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenerateReportDTO {

    private Long id;
    private Long bankId;

    private ReportType reportType;
    private ReportStatus status;

    private LocalDate startDate;
    private LocalDate endDate;

    // ⭐⭐⭐ VERY IMPORTANT (Your Missing Field)
    private LocalDateTime generatedAt;

    private List<String> sections;
    private String notes;

    private Long generatedBy;
    private String fileUrl;

    // ⭐ Recommended (Audit fields — senior practice)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
