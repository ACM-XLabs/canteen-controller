package com.acmxlabs.canteencontroller;

import android.view.View;

//defining a interface for communication between fragments
public interface Communicator
{
    //function which is called when elements in grid fragment are clicked
    void respond(View v);

    //function for communicating about the search sub-string from search_frg to token_frg
    void search_fun(String search_substr);
}
