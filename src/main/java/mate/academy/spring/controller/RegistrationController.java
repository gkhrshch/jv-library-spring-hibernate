package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.dto.UserRegistrationDto;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping()
    public String addUserPage(Model model) {
        model.addAttribute("userDto", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String addUser(@ModelAttribute @Valid UserRegistrationDto userDto,
                          BindingResult result) {
        User newUser = new User(userDto.getFirstName(), userDto.getLastName(),
                userDto.getEmail(), userDto.getUsername(),
                passwordEncoder.encode(userDto.getPassword()));
        if (result.hasErrors()) {
            return "errorPage";
        }
        userService.add(newUser);
        return "login";
    }
}
