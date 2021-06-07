package springboot.hrms.business.abstracts;

import springboot.hrms.core.results.Result;
import springboot.hrms.entities.abstracts.User;

public interface UserService {
	
	
	Result save(User user);
	boolean existsByMail(String mail);
}
