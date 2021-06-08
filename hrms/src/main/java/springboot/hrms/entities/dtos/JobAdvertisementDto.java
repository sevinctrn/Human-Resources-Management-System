package springboot.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	
	private String employerCompanyName;
	private String jobPositionPositionName;
	private int JobAdvertisementOpenPositionNumber;
	private Date JobAdvertisementCreatedDate;
	private Date JobAdvertisementClosedDate;

}
