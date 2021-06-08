package springboot.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.JobAdvertisementService;
import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.core.results.SuccessResult;
import springboot.hrms.dataAccess.abstracts.JobAdvertisementDao;
import springboot.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao JobAdvertisementDao;
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		JobAdvertisementDao = jobAdvertisementDao;
	}


	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.JobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş İlanı Eklendi");
	}



	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DataResult<List<JobAdvertisement>> findByIsActive() {
		// TODO Auto-generated method stub
		return null;
	}

}
