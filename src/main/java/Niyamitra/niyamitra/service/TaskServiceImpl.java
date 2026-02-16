package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.TaskDTO;
import Niyamitra.niyamitra.entity.Task;
import Niyamitra.niyamitra.repository.TaskRepository;
import Niyamitra.niyamitra.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    // ✅ CREATE
    @Override
    public TaskDTO createTask(TaskDTO dto) {

        Task task = mapToEntity(dto);

        // Default values
        task.setStatus("PENDING");
        task.setProgress(0);

        Task savedTask = taskRepository.save(task);

        return mapToDTO(savedTask);
    }

    // ✅ GET BY ID
    @Override
    public TaskDTO getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        return mapToDTO(task);
    }

    // ✅ GET ALL
    @Override
    public List<TaskDTO> getAllTasks() {

        return taskRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
   

    // ✅ UPDATE
    @Override
    public TaskDTO updateTask(Long id, TaskDTO dto) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTaskName(dto.getTaskName());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setAssignedTo(dto.getAssignedTo());
        task.setDueDate(dto.getDueDate());
        task.setCategory(dto.getCategory());
        task.setRegulator(dto.getRegulator());

        Task updated = taskRepository.save(task);

        return mapToDTO(updated);
    }

    // ✅ DELETE
    @Override
    public void deleteTask(Long id) {

        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }

        taskRepository.deleteById(id);
    }

    // 🔥🔥🔥 APPROVE TASK
    @Override
    public TaskDTO approveTask(Long id, String comment) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus("APPROVED");
        task.setProgress(100);
        task.setApprovalComment(comment);

        Task saved = taskRepository.save(task);

        return mapToDTO(saved);
    }

    // 🔥🔥🔥 REJECT TASK
    @Override
    public TaskDTO rejectTask(Long id, String reason) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus("REJECTED");
        task.setProgress(0);
        task.setRejectionReason(reason);

        Task saved = taskRepository.save(task);

        return mapToDTO(saved);
    }

    // ===============================
    // 🔥 MAPPER (VERY IMPORTANT)
    // ===============================

    private TaskDTO mapToDTO(Task task) {

        TaskDTO dto = new TaskDTO();

        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setDescription(task.getDescription());
        dto.setPriority(task.getPriority());
        dto.setAssignedTo(task.getAssignedTo());
        dto.setDueDate(task.getDueDate());
        dto.setCategory(task.getCategory());
        dto.setRegulator(task.getRegulator());
        dto.setAttachmentPath(task.getAttachmentPath());

        // workflow fields
        dto.setStatus(task.getStatus());
        dto.setProgress(task.getProgress());
        dto.setApprovalComment(task.getApprovalComment());
        dto.setRejectionReason(task.getRejectionReason());

        return dto;
    }


    private Task mapToEntity(TaskDTO dto) {

        Task task = new Task();

        task.setTaskName(dto.getTaskName());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setAssignedTo(dto.getAssignedTo());
        task.setDueDate(dto.getDueDate());
        task.setCategory(dto.getCategory());
        task.setRegulator(dto.getRegulator());
        task.setAttachmentPath(dto.getAttachmentPath());
        
        

        return task;
    }
}
