package Niyamitra.niyamitra.repository;

import Niyamitra.niyamitra.entity.EvidenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EvidenceRepository
extends JpaRepository<EvidenceEntity, Long> {

long countByStatus(String status);
}
