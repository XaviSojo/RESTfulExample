package com.wantu.rest;

import com.mongodb.*;
import com.wantu.app.ConnectionManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


//http://localhost:8080/RESTfulExample/rest/usearch/grr

@Path("/usearch")
@Produces(MediaType.APPLICATION_JSON)

public class UserSearchRestService {
    @GET
    @Path("/{param}")

    public Response displaySearch(@PathParam("param") String msg) throws UnknownHostException {

        UserSearchRestService results = new UserSearchRestService();

        if ("f".equals(msg)) {
            return Response.status(200).entity(results.performSearch("gender", msg).toArray()).build();
        } else if ("m".equals(msg)) {
            return Response.status(200).entity(results.performSearch("gender", msg).toArray()).build();
        } else {
            return Response.status(200).entity("None of the options").build();
        }
    }

    private List<DBObject> performSearch(String key, String value) throws UnknownHostException {

        String dbcollection = "users";
        ConnectionManager connection = new ConnectionManager();
        DBCollection db = connection.connectionManager(dbcollection);
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put(key, value);
        DBCursor cursor = db.find(searchQuery);
        List<DBObject> names = new ArrayList<>();
        while (cursor.hasNext()) { names.add(cursor.next()); }
        cursor.close();
        return names;
    }
}