package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    //@OneToOne(cascade = CascadeType.ALL)
    //private Client client;


    private long id;
    private Integer head;
    private Integer face;
    private Integer  bodyColor;
    private Integer  body;
    private Integer  shoes;

    public Avatar() {
    }

    public Avatar(Integer  head, Integer  face, Integer  bodyColor, Integer  body, Integer  shoes) {
        this.head = head;
        this.face = face;
        this.bodyColor = bodyColor;
        this.body = body;
        this.shoes = shoes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public Integer getFace() {
        return face;
    }

    public void setFace(Integer face) {
        this.face = face;
    }

    public Integer getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(Integer bodyColor) {
        this.bodyColor = bodyColor;
    }

    public Integer getBody() {
        return body;
    }

    public void setBody(Integer body) {
        this.body = body;
    }

    public Integer getShoes() {
        return shoes;
    }

    public void setShoes(Integer shoes) {
        this.shoes = shoes;
    }
}
