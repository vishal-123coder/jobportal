package com.jobportal.service;

import com.jobportal.entity.Job;
import com.jobportal.exception.ResourceNotFoundException;
import com.jobportal.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private static final Logger logger = LoggerFactory.getLogger(JobService.class);

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job){

        logger.info("creating job: {}", job.getTitle());

        Job savedJob = jobRepository.save(job);

        logger.info("Job created successfully: {}", savedJob.getId());

        return savedJob;
    }

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public Job getJobById(Long id){
        return jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found"));
    }
    public Page<Job> searchJobs(
            String keyword,
            int page,
            int size) {
        Pageable pageable =
                PageRequest.of(page, size);
        return jobRepository
                .findByTitleContainingIgnoreCase(
                        keyword,
                        pageable
                );
    }
}
