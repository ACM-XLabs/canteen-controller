package com.acmxlabs.canteencontroller;

import android.view.View;

//defining a interface for communication between fragments
public interface Communicator
{
    //function which is called when elements in grid fragment are clicked
    void respond(View v);
}
