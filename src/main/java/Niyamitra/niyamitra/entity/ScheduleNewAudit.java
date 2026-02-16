package Niyamitra.niyamitra.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "schedule_audits")
@Data
public class ScheduleNewAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String auditName;
    private String auditType;
    private String regulator;
    private String priority;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    private String frequency;
    private String circularReference;
    private String leadAuditor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuditStatus status;

    private double progress;

    @ElementCollection
    @CollectionTable(
            name = "audit_team_members",
            joinColumns = @JoinColumn(name = "audit_id")
    )
    @Column(name = "member_name")
    private List<String> teamMembers;
}
