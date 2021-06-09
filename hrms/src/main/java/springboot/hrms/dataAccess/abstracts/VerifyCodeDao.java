package springboot.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import springboot.hrms.entities.concretes.VerifyCode;

public interface VerifyCodeDao extends JpaRepository<VerifyCode, Integer> {
	
	VerifyCode findByCode(String Code);
	//boolean existsByVerifyCode(String Code);

}
