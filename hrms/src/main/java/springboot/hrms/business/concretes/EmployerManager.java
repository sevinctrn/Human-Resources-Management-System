package springboot.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.EmployerPhoneService;
import springboot.hrms.business.abstracts.EmployerService;
import springboot.hrms.business.abstracts.UserService;
import springboot.hrms.business.abstracts.VerifyCodeService;
import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.ErrorDataResult;
import springboot.hrms.core.utilities.results.ErrorResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.core.utilities.results.SuccessDataResult;
import springboot.hrms.core.utilities.results.SuccessResult;
import springboot.hrms.dataAccess.abstracts.EmployerDao;
import springboot.hrms.entities.concretes.Candidate;
import springboot.hrms.entities.concretes.Employer;
import springboot.hrms.entities.concretes.EmployerPhone;

@Service
public class EmployerManager  implements EmployerService{
	
	private EmployerDao employerDao;
	private UserService userService;
	private VerifyCodeService verifyCodeService;
	private EmployerPhoneService employerPhoneService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,UserService userService,VerifyCodeService verifyCodeService,EmployerPhoneService employerPhoneService) {
		super();
		this.employerDao = employerDao;
		this.userService=userService;
		this.verifyCodeService=verifyCodeService;
		this.employerPhoneService=employerPhoneService;
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
	public DataResult<Employer> save(Employer employer) {
		
		Result result =verifyData(employer);
	
		if(!result.isSuccess()) {
				return new ErrorDataResult<Employer>(employer,"Islem basarısız");
		}
	
		this.employerDao.save(employer);
	
		String code =verifyCodeService.createVerifyCode(employer);
		verifyCodeService.sendMail(employer.getMail());
		Result resultConfirmMail =verifyCodeService.confirmMail(code);
		
		employer.setVerify(true);
	    this.employerDao.save(employer);

		return new SuccessDataResult<Employer>(employer,"Kayıt Başarılı");
		
	
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
