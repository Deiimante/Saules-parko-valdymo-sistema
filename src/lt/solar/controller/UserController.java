package lt.solar.service;

import lt.solar.entity.Role;
import lt.solar.entity.User;
import lt.solar.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Vartotojas nerastas"));
    }

    public User update(Long id, User user) {
        User existing = userRepository.findById(id).orElseThrow();

        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setActive(user.isActive());

        return userRepository.save(existing);
    }

    public User updateRole(Long id, String role) {
        User user = userRepository.findById(id).orElseThrow();

        user.setRole(Role.valueOf(role.toUpperCase()));

        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}