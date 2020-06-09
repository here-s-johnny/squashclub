package pl.s18280.squashclub.query.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.s18280.squashclub.common.entity.UserEntity;
import pl.s18280.squashclub.common.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
class UsersDatabaseAdapter {

    private final UserRepository userRepository;

    User getByUsername(String username) {
        UserEntity userEntity = userRepository.getByUsername(username);
        if (userEntity == null) {
            return null;
        }
        return userEntity.toQueryUser();
    }
}
