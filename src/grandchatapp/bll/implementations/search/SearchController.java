/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandchatapp.bll.implementations.search;

import grandchatapp.be.User;
import grandchatapp.bll.abstractions.search.ISearchController;
import java.util.Date;

/**
 *
 * @author stegg_000
 */
public class SearchController extends ISearchController
{
    
    @Override
    public void performSearch(String text, User user, Date date)
    {
        SearchDTO search = new SearchDTO();
        search.setSearchWord(text);
        search.setUser(user);
        search.setDate(date);
        setChanged();
        notifyObservers(search);
    }
    
}
