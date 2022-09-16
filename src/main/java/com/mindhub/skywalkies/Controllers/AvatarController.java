package com.mindhub.skywalkies.Controllers;

import com.mindhub.skywalkies.Service.AvatarService;
import com.mindhub.skywalkies.dtos.AvatarDTO;
import com.mindhub.skywalkies.repositories.AvatarRepository;
import com.mindhub.skywalkies.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AvatarController {
    @Autowired
    private AvatarService avatarService;

    @GetMapping("/avatars")
    public List<AvatarDTO> getClients(){
        return avatarService.getAllAvatars().stream().map(AvatarDTO::new).collect(Collectors.toList());
    }
}
