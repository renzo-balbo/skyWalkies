package com.mindhub.skywalkies.services;

import com.mindhub.skywalkies.models.Avatar;

public interface AvatarService {
    public void saveAvatar(Avatar avatar);

    public Avatar getAvatarsById (long id);


}