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
	public Result add(Resume resume) {
		resumeDao.save(resume);
		return new SuccessResult("CV Kaydedilmiştir");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
			
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll(),"Cv Listelendi");
	}

	@Override
	public DataResult<List<Resume>> findAllByCandidateId(int id) {
		// TODO Auto-generated method stub
		return null;
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
