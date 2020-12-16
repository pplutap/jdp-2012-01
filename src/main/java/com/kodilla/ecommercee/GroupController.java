package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto createGroup(GroupDto groupDto) {
        return new GroupDto(1L, "Test Group");
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroupById")
    public GroupDto getGroupById(long id) {
        return new GroupDto(2L, "Test Group by Id");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(GroupDto groupDto) {
        return new GroupDto(1L, "Edited test Group");
    }
}
