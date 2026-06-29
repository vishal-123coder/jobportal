package com.jobportal.service;

import com.jobportal.cloud.CloudinaryService;
import com.jobportal.entity.User;
import com.jobportal.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    private final CloudinaryService cloudinaryService;
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder,
                       CloudinaryService cloudinaryService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.cloudinaryService = cloudinaryService;
    }

    public User saveUser(User user) {

        logger.info("Registering new user with email: {}", user.getEmail());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        logger.info("User registered successfully. User ID: {}", savedUser.getId());

        return savedUser;
    }

    public List<User> getAllUsers() {

        logger.info("Fetching all users");

        return userRepository.findAll();
    }

    public String uploadResume(
            Long userId,
            MultipartFile file
    ) throws Exception {

        logger.info("Resume upload requested for userId: {}", userId);

        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            String url = cloudinaryService.uploadResume(file);

            user.setResumeUrl(url);
            userRepository.save(user);

            logger.info("Resume upload successful for userId: {}", userId);

            return url;
        } catch (Exception e) {
            logger.error("Resume  upload failed for userId: {}", userId, e);

            throw e;
        }
    }
}
