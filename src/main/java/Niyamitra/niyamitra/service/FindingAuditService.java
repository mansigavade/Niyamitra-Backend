package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.FindingAuditDto;
import java.util.List;

public interface FindingAuditService {

    FindingAuditDto createFinding(FindingAuditDto dto);

    FindingAuditDto getFindingById(Long id);

    List<FindingAuditDto> getAllFindings();

    FindingAuditDto updateFinding(Long id, FindingAuditDto dto);

    void deleteFinding(Long id);
}
