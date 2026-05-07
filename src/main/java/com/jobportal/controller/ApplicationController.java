package com.jobportal.controller;

import com.jobportal.entity.Application;
import com.jobportal.service.ApplicationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @PostMapping("/{jobId}/{userId}")
    public Application apply(@PathVariable Long jobId, @PathVariable Long userId) {
        return applicationService.apply(jobId, userId);
    }
}
