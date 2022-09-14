package com.mindhub.skywalkies.services;

import com.mindhub.skywalkies.models.Avatar;

import java.util.List;

public interface AvatarService {
    public void saveAvatar(Avatar avatar);

    public Avatar getAvatarsById (long id);

    public List<Avatar> getAllAvatars ();
}