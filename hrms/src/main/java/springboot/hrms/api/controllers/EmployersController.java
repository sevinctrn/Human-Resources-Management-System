package springboot.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.hrms.business.abstracts.EmployerService;
import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.core.results.SuccessResult;
import springboot.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("api/employers")
public class EmployersController {
	

	private EmployerService employerService;
	
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping(path = "save")
	public Result save(@RequestBody Employer employer) {
		
		this.employerService.save(employer);
		
		return new SuccessResult("başarılı");
	}

	@GetMapping(path = "getall")
	public  DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	
	@GetMapping(path = "getbyphonenumber/{phoneNumber}")
	public DataResult<Employer> getByPhoneId(@PathVariable String phoneNumber){
		return this.employerService.getByPhoneNumber(phoneNumber);
	}


}
