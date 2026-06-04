package com.jobportal.cloud;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    private String cloudName;
    private String apiKey;
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(
                Map.of(
                        "cloud_name", "dlr0c2hlr",
                        "api_key", "165572483258856",
                        "api_secret", "_3F1xlkuSsf1uZd_QhIkZqKSur0"
                )
        );
    }
}
