package de.mms.waterMe.database.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "IRRIGATION")
public class Irrigation {

    private @Id @GeneratedValue Long id;

    @JoinColumn(name="plant_id")
    private Long plant_id;


    @JoinColumn(name="user_id")
    private Long user_id;

    private int amount;

    private Date date;

    public Irrigation() {}

    public Irrigation(Long plant_id, Long user_id, int amount) {
        this.plant_id = plant_id;
        this.user_id = user_id;
        this.amount = amount;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public Long getPlant_id() {
        return plant_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlant_id(Long plant_id) {
        this.plant_id = plant_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Irrigation that = (Irrigation) o;
        return amount == that.amount && plant_id.equals(that.plant_id) && user_id.equals(that.user_id) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plant_id, user_id, amount, date);
    }

    @Override
    public String toString() {
        return "Irrigation{" +
                "id=" + id +
                ", plant_id=" + plant_id +
                ", user_id=" + user_id +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
