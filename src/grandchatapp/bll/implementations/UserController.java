/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.implementations;

import grandchatapp.bll.abstractions.IUserController;
import grandchatapp.be.User;
import grandchatapp.dal.abstractions.IUserDAO;
import java.awt.Color;
import java.util.Date;

/**
 *
 * @author stegg_000
 */
public class UserController extends IUserController
{

    private IUserDAO userDao;

    public UserController(IUserDAO userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public void loginUser(String userName, String password)
    {
        User user = userDao.getUserByLogin(userName, password);
        setChanged();
        notifyObservers(user);
    }

}
