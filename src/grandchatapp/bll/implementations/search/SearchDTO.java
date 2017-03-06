/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.implementations.search;

import grandchatapp.be.User;
import java.util.Date;

/**
 *
 * @author stegg_000
 */
public class SearchDTO
{
    private String searchWord;
    private User user;
    private Date date;

    public String getSearchWord()
    {
        return searchWord;
    }

    public void setSearchWord(String searchWord)
    {
        this.searchWord = searchWord;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
    
    
    
}
