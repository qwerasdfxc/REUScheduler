package com.example.reusheduler.controller;

import com.example.reusheduler.model.Group;
import com.example.reusheduler.repository.GroupRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GroupController {

    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/view/groups")
    public List<Group> viewGroups(){
        List<Group> groupList = new ArrayList<>();
        groupRepository.findAll().forEach(groupList::add);

        return groupList;
    }
}
