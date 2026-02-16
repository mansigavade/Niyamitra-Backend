package Niyamitra.niyamitra.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import Niyamitra.niyamitra.entity.AuditStatus;
import Niyamitra.niyamitra.entity.ScheduleNewAudit;
import Niyamitra.niyamitra.repository.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
@RequiredArgsConstructor
public class DashboardController {

    private final FindingAuditRepository findingRepo;
    private final EvidenceRepository evidenceRepo;
    private final ControlRepository controlRepo;
    private final ScheduleNewAuditRepository auditRepo;

    @GetMapping("/manager-stats")
    public Map<String, Object> getManagerStats() {

        Map<String, Object> stats = new HashMap<>();

        // OPEN FINDINGS
        long openFindings =
                findingRepo.countByStatusIn(
                        java.util.List.of("OPEN", "IN_PROGRESS")
                );

        // SCHEDULED
        long scheduled =
                auditRepo.countByStatus(AuditStatus.SCHEDULED);

        // IN PROGRESS
        List<ScheduleNewAudit> audits =
                auditRepo.findByStatus(AuditStatus.IN_PROGRESS);

        long inProgress = audits.size();

        // COMPLETED %
        long verifiedEvidence =
                evidenceRepo.countByStatus("VERIFIED");

        long passedControls =
                controlRepo.countByResult("PASS");

        long totalAudits = auditRepo.count();

        double completedPercent = 0;

        if(totalAudits > 0){
            completedPercent =
                    ((double)(verifiedEvidence + passedControls)
                            / totalAudits) * 100;
        }

        stats.put("openFindings", openFindings);
        stats.put("scheduled", scheduled);
        stats.put("inProgress", inProgress);
        stats.put("completed", Math.round(completedPercent));

        return stats;
    }
}