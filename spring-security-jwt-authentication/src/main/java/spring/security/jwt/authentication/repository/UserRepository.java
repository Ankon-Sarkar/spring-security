package spring.security.jwt.authentication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.jwt.authentication.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

  Users findByUsername(String username);
}
