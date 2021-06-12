package springboot.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.JobPositionService;
import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.core.results.SuccessDataResult;
import springboot.hrms.core.results.SuccessResult;
import springboot.hrms.dataAccess.abstracts.JobPositionDao;
import springboot.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"İş Pozisyonları Listelendi");
	}

	@Override
	public Result add(JobPosition jobPositions) {
		jobPositionDao.save(jobPositions);
		return new SuccessResult("İş Pozisyonu Eklendi");
				
	}

}
