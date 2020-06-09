package pl.s18280.squashclub.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.s18280.squashclub.command.domain.registration.User;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_seq", initialValue = 500)
    private Long id;
    private String username;
    private String email;
    private String password;

    public UserEntity(User user) {
        this.username = user.getUsername().getValue();
        this.email = user.getEmail().getValue();
        this.password = user.getPassword().getValue();
    }

    public pl.s18280.squashclub.command.domain.registration.User toCommandUser() {
        return new pl.s18280.squashclub.command.domain.registration.User(this.username, this.email, this.password);
    }

    public pl.s18280.squashclub.query.domain.login.User toQueryUser() {
        return new pl.s18280.squashclub.query.domain.login.User(this.username, this.password);
    }
}
