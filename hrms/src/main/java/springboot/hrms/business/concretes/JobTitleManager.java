package springboot.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.JobTitleService;
import springboot.hrms.dataAccess.abstracts.JobTitleDao;
import springboot.hrms.entities.concretes.JobTitle;
import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.SuccessDataResult;

@Service
public class JobTitleManager  implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}


	@Override
	public DataResult<JobTitle> save(JobTitle jobTitle) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.save(jobTitle),"Kayıt Başarılı");
	}


	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Data listelendi");
	}


	@Override
	public DataResult<JobTitle> getByTitle(String title) {
		return new SuccessDataResult(this.jobTitleDao.findByTitle(title));
	}



}
