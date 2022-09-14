package com.mindhub.skywalkies.services.implement;

import com.mindhub.skywalkies.models.Avatar;
import com.mindhub.skywalkies.repositories.AvatarRepository;
import com.mindhub.skywalkies.services.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvatarServiceImplements implements AvatarService {
    @Autowired
    AvatarRepository avatarRepository;

    @Override
    public void saveAvatar(Avatar avatar) {
        avatarRepository.save(avatar);
    }

    @Override
    public Avatar getAvatarsById(long id){return avatarRepository.findById(id).get();}

    @Override
    public List<Avatar> getAllAvatars (){return avatarRepository.findAll();}

}
