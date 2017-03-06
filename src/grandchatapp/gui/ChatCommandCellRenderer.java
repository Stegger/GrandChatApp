/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.gui;

import grandchatapp.bll.implementations.chatroom.ChatCommand;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author stegg_000
 */
public class ChatCommandCellRenderer implements ListCellRenderer<ChatCommand>
{

    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

    @Override
    public Component getListCellRendererComponent(JList<? extends ChatCommand> list, ChatCommand value, int index, boolean isSelected, boolean cellHasFocus)
    {
        String text = "";
        switch (value.getType())
        {
            case CHAT_MESSAGE:
                text = value.getSender().getNickName() + ": " + value.getMessage();
                break;
            case USER_LOGIN:
                text = value.getSender().getNickName() + " LOGGED IN";
                break;
            case USER_LOGOUT:
                text = value.getSender().getNickName() + " LOGGED OUT";
                break;
        }
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, text, index, isSelected, cellHasFocus);
        renderer.setForeground(value.getSender().getColor());
        return renderer;
    }

}
