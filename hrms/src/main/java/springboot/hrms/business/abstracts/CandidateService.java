package springboot.hrms.business.abstracts;

import java.util.List;

import springboot.hrms.core.utilities.results.DataResult;
import springboot.hrms.core.utilities.results.Result;
import springboot.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult save(Candidate candidate);
	DataResult<List<Candidate>> getAll();
	Result verifyData(Candidate candidate);
	DataResult update(Candidate candidate);

}
