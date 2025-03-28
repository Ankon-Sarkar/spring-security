package spring.security.jwt.authentication.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.security.jwt.authentication.dto.LoginUserDto;
import spring.security.jwt.authentication.dto.RegisterUserDto;
import spring.security.jwt.authentication.service.JwtService;
import spring.security.jwt.authentication.service.UserAuthService;

@RestController
@RequiredArgsConstructor
public class UserAuthController {

  private final UserAuthService userAuthService;
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;

  @PostMapping("/api/v1/register")
  public void register(@RequestBody RegisterUserDto registerUserDto) {
    userAuthService.register(registerUserDto);
  }

  @PostMapping("/api/v1/login")
  public String login(@RequestBody LoginUserDto loginUserDto) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginUserDto.getUserName(),
            loginUserDto.getPassword()));
    return jwtService.generateJwtToken(loginUserDto.getUserName());
  }

  @GetMapping("/api/test-security")
  public String index() {
    return "Welcome to Spring Security With JWT Authentication!";
  }
}
