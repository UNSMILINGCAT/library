package com.library.data;

import org.springframework.stereotype.Component;

import java.util.Objects;


@Component(value = "userTable")
public class UserTable
{
    private int id;
    private String username;
    private String password;
    private String power;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPower()
    {
        return power;
    }

    public void setPower(String power)
    {
        this.power = power;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTable userTable = (UserTable) o;
        return id == userTable.id &&
                Objects.equals(username, userTable.username) &&
                Objects.equals(password, userTable.password) &&
                Objects.equals(power, userTable.power);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(id, username, password, power);
    }
}
