package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.TaskDTO;
import java.util.List;

public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO);

    TaskDTO getTaskById(Long id);

    List<TaskDTO> getAllTasks();

    TaskDTO updateTask(Long id, TaskDTO taskDTO);

    void deleteTask(Long id);

    // 🔥 NEW (VERY IMPORTANT)
    TaskDTO approveTask(Long id, String comment);

    TaskDTO rejectTask(Long id, String reason);
    
}
