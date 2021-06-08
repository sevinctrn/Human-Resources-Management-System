package springboot.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.hrms.core.results.DataResult;
import springboot.hrms.entities.concretes.JobAdvertisement;
import springboot.hrms.business.abstracts.JobAdvertisementService;

@RestController
@RequestMapping("api/jobAdvertisement")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping(path = "getall")
	DataResult<List<JobAdvertisement>> findByIsActive(){
		return this.jobAdvertisementService.findByIsActive();
	}
	
	
	
}
