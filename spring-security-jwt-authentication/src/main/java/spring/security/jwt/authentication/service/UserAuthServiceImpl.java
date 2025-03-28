package spring.security.jwt.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.security.jwt.authentication.dto.RegisterUserDto;
import spring.security.jwt.authentication.model.Users;
import spring.security.jwt.authentication.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  @Override
  public Users register(RegisterUserDto registerUserDto) {
    Users user = Users.builder()
        .id(registerUserDto.getId())
        .username(registerUserDto.getUserName())
        .password(passwordEncoder.encode(registerUserDto.getPassword())).build();
    return userRepository.save(user);
  }
}
