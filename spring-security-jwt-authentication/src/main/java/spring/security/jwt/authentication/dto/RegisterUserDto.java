package spring.security.jwt.authentication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {

  private int id;

  private String email;

  private String password;

  private String userName;
  
}
