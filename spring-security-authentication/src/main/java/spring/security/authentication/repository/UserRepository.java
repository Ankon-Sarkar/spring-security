package spring.security.authentication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.authentication.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

  Users findByUsername(String username);
}
