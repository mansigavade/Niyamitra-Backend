package Niyamitra.niyamitra.entity;

import java.sql.Time;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "evidences")
public class EvidenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String control;

    @Column(nullable = false)
    private String period;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fileData;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType; // application/pdf

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column
    private String status; // SUBMITTED / VERIFIED / REJECTED
    
    @Column
    private String username;
    
    @Column
    private Time time;
   
}
