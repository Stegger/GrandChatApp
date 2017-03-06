/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.dal.implementations;

import grandchatapp.be.User;
import grandchatapp.dal.abstractions.IUserDAO;
import java.awt.Color;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author stegg_000
 */
public class MockUserDAO implements IUserDAO
{

    HashMap<String, User> allUsers;

    public MockUserDAO()
    {
        allUsers = new HashMap<>();
        allUsers.put("Peter", new User(1, "Peter", "Stegger", Color.yellow, new Date()));
        allUsers.put("Ole", new User(2, "Ole", "Ole", Color.BLUE, new Date()));
    }

    @Override
    public User getUserByLogin(String name, String password)
    {
        if (allUsers.containsKey(name))
        {
            return allUsers.get(name);
        }
        throw new IllegalArgumentException("User not found");
    }

}
