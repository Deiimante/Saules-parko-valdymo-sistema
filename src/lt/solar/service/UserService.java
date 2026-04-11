package lt.solar.service;

import lt.solar.dto.LoginRequest;
import lt.solar.entity.User;
import lt.solar.repository.UserRepository;
import lt.solar.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public UserService(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        //  PAPRASTAS PASSWORD CHECK
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}