package Niyamitra.niyamitra.controller;

import Niyamitra.niyamitra.dto.ControlDTO;
import Niyamitra.niyamitra.service.ControlService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controls")
@CrossOrigin("*")
public class ControlController {

    private final ControlService controlService;

    public ControlController(ControlService controlService) {
        this.controlService = controlService;
    }

    @PostMapping
    public ControlDTO create(@RequestBody ControlDTO dto) {
        return controlService.createControl(dto);
    }

    @GetMapping
    public List<ControlDTO> getAll() {
        return controlService.getAllControls();
    }

    @GetMapping("/{id}")
    public ControlDTO getById(@PathVariable Long id) {
        return controlService.getControlById(id);
    }

    @PutMapping("/{id}")
    public ControlDTO update(
            @PathVariable Long id,
            @RequestBody ControlDTO dto
    ) {
        return controlService.updateControl(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        controlService.deleteControl(id);
    }
}
