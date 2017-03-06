/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.abstractions.search;

import grandchatapp.be.User;
import java.util.Date;
import java.util.Observable;

/**
 *
 * @author stegg_000
 */
public abstract class ISearchController extends Observable
{

    public abstract void performSearch(String text, User user, Date date);

}
