package springboot.hrms.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


import springboot.hrms.core.utilities.cloudinary.CloudinaryManager;
import springboot.hrms.core.utilities.cloudinary.CloudinaryService;

@Configuration
public class CloudinaryConfig {


		@Bean
	    public Cloudinary cloudinaryUser(){
	 		
	 		
	        return new Cloudinary(ObjectUtils.asMap(
	        	
	        		"cloud_name", "x",
	                "api_key", "x",
	                "api_secret", "x"));
	    }

	    @Bean
	    public CloudinaryService cloudinaryService(){
	        return new CloudinaryManager(cloudinaryUser());
	    }
	    

}
