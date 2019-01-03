package com.wantu.app;

import com.wantu.rest.MessageRestService;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MessageApplication extends Application {
    private Set<Object> singletons = new HashSet<>();

    public MessageApplication() {
        singletons.add(new MessageRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
