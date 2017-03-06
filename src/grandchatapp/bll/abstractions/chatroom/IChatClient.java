/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.abstractions.chatroom;

import grandchatapp.be.User;
import grandchatapp.bll.implementations.chatroom.ChatCommand;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author stegg_000
 */
public abstract class IChatClient extends Observable implements Observer
{

    protected IChatRoom chatRoom;
    protected User user;

    public IChatClient(User user, IChatRoom chatRoom)
    {
        this.user = user;
        this.chatRoom = chatRoom;
        chatRoom.addObserver(this);
    }

    public abstract void sendMessage(String text);

    public abstract void login();

    public abstract void logout();

    @Override
    public void update(Observable o, Object arg)
    {
        if (o instanceof IChatRoom && arg instanceof ChatCommand)
        {
            ChatCommand msg = (ChatCommand) arg;
            setChanged();
            notifyObservers(msg);
        }
    }

}
