package me.mattrick;

import me.mattrick.server.FeudWebServer;

import java.io.IOException;

public class Feud {

    private static FeudWebServer server;

    public static void main(String[] args) {
        try {
            server = new FeudWebServer(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {

        }
    }

}
