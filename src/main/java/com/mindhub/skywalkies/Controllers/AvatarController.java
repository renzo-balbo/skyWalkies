package com.mindhub.skywalkies.Controllers;

import com.mindhub.skywalkies.Service.AvatarService;
import com.mindhub.skywalkies.Service.ClientService;
import com.mindhub.skywalkies.dtos.AvatarDTO;
import com.mindhub.skywalkies.models.Avatar;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.repositories.AvatarRepository;
import com.mindhub.skywalkies.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AvatarController {
    @Autowired
    private AvatarService avatarService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/avatars")
    public List<AvatarDTO> getClients() {
        return avatarService.getAllAvatars().stream().map(AvatarDTO::new).collect(Collectors.toList());
    }

    @RequestMapping("/avatar/{id}")
    public AvatarDTO getAvatar(@PathVariable long id) {
        return new AvatarDTO(avatarService.getAvatarById(id));
    }

    @PatchMapping("/clients/current/avatar")
    public ResponseEntity<Object> editAvatar(
            @RequestBody AvatarDTO avatarDTO, Authentication authentication) {
        Client client = clientService.findClientByEmail(authentication.getName());
        Avatar avatar = avatarService.getAvatarById(client.getId());
        if (!client.isVerificated()) {
            return new ResponseEntity<>("no jaja", HttpStatus.FORBIDDEN);
        }
        avatar.setHead(avatarDTO.getHead());
        avatar.setFace(avatarDTO.getFace());
        avatar.setBody(avatarDTO.getBody());
        avatar.setBodyColor(avatarDTO.getBodyColor());
        avatar.setShoes(avatarDTO.getShoes());
        avatarService.saveAvatar(avatar);
        return new ResponseEntity<>("si jaja", HttpStatus.ACCEPTED);
    }
}
