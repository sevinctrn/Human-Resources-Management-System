package springboot.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.entities.concretes.Employer;
import springboot.hrms.entities.concretes.JobTitle;

public interface JobTitleService { 
	
	DataResult<JobTitle> save(JobTitle jobTitle);
	DataResult<List<JobTitle>> getAll();
	DataResult<JobTitle> getByTitle(String title);

}
