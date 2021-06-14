package springboot.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springboot.hrms.business.abstracts.ResumeService;
import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.concretes.Resume;

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

	@PostMapping("/add")
	public Result add(Resume resume) {
		return this.resumeService.add(resume);
	}

	@GetMapping("/getall")
	public DataResult<List<Resume>> getAll() {
		return this.resumeService.getAll();
	}


//DataResult<List<Resume>> findAllByCandidateId(int id);
//
//Result saveImage(MultipartFile file, int resumeId);



}
