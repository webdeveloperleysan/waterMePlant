package de.mms.waterMe.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;




@Entity
@Table(name = "PLANT")
public class Plant {


    private @Id @GeneratedValue Long id;

    private String icon;

    private Date soilChanged;

    private String room;

    private int floor;

    private String name;

    private String wikiLink;


    public Plant() {}


    public Plant(String icon, Date soilChanged, String room, int floor, String name, String wikiLink) {
        this.icon = icon;
        this.soilChanged = new Date();
        this.room = room;
        this.floor=floor;
        this.name = name;
        this.wikiLink = wikiLink;
    }

    public Long getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }

// getters
    public Date getSoilChanged() {
        return soilChanged;
    }

    public String getRoom() {
        return room;
    }

    public int getFloor() {
        return floor;
    }

    public String getName() {
        return name;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    // setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
//check
    public void setSoilChanged(Date soilChanged) {
        this.soilChanged = soilChanged;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant that = (Plant) o;
        //??
        return icon.equals(that.icon) && soilChanged.equals(that.soilChanged) && room.equals(that.room)
                && floor==that.floor && name.equals(that.name) && wikiLink.equals(that.wikiLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, icon, soilChanged, room, floor, name, wikiLink);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", icon=" + icon +
                ", soilChanged =" + soilChanged  +
                ", room=" + room +
                ", floor=" + floor +
                ", name=" + name +
                ", wikiLink=" + wikiLink +
                '}';
    }

}
