package Niyamitra.niyamitra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {

    private Long id;

    // ✅ Prevent null + empty + spaces
    @NotBlank(message = "Task name is required")
    @Size(max = 255, message = "Task name cannot exceed 255 characters")
    private String taskName;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description too long")
    private String description;

    // ⭐ Better later convert to ENUM
    @NotBlank(message = "Priority is required")
    private String priority;

    @NotNull(message = "Assigned user is required")
    private Long assignedTo;

    // 🔥 VERY IMPORTANT (Fix date parsing forever)
    @NotNull(message = "Due date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    private String category;

    private String regulator;

    private String attachmentPath;
    
    private String status;
    private Integer progress;
    private String approvalComment;
    private String rejectionReason;

}
