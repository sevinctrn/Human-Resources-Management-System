package springboot.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.EmployerService;
import springboot.hrms.business.abstracts.UserService;
import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.ErrorDataResult;
import springboot.hrms.core.results.ErrorResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.core.results.SuccessDataResult;
import springboot.hrms.core.results.SuccessResult;
import springboot.hrms.dataAccess.abstracts.EmployerDao;
import springboot.hrms.entities.concretes.Candidate;
import springboot.hrms.entities.concretes.Employer;

@Service
public class EmployerManager  implements EmployerService{
	
	private EmployerDao employerDao;
	private UserService userService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,UserService userService) {
		super();
		this.employerDao = employerDao;
		this.userService=userService;
	}

	@Override
	public Result verifyData(Employer employer) {
		
		String[] mailControl = employer.getMail().split("@");
		
		if (!mailControl[1].equals(employer.getWebAddress())) {
			return new ErrorResult("Web sitesi ile aynı domaine sahip bir mail adresiyle kaydolabilirsiniz");
		}
		
		if(employer.getCompanyName()==null) {
			return new ErrorResult("Şirketi olmayanlar kaydolamaz");
		}
		
		if(userService.existsByMail(employer.getMail())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (employer.getPassword().equals(employer.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
	
		return new SuccessResult("Kayıt Başarılı");
	}
	
	@Override
	public DataResult save(Employer employer) {
		
		Result result =verifyData(employer);
		
		if(!result.isSuccess()) {
				return new ErrorDataResult(employer,"Islem basarısız");
		}
		this.employerDao.save(employer);
		return new SuccessDataResult(employer,"Kayıt Başarılı");
		
	
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listelendi");
	}



	@Override
	public  DataResult<Employer>  getByPhoneNumber(String phoneNumber) {
	
		return null;
	}


}
