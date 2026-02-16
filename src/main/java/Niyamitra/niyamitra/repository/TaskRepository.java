package Niyamitra.niyamitra.repository;

import Niyamitra.niyamitra.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // 🔥 STATUS BASED
    List<Task> findByStatus(String status);

    // 🔥 PRIORITY BASED
    List<Task> findByPriority(String priority);

    // 🔥 ASSIGNED USER
    List<Task> findByAssignedTo(Long assignedTo);

    // 🔥 STATUS + USER
    List<Task> findByStatusAndAssignedTo(String status, Long assignedTo);
    
    

    // 🔥 DASHBOARD COUNTS (VERY IMPORTANT)
    long countByStatus(String status);

    long countByPriority(String priority);
    
    

    // 🔥 SEARCH (Manager loves this 😄)
    List<Task> findByTaskNameContainingIgnoreCase(String keyword);

    // 🔥 MULTI SEARCH
    List<Task> findByTaskNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String taskName,
            String description
    );

}
