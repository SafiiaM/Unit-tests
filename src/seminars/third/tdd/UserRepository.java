package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if(!user.isAuthenticate) return;
        data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void reAuthentication(User user) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).name.equals(user.name)){
                user.reAuthentication();
                data.remove(i);
                break;
            }
        }
    }

    public void reAuthentication(User user, int id) {
        user.reAuthentication();
        data.remove(id);
    }

    public void reAuthenticationAll() {
        for (int i = 0; i < data.size(); i++) {
            if (!data.get(i).isAdmin)
                reAuthentication(data.get(i), i);
        }
    }
}
