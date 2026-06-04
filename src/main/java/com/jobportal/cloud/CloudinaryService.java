package com.jobportal.cloud;

import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary){
        this.cloudinary = cloudinary;
    }

    public String uploadResume(MultipartFile file)
           throws Exception {
        Map<?, ?> result =
                cloudinary.uploader()
                        .upload(
                                file.getBytes(),
                                Map.of(
                                        "resource_type",
                                        "raw"
                                )
                        );
        return result.get("secure_url")
                .toString();
    }
}
