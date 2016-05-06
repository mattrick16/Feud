package me.mattrick.server;

import me.mattrick.util.WebUtil;
import spark.Spark;

import java.io.IOException;

public class FeudWebServer {

    public FeudWebServer(int port) throws IOException {
       this(port, null);
    }

    public FeudWebServer(int port, String bindAddress) throws IOException {
        Spark.port(port);
        Spark.ipAddress(bindAddress != null ? bindAddress : "0.0.0.0");

        //Serve static files
        Spark.staticFiles.location("/client/public");

        //Web socket server
        Spark.webSocket("/", FeudWebsocketServer.class);

        //The index path is all we really need
        Spark.get("/", (request, response) -> WebUtil.getStringFromClassPath("/client/index.html"));

        //Any non existent paths will return a 404 error
        Spark.get("*", (request, response) -> WebUtil.getStringFromClassPath("/client/errors/404.html"));

        Spark.init();
    }

    public void stop() {
        Spark.stop();
    }

}
