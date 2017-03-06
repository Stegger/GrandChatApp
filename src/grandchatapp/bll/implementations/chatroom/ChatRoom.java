/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.implementations.chatroom;

import grandchatapp.be.User;
import grandchatapp.bll.abstractions.chatroom.IChatRoom;

/**
 *
 * @author stegg_000
 */
public class ChatRoom extends IChatRoom
{

    private boolean isNaughty;

    public ChatRoom(User system)
    {
        super(system);
        isNaughty = false;
    }

    private final String[] naughtyWords =
    {
        "fuck", "idiot"
    };

    private String cleanupMessage(String text)
    {
        text = text.toLowerCase();
        String[] pieces = text.split(" ");
        for (int i = 0; i < pieces.length; i++)
        {
            for (String nw : naughtyWords)
            {
                if (pieces[i].equalsIgnoreCase(nw))
                {
                    pieces[i] = pieces[i].replaceAll(".", "*");
                    isNaughty = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String piece : pieces)
        {
            sb.append(piece);
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public void sendCommand(ChatCommand message)
    {
        if (message.getType() == ChatCommand.CommandType.CHAT_MESSAGE)
        {
            String text = message.getMessage();
            text = cleanupMessage(text);
            message = new ChatCommand(message.getType(), message.getSender(), text);
        }
        setChanged();
        notifyObservers(message);

        if (isNaughty)
        {
            setChanged();
            notifyObservers(new ChatCommand(ChatCommand.CommandType.CHAT_MESSAGE, system, "PLEASE NO NAUGHTY WORDS IN THE CHAT!"));
            isNaughty = false;
        }
    }

}
