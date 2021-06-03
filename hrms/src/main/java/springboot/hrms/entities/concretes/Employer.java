package springboot.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import springboot.hrms.entities.abstracts.User;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "employers")
//@PrimaryKeyJoinColumn(name="id")
public class Employer extends User{
	

	@NotBlank(message="Şirket İsmi Alanı Boş Olamaz")
	@Column(name = "company_name")
	private String companyName;
	
	
	@NotBlank(message="Web Sitesi Alanı Boş Olamaz")
	@Column(name = "web_address")
	private String webAddress;
	
	@OneToMany(
			cascade = CascadeType.ALL,
	        mappedBy = "employer", 
	        orphanRemoval=true)
    @JsonManagedReference
    private List<EmployerPhone> phones;
	
	@Column(name = "verify")
	private boolean verify;
	
	@Column(name = "user_confirm")
	private boolean userConfirm;
	
	
}
