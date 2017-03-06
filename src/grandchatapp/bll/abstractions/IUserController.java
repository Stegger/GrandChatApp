/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.abstractions;

import java.util.Observable;

/**
 *
 * @author stegg_000
 */
public abstract class IUserController extends Observable
{
    
    public abstract void loginUser(String userName, String password);
    
    
    
}
