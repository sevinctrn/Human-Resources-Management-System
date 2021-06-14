package springboot.hrms.business.abstracts;

import java.util.List;

import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.dtos.TechnologyDto;

public interface TechnologyService {

Result add(TechnologyDto technologyDto);
	
	DataResult<List<TechnologyDto>> getAll();	
}
