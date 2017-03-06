/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.gui;

import grandchatapp.bll.abstractions.chatroom.IChatClient;
import grandchatapp.bll.implementations.chatroom.ChatCommand;
import grandchatapp.bll.implementations.chatroom.ChatMessage;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author stegg_000
 */
public class ChatPanel extends javax.swing.JPanel implements Observer
{

    private final IChatClient chatClient;

    private ChatListModel model;

    /**
     * Creates new form ChatPanel
     *
     * @param chatClient
     */
    public ChatPanel(IChatClient chatClient)
    {
        this.chatClient = chatClient;
        this.chatClient.addObserver(this);
        model = new ChatListModel();
        initComponents();
        jList1.setModel(model);
        jList1.setCellRenderer(new ChatCommandCellRenderer());
        jList1.setBackground(Color.LIGHT_GRAY);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        txtMessage = new javax.swing.JTextField();
        btnSendMsg = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        btnSendMsg.setText("Send");
        btnSendMsg.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSendMsgActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendMsg)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendMsg))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendMsgActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSendMsgActionPerformed
    {//GEN-HEADEREND:event_btnSendMsgActionPerformed
        String message = txtMessage.getText().trim();
        txtMessage.setText("");
        chatClient.sendMessage(message);
    }//GEN-LAST:event_btnSendMsgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendMsg;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg)
    {
        if (arg instanceof ChatCommand)
        {
            ChatCommand message = (ChatCommand) arg;
            model.addChatMessage(message);
        }
    }
}
