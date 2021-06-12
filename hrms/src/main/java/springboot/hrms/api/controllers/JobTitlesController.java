package springboot.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.hrms.business.abstracts.JobTitleService;
import springboot.hrms.core.results.DataResult;
import springboot.hrms.entities.concretes.JobTitle;

@CrossOrigin
@RestController
@RequestMapping(path= "api/job-titles/")
public class JobTitlesController {
	
	private final JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
//	@PostMapping("save")
//	public Result save(@RequestBody JobTitle jobTitle) {
//		jobTitleService.save(jobTitle);
//		return new SuccessResult("başarılı");
//	}
	
	@GetMapping(path ="getall")
	public DataResult<List<JobTitle>> getAll(){
		 var result =jobTitleService.getAll();
		return result;
	}
	

	@GetMapping(path ="getbytitle/{title}") 
	public  DataResult<JobTitle> getByTitle(@PathVariable String title) {
		return jobTitleService.getByTitle(title);
	}
	
	@PostMapping(path ="add")
	public  DataResult<JobTitle>  add(@RequestBody JobTitle jobTitle) {
		 
		return this.jobTitleService.save(jobTitle);
	}

}
