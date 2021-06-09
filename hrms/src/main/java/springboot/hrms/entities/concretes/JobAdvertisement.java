package springboot.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
@Table(name="job_advertisements")
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = JobPosition.class)
	@JoinColumn(name = "job_position_id", referencedColumnName =  "id")
	private JobPosition jobPosition;

	@ManyToOne(targetEntity = City.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "city_id", referencedColumnName =  "id" )
	private City city;
	
	
	@ManyToOne(targetEntity = Employer.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employer_id", referencedColumnName =  "id" )
	private Employer employer;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="job_description")
	private String description;
	
	@Column(name="is_active")
	private boolean isActive=false;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="closed_date")
	private Date closedDate;
	
	@Column(name="open_position")
	private int openPositionNumber;
	
	

}
