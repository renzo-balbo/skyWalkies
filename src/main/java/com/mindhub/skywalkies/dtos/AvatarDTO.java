package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Avatar;

public class AvatarDTO {

    private long id;
    private String head;
    private String face;
    private String bodyColor;
    private String body;
    private String shoes;

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

    public String getHead() {
        return head;
    }

    public String getFace() {
        return face;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public String getBody() {
        return body;
    }

    public String getShoes() {
        return shoes;
    }
}
