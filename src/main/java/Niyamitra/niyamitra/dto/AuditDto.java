package Niyamitra.niyamitra.dto;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class AuditDto {

    private Long id;
    private String auditName;
    private String regulator;
    private String auditType;
    private String priority;
    private String circularReference;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String frequency;
    private String status;
    private List<String> milestones;
    private Date date;
    private String leadAuditor;
    private List<String> teamMembers;
    private List<String> policiesInScope;
    private String notes;

   
}
