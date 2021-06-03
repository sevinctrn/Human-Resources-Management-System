package springboot.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.hrms.adapters.MernisAdapterService;
import springboot.hrms.business.abstracts.CandidateService;
import springboot.hrms.business.abstracts.UserService;
import springboot.hrms.business.abstracts.VerifyCodeService;
import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.ErrorDataResult;
import springboot.hrms.core.results.ErrorResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.core.results.SuccessDataResult;
import springboot.hrms.core.results.SuccessResult;
import springboot.hrms.dataAccess.abstracts.CandidateDao;
import springboot.hrms.entities.concretes.Candidate;
import springboot.hrms.entities.concretes.VerifyCode;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private MernisAdapterService mernisAdapterSevice;
	private UserService userService; 
	private VerifyCodeService verifyCodeService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,@Qualifier("fakeMernis") MernisAdapterService mernisAdapterService,
			UserService userService,VerifyCodeService verifyCodeService ) {
		super();
		this.candidateDao = candidateDao;
		this.mernisAdapterSevice= mernisAdapterService;
		this.userService = userService;
		this.verifyCodeService=verifyCodeService;
	}
	
	@Override
	public Result verifyData(Candidate candidate) {
		
		if(!this.mernisAdapterSevice.checkIdentityControl(candidate)) {
			return new ErrorResult("Mernis Kimlik Doğrulaması Başarısız Oldu");
		}
		if (this.candidateDao.existsByIdentificationNumber(candidate.getIdentificationNumber())) {
			System.out.println("TC Kimlik Numarası Daha Önce Kullanıldı");
			return new ErrorResult("TC Kimlik Numarası Daha Önce Kullanıldı");
		}
		if(userService.existsByMail(candidate.getMail())) {
			System.out.println("Mail Adresi Daha Önce Kullanıldı");
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (candidate.getPassword().equals(candidate.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		if(candidate.isVerify()) {
			return new ErrorResult("Kayıtlı kullanıcı");
		}
	
		
		
		return new SuccessResult("Kayıt Başarılı");
	}
	
	@Override
	public DataResult<Candidate> save(Candidate candidate) {
		
		
		Result result =verifyData(candidate);
		if(!result.isSuccess()) {
				return new ErrorDataResult<Candidate>(candidate,"Islem basarısız");
		}
		candidate.setVerify(false);
		candidateDao.save(candidate);
		String code =verifyCodeService.createVerifyCode(candidate);
		verifyCodeService.sendMail(candidate.getMail());
		Result resultConfirmMail =verifyCodeService.confirmMail(code);
	
		candidate.setVerify(true);
		candidateDao.save(candidate);
		//Mail Onaylandıysa
//		if(resultConfirmMail.isSuccess()) {
//			update(candidate);
//		}
		return new SuccessDataResult<Candidate>(candidate,"Kayıt Başarılı");
		
	
	}
	
	@Override
	public DataResult<Candidate> update(Candidate candidate) {
	
		candidate.setVerify(true);
		candidateDao.save(candidate);
		return new SuccessDataResult<Candidate>(candidate,"Kayıt Güncellendi");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {	
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listelendi");
	}

	

}
