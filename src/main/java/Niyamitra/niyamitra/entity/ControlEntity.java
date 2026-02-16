package Niyamitra.niyamitra.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "controls")
public class ControlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String controlName;

    @Column
    private String frequency;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private String owner;

    @Column
    private String riskCategory;

    @Column
    private String map;

    @Column
    private String title;
    
    @Column
    private String status = "COMPLIANT";
    
    @Column
    private String checklist;

    @Column
    private String result;

    @Column(name = "tested_size")
    private Integer testedSize;


    @Column
    private String observation;

}

