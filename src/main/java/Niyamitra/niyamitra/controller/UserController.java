package Niyamitra.niyamitra.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import Niyamitra.niyamitra.dto.LoginRequestDto;
import Niyamitra.niyamitra.dto.UserRequestDto;
import Niyamitra.niyamitra.entity.User;
import Niyamitra.niyamitra.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    // REGISTER
    @PostMapping
    public User createUser(@RequestBody UserRequestDto dto) {
        return userService.createUser(dto);
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody LoginRequestDto dto) {
        return userService.login(dto);
    }

    // CRUD
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto dto
    ) {
        return userService.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
