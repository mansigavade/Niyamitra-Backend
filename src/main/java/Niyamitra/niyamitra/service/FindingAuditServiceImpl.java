package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.FindingAuditDto;
import Niyamitra.niyamitra.entity.findingaudit;
import Niyamitra.niyamitra.repository.FindingAuditRepository;
import Niyamitra.niyamitra.service.FindingAuditService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindingAuditServiceImpl implements FindingAuditService {

    private final FindingAuditRepository repository;

    public FindingAuditServiceImpl(FindingAuditRepository repository) {
        this.repository = repository;
    }

    // Entity → DTO
    private FindingAuditDto toDto(findingaudit e) {
        FindingAuditDto d = new FindingAuditDto();
        d.setId(e.getId());
        d.setTitle(e.getTitle());
        d.setSeverity(e.getSeverity());
        d.setDescription(e.getDescription());
        d.setRelatedcontrol(e.getRelatedcontrol());
        d.setDuedate(e.getDuedate());
        d.setOwener(e.getOwener());
        d.setStatus(e.getStatus());
        d.setRecommendation(e.getRecommendation());
        return d;
    }

    // DTO → Entity
    private findingaudit toEntity(FindingAuditDto d) {
        findingaudit e = new findingaudit();
        e.setId(d.getId());
        e.setTitle(d.getTitle());
        e.setSeverity(d.getSeverity());
        e.setDescription(d.getDescription());
        e.setRelatedcontrol(d.getRelatedcontrol());
        e.setDuedate(d.getDuedate());
        e.setOwener(d.getOwener());
        e.setStatus(d.getStatus());
        e.setRecommendation(d.getRecommendation());
        return e;
    }

    @Override
    public FindingAuditDto createFinding(FindingAuditDto dto) {
        return toDto(repository.save(toEntity(dto)));
    }

    @Override
    public FindingAuditDto getFindingById(Long id) {
        findingaudit e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Finding not found with id " + id));
        return toDto(e);
    }

    @Override
    public List<FindingAuditDto> getAllFindings() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FindingAuditDto updateFinding(Long id, FindingAuditDto dto) {
        findingaudit e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Finding not found with id " + id));

        e.setTitle(dto.getTitle());
        e.setSeverity(dto.getSeverity());
        e.setDescription(dto.getDescription());
        e.setRelatedcontrol(dto.getRelatedcontrol());
        e.setDuedate(dto.getDuedate());
        e.setOwener(dto.getOwener());
        e.setStatus(dto.getStatus());
        e.setRecommendation(dto.getRecommendation());

        return toDto(repository.save(e));
    }

    @Override
    public void deleteFinding(Long id) {
        repository.deleteById(id);
    }
}
