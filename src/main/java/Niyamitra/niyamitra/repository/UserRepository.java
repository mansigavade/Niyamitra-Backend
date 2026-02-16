package Niyamitra.niyamitra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Niyamitra.niyamitra.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    
    Optional<User> findByEmailOrManageremail(String email, String manageremail);
 
      

   
}
