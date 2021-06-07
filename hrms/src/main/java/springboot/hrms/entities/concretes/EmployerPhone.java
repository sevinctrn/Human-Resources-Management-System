package springboot.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name="employer_phones")
public class EmployerPhone{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	

	@ManyToOne
	@JoinColumn(name = "employer_id" )
	private Employer employer;

	@Column(name = "phone_number")
	private String phoneNumber;

	
}