/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp;

import grandchatapp.bll.implementations.GrandChatAppMediator;
import grandchatapp.gui.MainFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author stegg_000
 */
public class GrandChatApp
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        
        SwingUtilities.invokeLater(new Runnable()
        {

            @Override
            public void run()
            {
                GrandChatAppMediator grandChatApp = new GrandChatAppMediator();
                MainFrame mf = new MainFrame(grandChatApp);
            }
        });

    }

}
