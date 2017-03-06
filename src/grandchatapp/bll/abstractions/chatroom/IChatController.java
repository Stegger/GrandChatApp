/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.abstractions.chatroom;

import grandchatapp.be.User;

/**
 *
 * @author stegg_000
 */
public interface IChatController
{

    public void createNewChatWindow(User user, IChatRoom chatRoom);
    
}
