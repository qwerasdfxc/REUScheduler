package com.example.reusheduler.controller;

import com.example.reusheduler.dto.TestDTO;
import com.example.reusheduler.model.Group;
import com.example.reusheduler.repository.GroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin

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
    public ResponseEntity<Object> objectResponseEntity(@RequestBody TestDTO testDTO){
        if(!groupRepository.existsByGroupNumber(testDTO.getGroupNumber()))
            return ResponseEntity.badRequest().build();
        else {
            Group groupDB = groupRepository.findFirstByOrderByIdDesc();

            Group group = Group.builder()
                    .id(groupDB.getId()+1)
                    .groupNumber(testDTO.getGroupNumber())
                    .direction(testDTO.getDirection())
                    .build();
            groupRepository.save(group);

            return ResponseEntity.ok().build();
        }
    }

}
