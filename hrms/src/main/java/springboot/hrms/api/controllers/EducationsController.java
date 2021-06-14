package springboot.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.hrms.business.abstracts.EducationService;
import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.dtos.EducationDto;
@CrossOrigin
@RestController
@RequestMapping(path= "api/education/")
public class EducationsController {
	
private EducationService educationService;
	

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
		
	}
	
	@GetMapping(path= "getall")
	public DataResult<List<EducationDto>> getAll(){
		return this.educationService.getAll();
	}
	
	@GetMapping(path="getOrderByDate")
	public DataResult<List<EducationDto>> findAllByResumeIdOrderByEndedDateDesc(int id){
		return this.educationService.findAllByResumeIdOrderByEndedDateDesc(id);
	}
	
	@PostMapping(path="add")
	public Result add(@Valid @RequestBody EducationDto educationDto) {
		return this.educationService.add(educationDto);
	  }
	
	

}
