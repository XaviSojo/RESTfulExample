package com.wantu.app;

import com.mongodb.*;

import java.net.UnknownHostException;

public class ConnectionManager {

    public DBCollection connectionManager(String dbcollection) throws UnknownHostException {

        String host = "localhost";
        int port = 27017;
        String dbname = "test";
        return new MongoClient(host, port).getDB(dbname).getCollection(dbcollection);


    }
}