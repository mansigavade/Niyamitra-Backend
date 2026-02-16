package Niyamitra.niyamitra.dto;

import java.sql.Time;

import lombok.Data;

@Data
public class EvidenceDTO {

    private Long id;
    private String control;
    private String period;
    private String notes;
    private String status;

    private String fileName;
    private String fileType;
    private String username;
    private Time time;
}
