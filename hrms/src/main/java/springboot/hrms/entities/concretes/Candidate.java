package springboot.hrms.entities.concretes;


import java.util.Date;

//import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import springboot.hrms.entities.abstracts.User;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
@Table(name="candidates")
//@PrimaryKeyJoinColumn(name="id")
public class Candidate extends User {


	@NotBlank(message="İsim Alanı Boş olamaz")
	@Column(name="first_name")
	private String firstName;
	
	
	@NotBlank(message="Soyisim Alanı Boş olamaz")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message="TC Kimlik Numarası Alanı Boş Olamaz")
	@Column(name="identification_number")
	private String identificationNumber;
	
//	@NotBlank(message="Doğum Yılı Alanı Boş Olamaz")
	@Column(name="birth_Date")
	private Date birthDate;

	@JsonIgnore
	@Column(name = "verify")
	private boolean verify =false;
}
