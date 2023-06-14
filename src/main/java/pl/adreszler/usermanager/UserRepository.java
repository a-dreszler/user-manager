package pl.adreszler.usermanager;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
class UserRepository {
    private final List<User> users = new ArrayList<>();

    UserRepository() {
        //test data
        addUser("Jan", "Kowalski", 23);
        addUser("Karol", "Nowak", 33);
        addUser("Adam", "Smasher", 43);
    }

    List<User> getUsers() {
        return users;
    }

    void addUser(String firstName, String lastName, int age) {
        users.add(new User(firstName, lastName, age));
    }
}
