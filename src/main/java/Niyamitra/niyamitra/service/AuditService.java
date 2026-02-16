package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.AuditDto;

import java.util.List;

public interface AuditService {

    AuditDto createAudit(AuditDto auditDto);

    AuditDto getAuditById(Long id);

    List<AuditDto> getAllAudits();

    AuditDto updateAudit(Long id, AuditDto auditDto);

    void deleteAudit(Long id);
}
