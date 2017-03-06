/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.abstractions;

import grandchatapp.be.User;
import grandchatapp.bll.abstractions.chatroom.IChatRoom;
import grandchatapp.bll.abstractions.search.ISearchController;

/**
 *
 * @author stegg_000
 */
public interface IGrandChatAppMediator
{

    public IUserController getUserController();

    public ISearchController getSearchController();

    public IChatRoom getChatRoom();

    public User getSystemUser();
}
