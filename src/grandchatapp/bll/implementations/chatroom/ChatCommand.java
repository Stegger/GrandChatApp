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
public class ChatCommand
{

    public CommandType getType()
    {
        return type;
    }

    public User getSender()
    {
        return sender;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public enum CommandType
    {

        CHAT_MESSAGE, USER_LOGIN, USER_LOGOUT;

    }

    private CommandType type;
    private User sender;
    private String message;

    public ChatCommand(CommandType type, User sender, String message)
    {
        this.type = type;
        this.sender = sender;
        this.message = message;
    }

}
