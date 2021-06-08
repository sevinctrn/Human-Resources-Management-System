package springboot.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.hrms.core.results.DataResult;
import springboot.hrms.entities.concretes.JobAdvertisement;
import springboot.hrms.entities.dtos.JobAdvertisementDto;
import springboot.hrms.business.abstracts.JobAdvertisementService;

@RestController
@RequestMapping("api/jobAdvertisement")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping(path = "getActive")
	DataResult<List<JobAdvertisementDto>> findByIsActive(){
		return this.jobAdvertisementService.findByIsActive();
	}
	
	
	
}
