package Niyamitra.niyamitra.repository;

import Niyamitra.niyamitra.entity.ControlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlRepository
        extends JpaRepository<ControlEntity, Long> {

    long countByResult(String result);
}
