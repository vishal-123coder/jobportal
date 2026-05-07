package com.jobportal.controller;

import com.jobportal.entity.Job;
import com.jobportal.service.JobService;
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
    public Job createJob(@RequestBody Job job){
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
}
