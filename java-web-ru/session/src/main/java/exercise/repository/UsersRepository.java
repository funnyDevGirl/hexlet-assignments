package exercise.repository;

import java.util.List;
import exercise.model.User;
import exercise.util.Generator;

public class UsersRepository {
    private static List<User> entities = Generator.getUsers();

    public static void save(User user) {
        user.setId((long) entities.size() + 1);
        entities.add(user);
    }

    public static List<User> search(String term) {
        return entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
    }

    public static User find(Long id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public static User findByName(String name) {
        return entities.stream()
                .filter(entity -> entity.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public static boolean existsByName(String name) {
        return entities.stream()
                .anyMatch(value -> value.getName().equals(name));
    }

    public static List<User> getEntities() {
        return entities;
    }

    public static void clear() {
        entities.clear();
    }
}
