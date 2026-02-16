package Niyamitra.niyamitra.repository;

import Niyamitra.niyamitra.entity.findingaudit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FindingAuditRepository
        extends JpaRepository<findingaudit, Long> {

    long countByStatusIn(List<String> status);
}
