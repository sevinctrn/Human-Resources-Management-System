package springboot.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import springboot.hrms.entities.abstracts.User;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "employees")
//@PrimaryKeyJoinColumn(name="id")
public class Employee extends User {

	@NotBlank(message="İsim Alanı Boş olamaz")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Soyisim Alanı Boş olamaz")
	@Column(name="last_name")
	private String lastName;
	
	@Column(name = "verify")
	private boolean verify;

}
