package springboot.hrms.business.abstracts;

import java.util.List;

import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.entities.concretes.Candidate;
import springboot.hrms.entities.concretes.Employer;
import springboot.hrms.entities.concretes.EmployerPhone;

public interface EmployerService {
	
	 DataResult save(Employer employer);
	 DataResult<List<Employer>> getAll();
	 DataResult<Employer> getByPhoneNumber(String phoneNumber);
	 Result verifyData(Employer employer);

}
