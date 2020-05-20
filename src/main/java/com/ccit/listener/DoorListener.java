package com.ccit.listener;

import com.ccit.event.DoorEvent;

import java.util.EventListener;

public interface DoorListener extends EventListener {

    void doorEvent(DoorEvent doorEvent);

}
