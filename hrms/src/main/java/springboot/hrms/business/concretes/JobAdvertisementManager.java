package springboot.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.JobAdvertisementService;
import springboot.hrms.core.dtoConverter.DtoConverterService;
import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.core.results.SuccessDataResult;
import springboot.hrms.core.results.SuccessResult;
import springboot.hrms.dataAccess.abstracts.JobAdvertisementDao;
import springboot.hrms.entities.concretes.JobAdvertisement;
import springboot.hrms.entities.dtos.JobAdvertisementAddDto;
import springboot.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao JobAdvertisementDao;
	private DtoConverterService dtoConverterService;
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,DtoConverterService dtoConverterService) {
		super();
		this.JobAdvertisementDao = jobAdvertisementDao;
		this.dtoConverterService=dtoConverterService;
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActive() {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(dtoConverterService.dtoConverter(JobAdvertisementDao.findByIsActive(true),JobAdvertisementDto.class),"Aktif İş İlanları Listelendi");
	}
	
	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
		this.JobAdvertisementDao.save((JobAdvertisement) dtoConverterService.dtoClassConverter(jobAdvertisementAddDto, JobAdvertisement.class));
		return new SuccessResult("İş İlanı Eklendi");
	}



	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.JobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("Silme işlemi Tamamlandı");
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveOrderByClosedDate() {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(dtoConverterService.dtoConverter(JobAdvertisementDao.findByIsActiveOrderByClosedDate(true),JobAdvertisementDto.class),"Tarihe göre listelendi ");
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(dtoConverterService.dtoConverter(JobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(true,companyName),JobAdvertisementDto.class),"Firmaya ait ilanlar listelendi ");
	}




}
