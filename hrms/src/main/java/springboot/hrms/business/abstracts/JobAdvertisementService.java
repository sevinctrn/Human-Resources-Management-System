package springboot.hrms.business.abstracts;

import java.util.List;

import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.entities.concretes.JobAdvertisement;
import springboot.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisementDto>> findByIsActive();


}
