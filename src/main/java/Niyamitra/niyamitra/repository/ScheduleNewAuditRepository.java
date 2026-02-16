package Niyamitra.niyamitra.repository;

import java.awt.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Niyamitra.niyamitra.entity.AuditStatus;
import Niyamitra.niyamitra.entity.ScheduleNewAudit;
@Repository
public interface ScheduleNewAuditRepository
        extends JpaRepository<ScheduleNewAudit, Long> {

    long countByStatus(AuditStatus status);

    java.util.List<ScheduleNewAudit> findByStatus(AuditStatus status);
}

