package springboot.hrms.business.abstracts;

import java.util.List;

import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.concretes.Graduate;

public interface GraduateService {

	DataResult<List<Graduate>> getAll();
	Result add(Graduate graduate);
	
}
