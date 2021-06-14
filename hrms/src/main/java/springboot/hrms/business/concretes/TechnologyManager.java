package springboot.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.TechnologyService;
import springboot.hrms.core.utilities.dtoConverter.DtoConverterService;
import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.core.utilities.results.SuccessDataResult;
import springboot.hrms.core.utilities.results.SuccessResult;
import springboot.hrms.dataAccess.abstracts.TechnologyDao;
import springboot.hrms.entities.concretes.Technology;
import springboot.hrms.entities.dtos.TechnologyDto;

@Service
public class TechnologyManager implements TechnologyService{
	
	private TechnologyDao technologyDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao, DtoConverterService dtoConverterService) {
		super();
		this.technologyDao = technologyDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(TechnologyDto technologyDto) {
		technologyDao.save((Technology) dtoConverterService.dtoClassConverter(technologyDto, Technology.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<TechnologyDto>> getAll() {
		return new SuccessDataResult<List<TechnologyDto>>
		(dtoConverterService.dtoConverter(technologyDao.findAll(),TechnologyDto.class),"Başarıyla Listelendi");
	}

}
