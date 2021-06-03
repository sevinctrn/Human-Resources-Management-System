package springboot.hrms.adapters;


import springboot.hrms.entities.concretes.Candidate;


public interface MernisAdapterService {

	boolean checkIdentityControl(Candidate candidate);
	
}
