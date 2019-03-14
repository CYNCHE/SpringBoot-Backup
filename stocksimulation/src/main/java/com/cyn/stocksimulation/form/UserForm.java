package com.cyn.stocksimulation.form;

import com.cyn.stocksimulation.pojo.User;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserForm {

  @NotBlank
  private String username;
  @NotBlank
  private String password;
  @NotBlank(message = "Email can not be blank!")
  @Email(message = "Invalid email address!")
  private String email;
  @NotBlank(message = "Password can not be blank!")
  private String confirmPassword;

  public UserForm() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public boolean checkPassword() {
    System.out.println(password);
    System.out.println(confirmPassword);
    return (password.equals(confirmPassword));
  }

  public User convertToUser() {
    User user = new UserFormConvert().convert(this);
    return user;
  }

  private class UserFormConvert implements FormConvert<UserForm, User> {
    @Override
    public User convert(UserForm userForm) {
      User user = new User();
      BeanUtils.copyProperties(userForm, user);
      return user;
    }
  }
}
