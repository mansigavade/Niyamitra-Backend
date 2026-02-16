package Niyamitra.niyamitra.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "finding_audit")
@Data
public class findingaudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String severity;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String relatedcontrol;

    @Column(name = "duedate", nullable = false)
    private LocalDate duedate;

    @Column(nullable = false)
    private String owener;

    @Column(nullable = false)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String recommendation;
}
