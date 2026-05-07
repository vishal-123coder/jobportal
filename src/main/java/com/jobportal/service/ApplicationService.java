package com.jobportal.service;

import com.jobportal.controller.ApplicationController;
import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.User;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public ApplicationService(ApplicationRepository applicationRepository,
                              UserRepository userRepository,
                              JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    public Application apply(Long jobId, Long userId) {
        Job job = jobRepository
                .findById(jobId).orElseThrow(()-> new RuntimeException("Job not found"));
        User user = userRepository
                .findById(userId).orElseThrow(()-> new RuntimeException("User not found"));

        Application app = new Application();
        app.setJob(job);
        app.setUser(user);
        app.setStatus("APPLIED");

        return applicationRepository.save(app);
    }
}
