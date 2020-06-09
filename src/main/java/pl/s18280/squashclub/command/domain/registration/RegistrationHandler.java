package pl.s18280.squashclub.command.domain.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.s18280.squashclub.command.api.RegistrationRequest;

@Service
@RequiredArgsConstructor
public class RegistrationHandler {

    private final UserDatabaseAdapter userDatabaseAdapter;

    public RegistrationStatus handleRegistration(RegistrationRequest registrationRequest) {
        User user = userDatabaseAdapter.findByUsername(registrationRequest.getUsername());

        if (user != null) {
            return RegistrationStatus.USERNAME_TAKEN;
        }

        user = userDatabaseAdapter.findByEmail(registrationRequest.getEmail());

        if (user != null) {
            return RegistrationStatus.EMAIL_ALREADY_REGISTERED;
        }

        user = new User(registrationRequest.getUsername(), registrationRequest.getEmail(), registrationRequest.getPassword());
        userDatabaseAdapter.save(user);
        return RegistrationStatus.SUCCESS;
    }
}
