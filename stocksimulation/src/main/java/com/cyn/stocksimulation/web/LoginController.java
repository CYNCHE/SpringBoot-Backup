package com.cyn.stocksimulation.web;


import com.cyn.stocksimulation.form.UserForm;
import com.cyn.stocksimulation.pojo.User;
import com.cyn.stocksimulation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/stockpeak")
public class LoginController {

  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String index() {

    return "login";
  }

  @PostMapping("/home")
  public String indexOutput(@RequestParam String email, @RequestParam String password,
                            HttpSession session, RedirectAttributes redirectAttributes) {

    User user = userService.getUserByEmail(email);
    if (user == null) {
      redirectAttributes.addFlashAttribute("message", "Please register first.");
      return "redirect:/login";
    } else if (!user.checkPassword(password)) {
      System.out.println("here");
      redirectAttributes.addFlashAttribute("message", "Your password is incorrect.");
      return "redirect:/login";
    }

    user.setPassword(null);
    session.setAttribute("user", user);
    return "home";

  }


  @GetMapping("/registration")
  public String registerPage(Model model) {
    model.addAttribute("userForm", new UserForm());
    return "register";
  }

  //backend validation for registration info
  @PostMapping("/registration")
  public String register(@Valid UserForm userForm, BindingResult result) {
    if (!userForm.checkPassword())
      result.rejectValue("confirmPassword", "PasswordError", "Two Passwords do not match!");

    if (result.hasErrors()) return "register";

    User user = userForm.convertToUser();
    // this email has been registered before
    if (userService.getUserByEmail(user.getEmail()) != null) {
      result.rejectValue("email", "EmailError", "This email address has been used.");
      return "register";
    }
    userService.saveUser(user);
    return "redirect:/stockpeak/login";
  }
}
