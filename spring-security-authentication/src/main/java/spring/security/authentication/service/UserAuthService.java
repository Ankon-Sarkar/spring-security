package spring.security.authentication.service;

import spring.security.authentication.dto.RegisterUserDto;
import spring.security.authentication.model.Users;

public interface UserAuthService {

  Users register(RegisterUserDto registerUserDto);
}
