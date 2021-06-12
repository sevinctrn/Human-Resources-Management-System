package springboot.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

	List<Education> findAllByResumeIdOrderByEndedDateDesc(int id);
	
}
