package springboot.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	boolean existsByIdentificationNumber(String identificationNumber);
}