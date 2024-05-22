package com.example.reusheduler.controller;

import com.example.reusheduler.model.Group;
import com.example.reusheduler.repository.GroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @PostMapping("/fill/group")
    public ResponseEntity<Object> objectResponseEntity(@RequestParam Long groupNumber,
                                                       @RequestParam String direction){
        if(groupRepository.existsByGroupNumber(groupNumber))
            return ResponseEntity.badRequest().build();
        else {
            Group groupDB = groupRepository.findFirstByOrderByIdDesc();

            Group group = Group.builder()
                    .id(groupDB.getId()+1)
                    .groupNumber(groupNumber)
                    .direction(direction)
                    .build();
            groupRepository.save(group);

            return ResponseEntity.ok().build();
        }
    }

}
