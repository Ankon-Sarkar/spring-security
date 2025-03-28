package spring.security.jwt.authentication.service;


import spring.security.jwt.authentication.dto.RegisterUserDto;
import spring.security.jwt.authentication.model.Users;

public interface UserAuthService {

  Users register(RegisterUserDto registerUserDto);

}
