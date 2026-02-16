package Niyamitra.niyamitra.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import Niyamitra.niyamitra.dto.ScheduleNewAuditDTO;
import Niyamitra.niyamitra.entity.ScheduleNewAudit;
import Niyamitra.niyamitra.entity.AuditStatus;
import Niyamitra.niyamitra.repository.ScheduleNewAuditRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleNewAuditServiceImpl implements ScheduleNewAuditService {

    private final ScheduleNewAuditRepository repository;

    // ✅ CREATE AUDIT
    @Override
    public ScheduleNewAuditDTO save(ScheduleNewAuditDTO dto) {

        ScheduleNewAudit audit = new ScheduleNewAudit();

        audit.setAuditName(dto.getAuditName());
        audit.setAuditType(dto.getAuditType());
        audit.setRegulator(dto.getRegulator());
        audit.setPriority(dto.getPriority());
        audit.setDescription(dto.getDescription());

        audit.setStartDate(dto.getStartDate());
        audit.setEndDate(dto.getEndDate());

        audit.setFrequency(dto.getFrequency());
        audit.setCircularReference(dto.getCircularReference());
        audit.setLeadAuditor(dto.getLeadAuditor());
        audit.setTeamMembers(dto.getTeamMembers());

        // ✅ STATUS FIX (ENUM SAFE)
        AuditStatus status = dto.getStatus() != null
                ? AuditStatus.valueOf(dto.getStatus().toUpperCase())
                : AuditStatus.SCHEDULED;

        audit.setStatus(status);

        // ✅ PROGRESS AUTO SET
        if (status == AuditStatus.IN_PROGRESS) {
            audit.setProgress(10.0);
        } else if (status == AuditStatus.COMPLETED) {
            audit.setProgress(100.0);
        } else {
            audit.setProgress(0.0);
        }

        ScheduleNewAudit saved = repository.save(audit);

        // ✅ RETURN DTO
        ScheduleNewAuditDTO response = new ScheduleNewAuditDTO();
        response.setAuditName(saved.getAuditName());
        response.setAuditType(saved.getAuditType());
        response.setRegulator(saved.getRegulator());
        response.setPriority(saved.getPriority());
        response.setDescription(saved.getDescription());
        response.setStartDate(saved.getStartDate());
        response.setEndDate(saved.getEndDate());
        response.setFrequency(saved.getFrequency());
        response.setCircularReference(saved.getCircularReference());
        response.setLeadAuditor(saved.getLeadAuditor());
        response.setTeamMembers(saved.getTeamMembers());
        response.setStatus(saved.getStatus().name());
        response.setProgress(saved.getProgress());

        return response;
    }

    // ✅ READ ALL AUDITS
    @Override
    public List<ScheduleNewAuditDTO> getAllAudits() {

        return repository.findAll()
                .stream()
                .map(audit -> {
                    ScheduleNewAuditDTO dto = new ScheduleNewAuditDTO();

                    dto.setAuditName(audit.getAuditName());
                    dto.setAuditType(audit.getAuditType());
                    dto.setRegulator(audit.getRegulator());
                    dto.setPriority(audit.getPriority());
                    dto.setDescription(audit.getDescription());
                    dto.setStartDate(audit.getStartDate());
                    dto.setEndDate(audit.getEndDate());
                    dto.setFrequency(audit.getFrequency());
                    dto.setCircularReference(audit.getCircularReference());
                    dto.setLeadAuditor(audit.getLeadAuditor());
                    dto.setTeamMembers(audit.getTeamMembers());
                   
                    dto.setProgress(audit.getProgress());
                    dto.setStatus(
                    	    audit.getStatus() != null 
                    	        ? audit.getStatus().name() 
                    	        : "SCHEDULED"
                    	);


                    return dto;
                })
                .collect(Collectors.toList());
    }

    // ✅ GET AUDIT BY ID
    @Override
    public ScheduleNewAuditDTO getAuditById(Long id) {

        ScheduleNewAudit audit = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Audit not found"));

        ScheduleNewAuditDTO dto = new ScheduleNewAuditDTO();

        dto.setAuditName(audit.getAuditName());
        dto.setAuditType(audit.getAuditType());
        dto.setRegulator(audit.getRegulator());
        dto.setPriority(audit.getPriority());
        dto.setDescription(audit.getDescription());
        dto.setStartDate(audit.getStartDate());
        dto.setEndDate(audit.getEndDate());
        dto.setFrequency(audit.getFrequency());
        dto.setCircularReference(audit.getCircularReference());
        dto.setLeadAuditor(audit.getLeadAuditor());
        dto.setTeamMembers(audit.getTeamMembers());
        dto.setStatus(audit.getStatus().name());
        dto.setProgress(audit.getProgress());

        return dto;
    }

    // ✅ DELETE AUDIT
    @Override
    public void deleteAudit(Long id) {
        repository.deleteById(id);
    }
}
