package springboot.hrms.adapters.mernis;

import org.springframework.stereotype.Service;

import springboot.hrms.entities.concretes.Candidate;

@Service("fakeMernis")
public class FakeMernisManagerAdapter implements MernisAdapterService{

	@Override
	public boolean checkIdentityControl(Candidate candidate) {

		return true;
	}

}
