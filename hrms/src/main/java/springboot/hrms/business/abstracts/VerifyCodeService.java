package springboot.hrms.business.abstracts;


import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.abstracts.User;
import springboot.hrms.entities.concretes.VerifyCode;

public interface VerifyCodeService {
	
	Result confirmMail(String code);
	String createVerifyCode(User user);
	Result sendMail(String mail);
	Result update(VerifyCode verifyCode);

	
}
