/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.gui;

import grandchatapp.bll.implementations.chatroom.ChatCommand;
import grandchatapp.bll.implementations.chatroom.ChatMessage;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

/**
 *
 * @author stegg_000
 */
public class ChatListModel extends AbstractListModel
{

    LinkedList<ChatCommand> messages = new LinkedList<>();

    @Override
    public int getSize()
    {
        return messages.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return messages.get(index);
    }

    public void addChatMessage(ChatCommand message)
    {
        messages.push(message);
        fireIntervalAdded(this, 0, messages.size());
    }

}
