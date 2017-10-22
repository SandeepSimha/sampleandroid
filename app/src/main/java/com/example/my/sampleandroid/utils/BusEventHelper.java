package com.example.my.sampleandroid.utils;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/*BusEventHelper is single event provider
of Otto eventBus.
* */

/**
 * @author chers026 on 10/21/17.
 */
public class BusEventHelper {
    public static Bus eventBus;

    public static Bus getInstance() {
        if (eventBus == null) {
            eventBus = new Bus(ThreadEnforcer.MAIN);
        }
        return eventBus;
    }
}
