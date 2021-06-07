package springboot.hrms.business.abstracts;

import java.util.List;

import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.entities.abstracts.User;
import springboot.hrms.entities.concretes.Candidate;
import springboot.hrms.entities.concretes.Employer;
import springboot.hrms.entities.concretes.EmployerPhone;

public interface EmployerPhoneService {
	
	DataResult<List<EmployerPhone>> getAll();
	DataResult<List<EmployerPhone>> getByUserId(int userId);
	Result save(Employer employer);


}
