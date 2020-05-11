package com.git.sample.controller;

import com.git.sample.model.FollwerOwner;
import com.git.sample.model.Items;
import com.git.sample.service.GitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitController {
    @Autowired
    GitService gitService;


    @GetMapping(value = "/hotRepo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Items> getHotRepos() {
        return gitService.getHotRepos();
    }


    @GetMapping(value = "/zeroFollower", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FollwerOwner> getZeroFollowers() {
        return gitService.getZeroFollowers();
    }


}
