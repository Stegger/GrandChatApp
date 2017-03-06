/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.implementations;

import grandchatapp.be.User;
import grandchatapp.bll.abstractions.IGrandChatAppMediator;
import grandchatapp.bll.abstractions.IUserController;
import grandchatapp.bll.abstractions.chatroom.IChatController;
import grandchatapp.bll.abstractions.chatroom.IChatRoom;
import grandchatapp.bll.abstractions.search.ISearchController;
import grandchatapp.bll.implementations.chatroom.ChatController;
import grandchatapp.bll.implementations.chatroom.ChatRoom;
import grandchatapp.bll.implementations.search.SearchController;
import grandchatapp.bll.implementations.search.SearchDTO;
import grandchatapp.dal.abstractions.IUserDAO;
import grandchatapp.dal.implementations.MockUserDAO;
import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author stegg_000
 */
public class GrandChatAppMediator implements IGrandChatAppMediator, Observer
{

    private ISearchController searchController;
    private IUserController userController;
    private IUserDAO userDao;
    private IChatController chatController;
    private IChatRoom chatRoom;
    private final User SYSTEM_USER;

    public GrandChatAppMediator()
    {
        SYSTEM_USER = new User(-1, "SYSTEM", "SYSTEM", Color.GRAY, new Date());
        chatRoom = new ChatRoom(SYSTEM_USER);
        chatController = new ChatController();
        userDao = new MockUserDAO();
        userController = new UserController(userDao);
        searchController = new SearchController();
        userController.addObserver(this);
        searchController.addObserver(this);

    }

    @Override
    public IUserController getUserController()
    {
        return userController;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if (o instanceof IUserController && arg instanceof User)
        {
            User user = (User) arg;
            System.out.println("We have a new User(" + user.getName() + "). He must be added to the chatroom!");
            chatController.createNewChatWindow(user, chatRoom);
        }
        else if (o instanceof ISearchController && arg instanceof SearchDTO)
        {
            SearchDTO search = (SearchDTO) arg;
            System.out.println("Search: " + search.getSearchWord() + " Date: " + DateFormat.getDateInstance().format(search.getDate()));
        }
    }

    @Override
    public ISearchController getSearchController()
    {
        return searchController;
    }

    @Override
    public IChatRoom getChatRoom()
    {
        return chatRoom;
    }

    @Override
    public User getSystemUser()
    {
        return SYSTEM_USER;
    }

}
