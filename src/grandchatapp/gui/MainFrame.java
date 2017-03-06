/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.gui;

import grandchatapp.bll.abstractions.IGrandChatAppMediator;
import grandchatapp.bll.abstractions.chatroom.IChatClient;
import grandchatapp.bll.implementations.chatroom.ChatClient;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author stegg_000
 */
public class MainFrame extends JFrame
{

    /// Constants:
    private static final String APPLICATION_NAME = "Grand Chat Application";

    /// Logical components:
    private final IGrandChatAppMediator grandChatApp;

    /// GUI Components:
    private final LoginPanel loginPanel;
    private final SearchPanel searchPanel;
    private final ChatPanel chatPanel;
    private final IChatClient systemChat;
    
    public MainFrame(IGrandChatAppMediator grandChatApp)
    {
        super(APPLICATION_NAME);
        setLayout(new BorderLayout());
        this.grandChatApp = grandChatApp;
        loginPanel = new LoginPanel(grandChatApp.getUserController());
        searchPanel = new SearchPanel(grandChatApp.getSearchController());
        systemChat = new ChatClient(grandChatApp.getSystemUser(), grandChatApp.getChatRoom());
        grandChatApp.getChatRoom().addObserver(systemChat);
        chatPanel = new ChatPanel(systemChat);
        JPanel rightBar = new JPanel(new GridLayout(3, 1));
        rightBar.add(searchPanel);
        rightBar.add(new JLabel());
        rightBar.add(loginPanel);
        add(chatPanel, BorderLayout.WEST);
        add(rightBar, BorderLayout.EAST);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
