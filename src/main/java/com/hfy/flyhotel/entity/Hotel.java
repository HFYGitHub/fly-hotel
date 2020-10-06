package com.hfy.flyhotel.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "image")
    private String image;

    @Column(name = "number")
    private Integer number;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Double price;

    @Column(name = "info")
    private String info;

    @Column(name = "status")
    private String status;

    @Column(name = "in_time")
    private String in_time;

    @Column(name = "out_time")
    private String out_time;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "hotel_user_id",referencedColumnName = "id")
    private User user;

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", status='" + status + '\'' +
                ", in_time='" + in_time + '\'' +
                ", out_time='" + out_time + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
