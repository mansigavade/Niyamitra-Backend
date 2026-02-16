package Niyamitra.niyamitra.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import Niyamitra.niyamitra.enums.ReportFormat;
import Niyamitra.niyamitra.enums.ReportStatus;
import Niyamitra.niyamitra.enums.ReportType;

@Entity
@Table(name = "compliance_reports")
public class ComplianceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ===============================
       CORE REPORT DATA
    =============================== */

    @Column(nullable = false)
    private Long bankId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private Niyamitra.niyamitra.enums.ReportType reportType;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    private String regulator;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "report_sections",
            joinColumns = @JoinColumn(name = "report_id")
    )
    @Column(name = "section")
    private List<String> includeSections;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Niyamitra.niyamitra.enums.ReportFormat format;

    @Column(length = 2000)
    private String additionalNotes;

    /* ===============================
       REPORT EXECUTION
    =============================== */

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportStatus status;

    private String fileUrl;

    @Column(nullable = false)
    private Long generatedBy;

    private LocalDateTime generatedAt;

    /* ===============================
       AUDIT FIELDS
    =============================== */

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /* ===============================
       AUTO TIMESTAMPS
    =============================== */

    @PrePersist
    public void onCreate() {

        this.createdAt = LocalDateTime.now();
        this.generatedAt = LocalDateTime.now();

        if (this.status == null) {
            this.status = ReportStatus.GENERATING;
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    /* ===============================
       BUSINESS METHODS (VERY SENIOR PRACTICE)
    =============================== */

    public void markCompleted(String fileUrl) {
        this.fileUrl = fileUrl;
        this.status = ReportStatus.COMPLETED;
    }

    public void markFailed() {
        this.status = ReportStatus.FAILED;
    }

    /* ===============================
       GETTERS & SETTERS
    =============================== */

    public Long getId() {
        return id;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getRegulator() {
        return regulator;
    }

    public void setRegulator(String regulator) {
        this.regulator = regulator;
    }

    public List<String> getIncludeSections() {
        return includeSections;
    }

    public void setIncludeSections(List<String> includeSections) {
        this.includeSections = includeSections;
    }

    public ReportFormat getFormat() {
        return format;
    }

    public void setFormat(ReportFormat format) {
        this.format = format;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public Long getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Long generatedBy) {
        this.generatedBy = generatedBy;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
