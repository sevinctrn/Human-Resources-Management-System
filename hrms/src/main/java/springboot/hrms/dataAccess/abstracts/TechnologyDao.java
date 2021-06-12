package springboot.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.hrms.entities.concretes.Technology;


public interface TechnologyDao extends JpaRepository<Technology, Integer> {

}

