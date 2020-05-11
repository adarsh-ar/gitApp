package com.git.sample.service;

import com.git.sample.adapter.GitAdapter;
import com.git.sample.model.FollowerItem;
import com.git.sample.model.FollwerOwner;
import com.git.sample.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GitService {
    @Autowired
    GitAdapter gitAdapter;
    public List<Items> getHotRepos(){
        System.out.println("hh");
        return gitAdapter.getHotRepos().getBody().getItems().stream().filter(Objects::nonNull)
                 .collect(Collectors.toList());
    }

    public List<FollwerOwner> getZeroFollowers() {
        return gitAdapter.getZeroFollowers().getBody().getItems().stream().filter(Objects::nonNull)
                .map(FollowerItem::getOwner)
                .collect(Collectors.toList());
    }
}
