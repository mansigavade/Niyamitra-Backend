package Niyamitra.niyamitra.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import Niyamitra.niyamitra.dto.LoginRequestDto;
import Niyamitra.niyamitra.dto.UserRequestDto;
import Niyamitra.niyamitra.entity.User;
import Niyamitra.niyamitra.repository.UserRepository;
import Niyamitra.niyamitra.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // =========================
    // CREATE USER
    // =========================
    @Override
    public User createUser(UserRequestDto dto) {

        String role =
                (dto.getRole() == null || dto.getRole().trim().isEmpty())
                        ? "ORGANIZATION"
                        : dto.getRole();

        User user = User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(role)
                .orgname(dto.getOrgname())
                .orgtype(dto.getOrgtype())
                .contactemail(dto.getContactemail())
                .contactnumber(dto.getContactnumber())
                .address(
                	    dto.getAddress() == null || dto.getAddress().trim().isEmpty()
                	        ? "NA"
                	        : dto.getAddress()
                	)

                .manageremail(dto.getManageremail())
                .managername(dto.getManagername())
                .build();

        return userRepository.save(user);
    }


    // =========================
    // LOGIN
    // =========================
    @Override
    public User login(LoginRequestDto dto) {

        // 🔍 Try login with email OR manager email
        User user = userRepository
                .findByEmailOrManageremail(dto.getEmail(), dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔐 Password check
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // 🎭 Role validation (Organization / Super Admin)
        if (dto.getRole() != null &&
                !dto.getRole().equalsIgnoreCase(user.getRole())) {
            throw new RuntimeException("Role mismatch");
        }

        return user;
    }

    //========================
    // CRUD
    // =========================
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, UserRequestDto dto) {

        User user = getUserById(id);

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
