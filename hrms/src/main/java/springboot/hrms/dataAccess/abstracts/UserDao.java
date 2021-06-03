package springboot.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import springboot.hrms.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	boolean existsByMail(String mail);
}
