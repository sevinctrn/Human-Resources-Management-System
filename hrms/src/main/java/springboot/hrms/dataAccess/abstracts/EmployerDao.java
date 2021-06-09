package springboot.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.hrms.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer> {

}