package springboot.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.UserService;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.core.utilities.results.SuccessDataResult;
import springboot.hrms.dataAccess.abstracts.UserDao;
import springboot.hrms.entities.abstracts.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public Result save(User user) {
		return new SuccessDataResult<User>(userDao.save(user), "Kayıt Başarılı");
		
	}

	@Override
	public boolean existsByMail(String mail) {
	
		return this.userDao.existsByMail(mail); 
		
	}

	



}
