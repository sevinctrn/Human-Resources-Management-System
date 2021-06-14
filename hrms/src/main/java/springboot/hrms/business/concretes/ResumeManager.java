package springboot.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springboot.hrms.adapters.cloudinary.CloudinaryAddService;
import springboot.hrms.business.abstracts.ResumeService;
import springboot.hrms.core.utilities.cloudinary.CloudinaryService;
import springboot.hrms.core.utilities.dtoConverter.DtoConverterService;
import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.core.utilities.results.SuccessDataResult;
import springboot.hrms.core.utilities.results.SuccessResult;
import springboot.hrms.dataAccess.abstracts.ResumeDao;
import springboot.hrms.entities.concretes.Resume;
import springboot.hrms.entities.dtos.ResumeAddDto;
import springboot.hrms.entities.dtos.ResumeGetDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	private DtoConverterService dtoConverterService;
	 
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService, DtoConverterService dtoConverterService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService=cloudinaryService;
		this.dtoConverterService = dtoConverterService;
				
	}

	@Override
	public Result add(ResumeAddDto resumeDto) {
		
		resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeDto, Resume.class));
		return new SuccessResult("CV Kaydedilmiştir");
	}

	@Override
	public DataResult<List<ResumeGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeGetDto>>(dtoConverterService.dtoConverter(resumeDao.findAll(), ResumeGetDto.class),"Data Listelendi");
		
	}
	
	@Override
	public DataResult<List<ResumeGetDto>> findAllByCandidateId(int id) {
		return new SuccessDataResult<List<ResumeGetDto>>
		(dtoConverterService.dtoConverter
				(resumeDao.findAllByCandidateId(id), ResumeGetDto.class)
				,"Data Listelendi");
	}
	
	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.uploadPhoto(file).getData(); 
		String imageUrl= uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhoto(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Kayıt Başarılı");
		
	}



}
