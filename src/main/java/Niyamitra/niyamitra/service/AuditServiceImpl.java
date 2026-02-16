package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.AuditDto;
import Niyamitra.niyamitra.entity.AuditEntity;
import Niyamitra.niyamitra.repository.AuditRepository;
import Niyamitra.niyamitra.service.AuditService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public AuditDto createAudit(AuditDto dto) {
        AuditEntity entity = mapToEntity(dto);
        AuditEntity saved = auditRepository.save(entity);
        return mapToDto(saved);
    }

    @Override
    public AuditDto getAuditById(Long id) {
        AuditEntity entity = auditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Audit not found with id " + id));
        return mapToDto(entity);
    }

    @Override
    public List<AuditDto> getAllAudits() {
        return auditRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuditDto updateAudit(Long id, AuditDto dto) {
        AuditEntity entity = auditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Audit not found with id " + id));

        entity.setAuditName(dto.getAuditName());
        entity.setRegulator(dto.getRegulator());
        entity.setAuditType(dto.getAuditType());
        entity.setPriority(dto.getPriority());
        entity.setCircularReference(dto.getCircularReference());
        entity.setDescription(dto.getDescription());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setFrequency(dto.getFrequency());
        entity.setStatus(dto.getStatus());
        entity.setMilestones(dto.getMilestones());
        entity.setDate(dto.getDate());
        entity.setLeadAuditor(dto.getLeadAuditor());
        entity.setTeamMembers(dto.getTeamMembers());
        entity.setPoliciesInScope(dto.getPoliciesInScope());
        entity.setNotes(dto.getNotes());

        return mapToDto(auditRepository.save(entity));
    }

    @Override
    public void deleteAudit(Long id) {
        auditRepository.deleteById(id);
    }

    // ===== Mapper Methods =====

    private AuditEntity mapToEntity(AuditDto dto) {
        AuditEntity entity = new AuditEntity();
        entity.setId(dto.getId());
        entity.setAuditName(dto.getAuditName());
        entity.setRegulator(dto.getRegulator());
        entity.setAuditType(dto.getAuditType());
        entity.setPriority(dto.getPriority());
        entity.setCircularReference(dto.getCircularReference());
        entity.setDescription(dto.getDescription());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setFrequency(dto.getFrequency());
        entity.setStatus(dto.getStatus());
        entity.setMilestones(dto.getMilestones());
        entity.setDate(dto.getDate());
        entity.setLeadAuditor(dto.getLeadAuditor());
        entity.setTeamMembers(dto.getTeamMembers());
        entity.setPoliciesInScope(dto.getPoliciesInScope());
        entity.setNotes(dto.getNotes());
        return entity;
    }

    private AuditDto mapToDto(AuditEntity entity) {
        AuditDto dto = new AuditDto();
        dto.setId(entity.getId());
        dto.setAuditName(entity.getAuditName());
        dto.setRegulator(entity.getRegulator());
        dto.setAuditType(entity.getAuditType());
        dto.setPriority(entity.getPriority());
        dto.setCircularReference(entity.getCircularReference());
        dto.setDescription(entity.getDescription());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setFrequency(entity.getFrequency());
        dto.setStatus(entity.getStatus());
        dto.setMilestones(entity.getMilestones());
        dto.setDate(entity.getDate());
        dto.setLeadAuditor(entity.getLeadAuditor());
        dto.setTeamMembers(entity.getTeamMembers());
        dto.setPoliciesInScope(entity.getPoliciesInScope());
        dto.setNotes(entity.getNotes());
        return dto;
    }
}
