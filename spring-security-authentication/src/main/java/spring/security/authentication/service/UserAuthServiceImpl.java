package spring.security.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.security.authentication.dto.RegisterUserDto;
import spring.security.authentication.model.Users;
import spring.security.authentication.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Users register(RegisterUserDto registerUserDto) {
    Users user = Users.builder()
        .id(registerUserDto.getId())
        .username(registerUserDto.getUserName())
        .password(passwordEncoder.encode(registerUserDto.getPassword())).build();
    return userRepository.save(user);
  }
}
