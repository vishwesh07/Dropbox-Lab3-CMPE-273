package com.service;

import com.entity.Groups;
import com.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Groups> getAllMembers(String name){
        return groupRepository.findByGroupName(name);
    }

    public void addMember(Groups groupsMember){
        groupRepository.save(groupsMember);
    }

    public List<Groups> checkMemberExists(String email){
        return groupRepository.findByEmail(email);
    }

}