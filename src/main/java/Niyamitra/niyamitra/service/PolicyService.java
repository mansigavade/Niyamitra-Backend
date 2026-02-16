package Niyamitra.niyamitra.service;

import java.util.List;

import Niyamitra.niyamitra.dto.PolicyDTO;

public interface PolicyService {

    PolicyDTO createPolicy(PolicyDTO policyDTO);

    PolicyDTO getPolicyById(Long id);

    List<PolicyDTO> getAllPolicies();

    PolicyDTO updatePolicy(Long id, PolicyDTO policyDTO);

    void deletePolicy(Long id);
}
