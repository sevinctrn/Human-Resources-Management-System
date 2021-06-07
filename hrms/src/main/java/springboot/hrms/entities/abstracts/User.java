package springboot.hrms.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Email(message = "Lütfen Geçerli Bir Mail Adresi Giriniz")
	@NotBlank(message="Mail Alanı Boş olamaz")
	@Column(name="email_adress")
	private String mail;
	
	@NotBlank(message="Şifre Alanı Boş olamaz")
	@Column(name="password")
	private String password;

	@NotBlank(message="Şifre Alanı Boş olamaz")
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	private String passwordRepeat;
	
	@JsonIgnore 
	@Column(name="verify")
	private boolean verify = false;


}
