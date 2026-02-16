package Niyamitra.niyamitra.repository;

import Niyamitra.niyamitra.entity.GenerateReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerateReportRepository
        extends JpaRepository<GenerateReport, Long> {
}
