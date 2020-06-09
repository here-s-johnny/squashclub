package pl.s18280.squashclub.common.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.s18280.squashclub.common.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
    UserEntity getByUsername(String username);
}
