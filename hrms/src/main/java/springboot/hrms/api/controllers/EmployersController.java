package springboot.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.hrms.business.abstracts.EmployerService;
import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.core.utilities.results.SuccessDataResult;
import springboot.hrms.core.utilities.results.SuccessResult;
import springboot.hrms.entities.concretes.Employer;
import springboot.hrms.entities.concretes.EmployerPhone;

@RestController
@RequestMapping(path ="api/employers/")
public class EmployersController {
	

	private EmployerService employerService;
	
	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping(path = "save")
	public Result save(@Valid @RequestBody Employer employer) {
		return this.employerService.save(employer);
		
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
