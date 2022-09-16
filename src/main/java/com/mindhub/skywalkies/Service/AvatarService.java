package com.mindhub.skywalkies.Service;

import com.mindhub.skywalkies.models.Avatar;

import java.util.List;

public interface AvatarService {
    List<Avatar> getAllAvatars();

    Avatar getAvatarById(long id);

    void saveAvatar(Avatar avatar);
}
