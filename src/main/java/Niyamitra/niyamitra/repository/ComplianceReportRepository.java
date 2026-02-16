package Niyamitra.niyamitra.repository;

import Niyamitra.niyamitra.entity.ComplianceReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplianceReportRepository
        extends JpaRepository<ComplianceReport, Long> {

    List<ComplianceReport> findByBankId(Long bankId);

}
