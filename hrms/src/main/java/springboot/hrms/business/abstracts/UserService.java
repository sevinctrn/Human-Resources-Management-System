package springboot.hrms.business.abstracts;

import springboot.hrms.entities.abstracts.User;

public interface UserService {
	
	
	void save(User user);
	boolean existsByMail(String mail);
}
