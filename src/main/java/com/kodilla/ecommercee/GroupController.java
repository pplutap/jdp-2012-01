package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/group")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class GroupController {
    private final DbService service;
    private final GroupMapper groupMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        List<Group> group = service.getAllGroups();
        return groupMapper.mapToGroupDtoList(group);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        Group group = groupMapper.mapToGroup(groupDto);
        service.saveGroup(group);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroupById")
    public GroupDto getGroupById(@RequestBody long id) throws OrderNotFoundException {
        return groupMapper.mapToGroupDto(
                service.getGroup(id).orElseThrow(OrderNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        Group group = groupMapper.mapToGroup(groupDto);
        Group savedGroup = service.saveGroup(group);
        return groupMapper.mapToGroupDto(savedGroup);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGroup")
    public void deleteGroup(@RequestBody Long id) {
        service.deleteGroup(id);
    }
}
