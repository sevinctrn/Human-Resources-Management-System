package springboot.hrms.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import springboot.hrms.entities.concretes.Employer;
import springboot.hrms.entities.concretes.EmployerPhone;

public interface EmployerPhoneDao  extends JpaRepository<EmployerPhone, Integer> {
	List<EmployerPhone> findAllByEmployerId(@Param("Id") int userId);
	//Optional<Employer> findAllByPhonesPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
