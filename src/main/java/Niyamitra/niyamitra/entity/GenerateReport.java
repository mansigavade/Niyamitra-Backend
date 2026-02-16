package Niyamitra.niyamitra.entity;

import Niyamitra.niyamitra.enums.ReportStatus;
import Niyamitra.niyamitra.enums.ReportType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "generated_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenerateReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //-----------------------------------------
    // Bank ID
    //-----------------------------------------
    @Column(name = "bank_id", nullable = false)
    private Long bankId;

    //-----------------------------------------
    // ENUMS
    //-----------------------------------------

    @Enumerated(EnumType.STRING)
    @Column(name = "report_type", nullable = false)
    private ReportType reportType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private ReportStatus status = ReportStatus.IN_PROGRESS;

    //-----------------------------------------
    // Dates
    //-----------------------------------------

    private LocalDate startDate;
    private LocalDate endDate;

    @CreationTimestamp
    @Column(name = "generated_at", updatable = false)
    private LocalDateTime generatedAt;


    //-----------------------------------------
    // Sections
    //-----------------------------------------

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "generated_report_sections", // ⭐ CHANGE THIS
            joinColumns = @JoinColumn(name = "report_id")
    )
    @Column(name = "section")
    @Builder.Default
    private List<String> sections = new ArrayList<>();


    //-----------------------------------------
    // Notes
    //-----------------------------------------

    @Column(columnDefinition = "TEXT")
    private String notes;

    //-----------------------------------------
    // Audit Fields
    //-----------------------------------------

    @Column(name = "generated_by", nullable = false)
    private Long generatedBy;

    private String fileUrl;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    //-----------------------------------------
    // Safety Net
    //-----------------------------------------

    @PrePersist
    public void prePersist() {

        if (status == null) {
            status = ReportStatus.IN_PROGRESS;
        }
    }
}

