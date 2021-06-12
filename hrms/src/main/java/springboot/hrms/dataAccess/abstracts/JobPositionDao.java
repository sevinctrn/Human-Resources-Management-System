package springboot.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{

	boolean existsByPositionName(String position);
}
