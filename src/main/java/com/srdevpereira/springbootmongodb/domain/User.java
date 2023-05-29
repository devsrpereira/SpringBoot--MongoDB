package com.srdevpereira.springbootmongodb.domain;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String id;
    private String name;
    private String Email;

    public User(){}
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        Email = email;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


}
