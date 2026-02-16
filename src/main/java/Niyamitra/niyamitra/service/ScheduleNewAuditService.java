package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.ScheduleNewAuditDTO;

import java.util.List;

public interface ScheduleNewAuditService {

    ScheduleNewAuditDTO save(ScheduleNewAuditDTO dto);

    List<ScheduleNewAuditDTO> getAllAudits();

    ScheduleNewAuditDTO getAuditById(Long id);

    void deleteAudit(Long id);
}
