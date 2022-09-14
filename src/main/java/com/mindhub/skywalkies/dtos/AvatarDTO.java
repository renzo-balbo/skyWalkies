package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Avatar;

public class AvatarDTO {

    private long id;
    private Integer head;
    private Integer face;
    private Integer  bodyColor;
    private Integer  body;
    private Integer  shoes;

    public AvatarDTO(){}

    public AvatarDTO(Avatar avatar){
        this.id = avatar.getId();
        this.head = avatar.getHead();
        this.face = avatar.getFace();
        this.bodyColor = avatar.getBody();
        this.body = avatar.getBody();
        this.shoes = avatar.getShoes();
    }

    public long getId() {
        return id;
    }

    public Integer getHead() {
        return head;
    }

    public Integer getFace() {
        return face;
    }

    public Integer getBodyColor() {
        return bodyColor;
    }

    public Integer getBody() {
        return body;
    }

    public Integer getShoes() {
        return shoes;
    }
}
