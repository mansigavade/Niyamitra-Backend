package Niyamitra.niyamitra.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Niyamitra.niyamitra.dto.PolicyDTO;
import Niyamitra.niyamitra.entity.PolicyEntity;
import Niyamitra.niyamitra.repository.PolicyRepository;
import Niyamitra.niyamitra.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public PolicyDTO createPolicy(PolicyDTO dto) {

        if (policyRepository.existsByCircularReference(dto.getCircularReference())) {
            throw new RuntimeException("Policy with this Circular Reference already exists");
        }

        PolicyEntity entity = dtoToEntity(dto);
        PolicyEntity saved = policyRepository.save(entity);
        return entityToDto(saved);
    }

    @Override
    public PolicyDTO getPolicyById(Long id) {
        PolicyEntity entity = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found with id: " + id));

        return entityToDto(entity);
    }

    @Override
    public List<PolicyDTO> getAllPolicies() {
        return policyRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PolicyDTO updatePolicy(Long id, PolicyDTO dto) {

        PolicyEntity entity = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found with id: " + id));

        entity.setTitle(dto.getTitle());
        entity.setRegulator(dto.getRegulator());
        entity.setCircularReference(dto.getCircularReference());
        entity.setEffectiveDate(dto.getEffectiveDate());
        entity.setVersion(dto.getVersion());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());

        PolicyEntity updated = policyRepository.save(entity);
        return entityToDto(updated);
    }

    @Override
    public void deletePolicy(Long id) {

        if (!policyRepository.existsById(id)) {
            throw new RuntimeException("Policy not found with id: " + id);
        }

        policyRepository.deleteById(id);
    }

    // 🔁 Mapper methods
    private PolicyEntity dtoToEntity(PolicyDTO dto) {
        PolicyEntity entity = new PolicyEntity();
        entity.setTitle(dto.getTitle());
        entity.setRegulator(dto.getRegulator());
        entity.setCircularReference(dto.getCircularReference());
        entity.setEffectiveDate(dto.getEffectiveDate());
        entity.setVersion(dto.getVersion());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    private PolicyDTO entityToDto(PolicyEntity entity) {
        PolicyDTO dto = new PolicyDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setRegulator(entity.getRegulator());
        dto.setCircularReference(entity.getCircularReference());
        dto.setEffectiveDate(entity.getEffectiveDate());
        dto.setVersion(entity.getVersion());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
