/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.be;

import java.awt.Color;
import java.util.Date;

/**
 *
 * @author stegg_000
 */
public class User
{
    private int id;
    private String name;
    private String nickName;
    private Color color;
    private Date registerDate;

    public User(int id, String name, String nickName, Color color, Date registerDate)
    {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.color = color;
        this.registerDate = registerDate;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public Date getRegisterDate()
    {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate)
    {
        this.registerDate = registerDate;
    }
    
    
    
}
