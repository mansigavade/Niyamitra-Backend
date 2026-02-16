package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.ControlDTO;

import java.util.List;

public interface ControlService {

    ControlDTO createControl(ControlDTO dto);

    ControlDTO getControlById(Long id);

    List<ControlDTO> getAllControls();

    ControlDTO updateControl(Long id, ControlDTO dto);

    void deleteControl(Long id);
}
