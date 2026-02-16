package Niyamitra.niyamitra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Niyamitra.niyamitra.dto.PolicyDTO;
import Niyamitra.niyamitra.service.PolicyService;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin(origins = "*")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<PolicyDTO> createPolicy(@RequestBody PolicyDTO policyDTO) {
        return new ResponseEntity<>(
                policyService.createPolicy(policyDTO),
                HttpStatus.CREATED
        );
    }

    // ✅ READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PolicyDTO> getPolicyById(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    // ✅ READ ALL
    @GetMapping
    public ResponseEntity<List<PolicyDTO>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PolicyDTO> updatePolicy(
            @PathVariable Long id,
            @RequestBody PolicyDTO policyDTO) {

        return ResponseEntity.ok(policyService.updatePolicy(id, policyDTO));
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return ResponseEntity.ok("Policy deleted successfully");
    }
}
