package kg.aiu.ecotrack.service;

import kg.aiu.ecotrack.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User loadUserByEmail(String email);

    boolean existsByEmail(String email);

    void save(User user);

    void delete(String username);
}
