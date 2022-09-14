package com.mindhub.skywalkies.controllers;

import com.mindhub.skywalkies.dtos.AvatarDTO;
import com.mindhub.skywalkies.dtos.ClientDTO;
import com.mindhub.skywalkies.models.Avatar;
import com.mindhub.skywalkies.repositories.AvatarRepository;
import com.mindhub.skywalkies.services.AvatarService;
import com.mindhub.skywalkies.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController

public class AvatarController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AvatarService avatarService;

    @GetMapping("/api/avatars")
    public List<AvatarDTO> getAvatars(){
        return avatarService.getAllAvatars().stream().map(client -> new AvatarDTO(new Avatar())).collect(toList());
    }

    @GetMapping("/api/avatars/{id}")
    public AvatarDTO getAvatar(@PathVariable long id){

        return new AvatarDTO(avatarService.getAvatarsById(id));
    }
}
