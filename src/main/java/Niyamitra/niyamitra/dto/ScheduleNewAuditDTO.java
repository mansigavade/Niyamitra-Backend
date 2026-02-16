package Niyamitra.niyamitra.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class ScheduleNewAuditDTO {

    private Long id;
    private String auditName;
    private String auditType;
    private String regulator;
    private String priority;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String frequency;
    private String circularReference;
    private String leadAuditor;
    private String status; // keep string for API
    private double progress;
    private List<String> teamMembers;
}
