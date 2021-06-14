package springboot.hrms.business.abstracts;

import java.util.List;

import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.dtos.LanguageDto;

public interface LanguageService {
	Result add(LanguageDto languageDto);
	DataResult<List<LanguageDto>> getAll();
}
