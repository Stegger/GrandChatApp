/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.abstractions.chatroom;

import grandchatapp.be.User;
import grandchatapp.bll.implementations.chatroom.ChatCommand;
import java.util.Observable;

/**
 *
 * @author stegg_000
 */
public abstract class IChatRoom extends Observable
{

    protected User system;

    public IChatRoom(User system)
    {
        this.system = system;
    }

    public abstract void sendCommand(ChatCommand message);

}
