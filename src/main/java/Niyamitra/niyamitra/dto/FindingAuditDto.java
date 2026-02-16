package Niyamitra.niyamitra.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FindingAuditDto {

    private Long id;
    private String title;
    private String severity;
    private String description;
    private String relatedcontrol;
    private LocalDate duedate;
    private String owener;
    private String status;
    private String recommendation;
}
