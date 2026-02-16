package Niyamitra.niyamitra.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity

@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String priority;

    @Column(name = "assigned_to", nullable = false)
    private Long assignedTo; // Team member ID

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    private String category;

    @Column(name = "regulator")
    private String regulator;

    @Column(name = "attachment_path")
    private String attachmentPath;
    @Column(nullable = false)
    
    
    private String status = "PENDING"; 
    // PENDING, IN_PROGRESS, APPROVED, REJECTED
    private Integer progress = 0;

    private String approvalComment;
    private String rejectionReason;
}
