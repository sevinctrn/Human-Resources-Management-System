package springboot.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	
	List<Resume> findAllByCandidateId(int id);
	
}
