package springboot.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.EducationService;
import springboot.hrms.core.utilities.dtoConverter.DtoConverterService;
import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.core.utilities.results.SuccessDataResult;
import springboot.hrms.core.utilities.results.SuccessResult;
import springboot.hrms.dataAccess.abstracts.EducationDao;
import springboot.hrms.entities.concretes.Education;
import springboot.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService {


	private EducationDao educationDao;
	private DtoConverterService dtoConverterService;
		
	@Autowired
	public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
		super();
		this.educationDao = educationDao;
		this.dtoConverterService = dtoConverterService;
	}
		
	@Override
	public Result add(EducationDto educationDto) {
		educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<EducationDto>> getAll() {
		return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAll(), EducationDto.class));
		
	}

	@Override
	public DataResult<List<EducationDto>> findAllByResumeIdOrderByEndedDateDesc(int id) {
		return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAllByResumeIdOrderByEndedDateDesc(id), EducationDto.class));
	}

	
}
