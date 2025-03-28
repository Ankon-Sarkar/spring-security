package spring.security.authentication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.security.authentication.model.CustomUserDetails;
import spring.security.authentication.model.Users;
import spring.security.authentication.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
@Qualifier("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements
    UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users user = userRepository.findByUsername(username);
    if (user == null) {
      log.error("User not found");
      throw new UsernameNotFoundException(username);
    }
    return new CustomUserDetails(user);
  }
}
