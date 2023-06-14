package pl.adreszler.usermanager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class UserManagerController {
    private final UserRepository userRepository;

    public UserManagerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @ResponseBody
    String printUsers() {
        StringBuilder builder = new StringBuilder();
        builder.append("<h1>User list</h1>\n<ul>");
        for (User user : userRepository.getUsers()) {
            builder.append("<li>").append(user).append("</li>\n");
        }
        builder.append("</ul>");

        return builder.toString();
    }

    @GetMapping("/add")
    String addUser(@RequestParam(required = false, name = "imie") String firstName,
                   @RequestParam(required = false, name = "nazwisko") String lastName,
                   @RequestParam(required = false, name = "wiek") int age) {
        if (firstName == null || firstName.equals("")) {
            return "redirect:/err.html";
        }
        userRepository.addUser(firstName, lastName, age);
        return "redirect:/success.html";
    }
}
