package pl.github.gpietrzyk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.gpietrzyk.domain.User;
import pl.github.gpietrzyk.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
