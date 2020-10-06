package com.hfy.flyhotel.entity;

import javax.persistence.*;

@Entity
@Table(name = "loginer")
public class Loginer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "level")
    private String level;


    @Override
    public String toString() {
        return "Loginer{" +
                "id=" + id +
                ", name=" + name +
                ", pwd=" + pwd +
                ", level='" + level + '\'' +
                '}';
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getpwd() {
        return pwd;
    }

    public void setpwd(String pwd) {
        this.pwd = pwd;
    }

    public String getlevel() {
        return level;
    }

    public void setlevel(String level) {
        this.level = level;
    }
}
