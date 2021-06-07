package springboot.hrms.business.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.business.abstracts.UserService;
import springboot.hrms.business.abstracts.VerifyCodeService;
import springboot.hrms.core.results.DataResult;
import springboot.hrms.core.results.ErrorDataResult;
import springboot.hrms.core.results.ErrorResult;
import springboot.hrms.core.results.Result;
import springboot.hrms.core.results.SuccessDataResult;
import springboot.hrms.core.results.SuccessResult;
import springboot.hrms.dataAccess.abstracts.VerifyCodeDao;
import springboot.hrms.entities.abstracts.User;
import springboot.hrms.entities.concretes.VerifyCode;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class VerifyCodeManager implements VerifyCodeService {
	
	private VerifyCodeDao verifyCodeDao;
	private UserService userService;
	
	@Autowired
	public VerifyCodeManager(VerifyCodeDao verifyCodeDao,UserService userService) {
		super();
		this.verifyCodeDao = verifyCodeDao;
		this.userService=userService;
	}


	@Override
	public Result update(VerifyCode verifyCode) {
		
		LocalDate localDate = (LocalDate.now());
		verifyCode.setVerifyDate(Date.valueOf(localDate));
		verifyCode.setVerified(true);
		return new SuccessResult("VerifyCode güncellenmiştir");	
		
	}
	
	@Override
	public Result confirmMail(String code) {

	VerifyCode verifyCode=verifyCodeDao.getByCode(code);
	if(verifyCode.isVerified()) {
		return new ErrorResult("Mail daha önce onaylanmıştır");
	}
	
		verifyCode.getUser().setVerify(true);
		this.userService.save(verifyCode.getUser());
		
		update(verifyCode);
		
		return new SuccessResult("Mail onaylanmıştır");	
	
		
	}
	

	@Override
	public String createVerifyCode(User user) {
		
		String randomCode = UUID.randomUUID().toString();
		System.out.println(randomCode);
		
		LocalDate localDate = (LocalDate.now());
	
		VerifyCode verifyCode = new VerifyCode();
		verifyCode.setUser(user);
		verifyCode.setCreatedDate(Date.valueOf(localDate));
		verifyCode.setCode(randomCode);	
		this.verifyCodeDao.save(verifyCode);
		
		return randomCode;
	}


	@Override
	public Result sendMail(String mail) {
		return new SuccessResult("Mail Gönderildi");
	}
	
	
	

}
