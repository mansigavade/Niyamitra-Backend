package Niyamitra.niyamitra.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "policies")
public class PolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String regulator;

    @Column(nullable = false, unique = true)
    private String circularReference;

    @Column(nullable = false)
    private LocalDate effectiveDate;

    @Column(nullable = false)
    private String version;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;
}
