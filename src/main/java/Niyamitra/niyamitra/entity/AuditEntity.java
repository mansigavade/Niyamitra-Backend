package Niyamitra.niyamitra.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "audits")
public class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column( nullable = false)
    private String auditName;

    @Column(nullable = false)
    private String regulator;

    @Column(nullable = false)
    private String auditType;

    @Column(nullable = false)
    private String priority;

    @Column
    private String circularReference;

    @Column(columnDefinition = "TEXT")
    private String description;


    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column
    private String frequency;
    
    @Column
    private String status;

    @Column
    private List<String> milestones;
    
    @Column
    private Date date;


    @Column
    private String leadAuditor;

  
    @Column(name = "team_member")
    private List<String> teamMembers;

    
    @Column(name = "policy")
    private List<String> policiesInScope;

    @Column(columnDefinition = "TEXT")
    private String notes;

}
