package Niyamitra.niyamitra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Niyamitra.niyamitra.entity.PolicyEntity;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyEntity, Long> {

    boolean existsByCircularReference(String circularReference);
}
