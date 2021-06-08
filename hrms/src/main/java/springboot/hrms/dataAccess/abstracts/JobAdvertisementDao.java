package springboot.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> findByIsActive(boolean status);
	List<JobAdvertisement> findByIsActiveOrderByClosedDate(boolean status);
	List<JobAdvertisement> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);

}
