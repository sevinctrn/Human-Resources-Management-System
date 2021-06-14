package springboot.hrms.business.abstracts;

import java.util.List;

import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.dtos.EducationDto;

public interface EducationService {


	Result add(EducationDto educationDto);
	
	DataResult<List<EducationDto>> getAll();
	
	DataResult<List<EducationDto>> findAllByResumeIdOrderByEndedDateDesc(int id);
}
