package com.mindhub.skywalkies.services;

import com.mindhub.skywalkies.models.Avatar;

public interface AvatarService {
    void saveAvatar(Avatar avatar);

    Avatar getAvatarsById(long id);

}
