package pl.s18280.squashclub.command.domain.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.s18280.squashclub.common.entity.UserEntity;
import pl.s18280.squashclub.common.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
class UserDatabaseAdapter {

    private final UserRepository userRepository;

    User findByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            return null;
        }
        return userEntity.toCommandUser();
    }

    User findByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            return null;
        }
        return userEntity.toCommandUser();
    }

    void save(User user) {
        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
    }
}
