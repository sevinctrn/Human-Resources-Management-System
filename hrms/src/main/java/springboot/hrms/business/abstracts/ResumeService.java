package springboot.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.concretes.Resume;

public interface ResumeService {
	
	Result add(Resume resumeDto);
	
	DataResult<List<Resume>> getAll();
	
	DataResult<List<Resume>> findAllByCandidateId(int id);
	
	Result saveImage(MultipartFile file, int resumeId);
}

