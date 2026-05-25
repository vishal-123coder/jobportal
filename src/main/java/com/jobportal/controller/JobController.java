package com.jobportal.controller;

import com.jobportal.dto.JobRequest;
import com.jobportal.entity.Job;
import com.jobportal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {

        this.jobService = jobService;
    }

    @PostMapping
    public Job createJob(
            @Valid @RequestBody JobRequest request
    ){
        Job job = new Job();

        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setSalary(request.getSalary());

        return jobService.createJob(job);
    }

    @GetMapping
    public List<Job> getAllJobs(){

        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJob(@PathVariable Long id){

        return jobService.getJobById(id);
    }

    @GetMapping("/search")
    public Page<Job> searchJobs(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size
    ) {
        return jobService.searchJobs(
                keyword,
                page,
                size
        );
    }
}
