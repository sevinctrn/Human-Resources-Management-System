package springboot.hrms.entities.dtos;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.hrms.entities.concretes.Education;
import springboot.hrms.entities.concretes.JobExperience;
import springboot.hrms.entities.concretes.Language;
import springboot.hrms.entities.concretes.Technology;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeGetDto {
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private int candidateId;
	private String candidateFirstName;
	private String candidateLastName;
	private String githubLink;
	private String linkedLink;
	private String photo;
	private String description;
	private Date createdDate;
	private Date updatedDate;
	private List<JobExperience> jobExperiences;
	private List<Language> languages;
	private List<Technology> technologies;
	private List<Education> education;
}
