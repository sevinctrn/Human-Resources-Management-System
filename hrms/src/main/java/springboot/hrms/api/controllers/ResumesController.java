package springboot.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springboot.hrms.business.abstracts.ResumeService;
import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.concretes.Resume;
import springboot.hrms.entities.dtos.ResumeAddDto;
import springboot.hrms.entities.dtos.ResumeGetDto;

@CrossOrigin
@RestController
@RequestMapping(path = "api/resumes/")
public class ResumesController {
	
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}

	@PostMapping(path= "add")
	public Result add(@Valid @RequestBody ResumeAddDto resumeDto) {
		return this.resumeService.add(resumeDto);
				
	  }
	@GetMapping(path= "getall")
	public DataResult<List<ResumeGetDto>> getAll(){
		return this.resumeService.getAll();
	}

	@PutMapping(path= "uploadImage")
	public Result saveImage(@RequestBody MultipartFile file,@RequestParam int resumeId) {
		return this.resumeService.saveImage(file, resumeId);
		
	}
	
	@GetMapping(path= "getByCandidateId")
	public DataResult<List<ResumeGetDto>> findAllByCandidateId(int id){
		return this.resumeService.findAllByCandidateId(id);
	}

}
