package lt.solar.controller;

import lt.solar.entity.User;
import org.springframework.web.bind.annotation.*;
import lt.solar.dto.LoginRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
    @GetMapping("/me")
    public String me() {
        return "Prisijungęs vartotojas aktyvus sistemoje";
    }

    @PostMapping("/logout")
    public String logout() {
        return "Atsijungta";
    }
}