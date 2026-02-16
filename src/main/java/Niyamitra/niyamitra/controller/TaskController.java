package Niyamitra.niyamitra.controller;

import Niyamitra.niyamitra.dto.TaskDTO;
import Niyamitra.niyamitra.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor   // ⭐ MAGIC
@CrossOrigin("*")
public class TaskController {

    private final TaskService taskService;


    // ✅ CREATE
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(
            @RequestBody TaskDTO dto){

        return ResponseEntity.ok(taskService.createTask(dto));
    }


    // ✅ GET BY ID
    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable Long id){

        return taskService.getTaskById(id);
    }


    // ✅ GET ALL
    @GetMapping
    public List<TaskDTO> getAll(){

        return taskService.getAllTasks();
    }
    
    


    // ✅ UPDATE
    @PutMapping("/{id}")
    public TaskDTO updateTask(
            @PathVariable Long id,
            @RequestBody TaskDTO dto){

        return taskService.updateTask(id, dto);
    }


    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){

        taskService.deleteTask(id);

        return ResponseEntity.ok("Task deleted successfully");
    }


    // 🔥 APPROVE
    @PutMapping("/{id}/approve")
    public TaskDTO approveTask(
            @PathVariable Long id,
            @RequestParam(required = false) String comment){

        return taskService.approveTask(id, comment);
    }


    // 🔥 REJECT
    @PutMapping("/{id}/reject")
    public TaskDTO rejectTask(
            @PathVariable Long id,
            @RequestParam String reason){

        return taskService.rejectTask(id, reason);
    }
}
