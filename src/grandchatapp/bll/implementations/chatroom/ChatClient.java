/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.implementations.chatroom;

import grandchatapp.be.User;
import grandchatapp.bll.abstractions.chatroom.IChatClient;
import grandchatapp.bll.abstractions.chatroom.IChatRoom;

/**
 *
 * @author stegg_000
 */
public class ChatClient extends IChatClient
{

    public ChatClient(User user, IChatRoom chatRoom)
    {
        super(user, chatRoom);
    }

    @Override
    public void sendMessage(String text)
    {
        ChatCommand cmd = new ChatCommand(ChatCommand.CommandType.CHAT_MESSAGE, user, text);
        chatRoom.sendCommand(cmd);
    }

    @Override
    public void login()
    {
        ChatCommand cmd = new ChatCommand(ChatCommand.CommandType.USER_LOGIN, user, null);
        chatRoom.sendCommand(cmd);
    }

    @Override
    public void logout()
    {
        ChatCommand cmd = new ChatCommand(ChatCommand.CommandType.USER_LOGOUT, user, null);
        chatRoom.sendCommand(cmd);
    }
}
