package springboot.hrms.adapters.mernis;


import springboot.hrms.entities.concretes.Candidate;


public interface MernisAdapterService {

	boolean checkIdentityControl(Candidate candidate);
	
}
