package com.jobportal.controller;

import com.jobportal.entity.User;
import com.jobportal.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(
            value = "/{id}/resume",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String uploadResume(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file
    ) throws Exception {

        return userService.uploadResume(id, file);
    }
}
