package springboot.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.EmployerPhoneService;
import springboot.hrms.dataAccess.abstracts.EmployerPhoneDao;
import springboot.hrms.entities.concretes.EmployerPhone;

@Service
public class EmployerPhoneManager  implements EmployerPhoneService{

	private EmployerPhoneDao employerPhoneDao;
	
	@Autowired
	public EmployerPhoneManager(EmployerPhoneDao employerPhoneDao) {
		super();
		this.employerPhoneDao = employerPhoneDao;
	}

	@Override
	public List<EmployerPhone> getAll() {
		return this.employerPhoneDao.findAll();
	}

	@Override
	public List<EmployerPhone> getByUserId(int userId) {
		return this.employerPhoneDao.findAllByEmployerId(userId);
	}
}
