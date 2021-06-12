package springboot.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

	List<JobExperience> findAllByResumeIdOrderByEndedDateDesc(int id);
}