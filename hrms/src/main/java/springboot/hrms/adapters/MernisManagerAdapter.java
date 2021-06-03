package springboot.hrms.adapters;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service("mernis")
public class MernisManagerAdapter implements MernisAdapterService {

	@Override
	public boolean checkIdentityControl(Candidate candidate) {
		
		KPSPublicSoapProxy kpsPublic= new KPSPublicSoapProxy();
		
		boolean result=true;
	
		try {
		
			result=kpsPublic.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentificationNumber()), candidate.getFirstName().toUpperCase(new Locale("tr")),
				candidate.getLastName().toUpperCase(),candidate.getBirthDate().getYear());

		} catch (Exception e) {
            e.printStackTrace();
		}
            return result;
	}



}