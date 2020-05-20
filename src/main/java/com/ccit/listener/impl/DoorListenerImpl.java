package com.ccit.listener.impl;

import com.ccit.event.DoorEvent;
import com.ccit.listener.DoorListener;

public class DoorListenerImpl implements DoorListener {

    @Override
    public void doorEvent(DoorEvent doorEvent) {
        if (doorEvent.getDoorState() != "" && doorEvent.getDoorState() == "open") {
            System.err.println("门打开");
        } else {
            System.out.println("门关闭");
        }
    }

}
