package springboot.hrms.entities.dtos;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyDto {
	
	@JsonIgnore
	private int id;
	
	private int resumeId;
	
	private Date createdDate;
	
	@NotBlank(message = "Açıklama Boş Bırakılamaz")
	private String description;
}
