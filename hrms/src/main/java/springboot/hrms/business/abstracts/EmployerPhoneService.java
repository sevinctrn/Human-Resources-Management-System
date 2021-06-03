package springboot.hrms.business.abstracts;

import java.util.List;

import springboot.hrms.entities.concretes.EmployerPhone;

public interface EmployerPhoneService {
	
	List<EmployerPhone> getAll();
	List<EmployerPhone> getByUserId(int userId);

}
