/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.implementations.chatroom;

import grandchatapp.be.User;
import grandchatapp.bll.abstractions.chatroom.IChatClient;
import grandchatapp.bll.abstractions.chatroom.IChatController;
import grandchatapp.bll.abstractions.chatroom.IChatRoom;
import grandchatapp.gui.ChatPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import sun.rmi.server.UnicastRef;

/**
 *
 * @author stegg_000
 */
public class ChatController implements IChatController
{

    @Override
    public void createNewChatWindow(User user, IChatRoom chatRoom)
    {
        Runnable runner = () ->
        {
            IChatClient client = new ChatClient(user, chatRoom);
            client.login();
            ChatPanel panel = new ChatPanel(client);
            panel.setBorder(BorderFactory.createLineBorder(user.getColor(), 3, true));
            JFrame frame = new JFrame(user.getNickName());
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.addWindowListener(new WindowAdapter()
            {

                @Override
                public void windowClosing(WindowEvent e)
                {
                    super.windowClosing(e);
                    client.logout();

                }

            });

            frame.setVisible(true);
        };

        SwingUtilities.invokeLater(runner);

    }

}
