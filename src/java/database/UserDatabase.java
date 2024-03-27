package database;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
  private static final Map<String, User> users = new HashMap<>();

    public static void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public static User getUser(String username) {
        return users.get(username);
    }
}
