package springboot.hrms.core.utilities.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import springboot.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	DataResult<?> uploadPhoto(MultipartFile file);
}
