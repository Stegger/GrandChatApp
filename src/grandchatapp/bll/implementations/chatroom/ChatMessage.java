/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.implementations.chatroom;

import grandchatapp.be.User;

/**
 *
 * @author stegg_000
 */
public class ChatMessage
{

    private String text;
    private User user;

    public ChatMessage(String text, User user)
    {
        this.text = text;
        this.user = user;
    }

    public String getText()
    {
        return text;
    }

    public User getUser()
    {
        return user;
    }

    @Override
    public String toString()
    {
        return user.getNickName() + ": " + text;
    }

}
