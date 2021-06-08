package springboot.hrms.dataAccess.abstracts;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.hrms.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer> {

}