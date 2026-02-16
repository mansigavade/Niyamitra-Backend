package Niyamitra.niyamitra.dto;

import lombok.Data;

@Data
public class ControlDTO {

    private Long id;

    private String controlName;
    private String frequency;
    private String description;
    private String owner;
    private String riskCategory;
    private String map;
    private String title;

    // Auditor fields
    private String status;
    private String checklist;
    private String result;
    private Integer testedSize;
    private String observation;
}
