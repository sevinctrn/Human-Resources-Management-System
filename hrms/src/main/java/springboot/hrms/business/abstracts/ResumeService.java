package springboot.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.concretes.Resume;
import springboot.hrms.entities.dtos.ResumeAddDto;
import springboot.hrms.entities.dtos.ResumeGetDto;

public interface ResumeService {
	
	Result add(ResumeAddDto resumeDto);
	
	DataResult<List<ResumeGetDto>> getAll();
	
	DataResult<List<ResumeGetDto>> findAllByCandidateId(int id);
	
	Result saveImage(MultipartFile file, int resumeId);
}

