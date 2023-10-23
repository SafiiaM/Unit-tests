package seminars.third.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    static UserRepository repository;
    @BeforeAll
    static void setUp(){
        repository = new UserRepository();
    }

    @Test
    void checkAuthenticateUserPositive(){
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, password);
        assertTrue(accept);
    }

    @Test
    void checkAuthenticateUserNegative(){
        String name = "name";
        String password = "password";
        String wrongPassword = "wrongPassword";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, wrongPassword);
        assertFalse(accept);
    }

    @Test
    void checkRepositoryAddAuthenticatedUserPositive(){
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size())
                .isEqualTo(currentCount + 1);

        User userInRepository =
                repository.data.get(repository.data.size() - 1);

        assertEquals(user, userInRepository);
    }

    @Test
    void checkRepositoryAddNotAuthenticatedUserNegative(){
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size())
                .isEqualTo(currentCount);
    }

    @Test
    void reAuthenticatedUser() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);
        repository.addUser(user);
        user.reAuthentication();

        assertFalse(user.isAuthenticate);
    }
    @Test
    void reAuthenticatedUserFromId() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);
        int currentCount = repository.data.size();
        repository.addUser(user);
        repository.reAuthentication(user, currentCount);

        assertFalse(user.isAuthenticate);
    }

    @Test
    void reAuthenticatedInRepo() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);
        repository.addUser(user);
        int currentCount = repository.data.size();
        repository.reAuthentication(user);

        assertThat(repository.data.size())
                .isEqualTo(currentCount - 1);
    }


    @Test
    void reAuthenticatedAllUsersNotAdmins() {
        String adminName = "admin";
        String adminPassword = "123";
        String userName = "name";
        String userPassword = "password";

        User admin = new User(adminName, adminPassword, true);
        admin.authenticate(adminName, adminPassword);
        repository.addUser(admin);
        User user = new User(userName, userPassword, false);
        user.authenticate(userName, userPassword);
        repository.addUser(user);
        int currentCount = repository.data.size();
        repository.reAuthenticationAll();

        assertThat(repository.data.size()).isEqualTo(currentCount - 1);
    }
}
