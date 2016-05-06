package me.mattrick.server;

import me.mattrick.game.FeudClient;
import me.mattrick.game.FeudManager;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class FeudWebsocketServer {

    private FeudManager feudManager = FeudManager.getManager();

    @OnWebSocketConnect
    public void connect(Session session) {
        feudManager.addClient(new FeudClient(session));
    }

    @OnWebSocketClose
    public void close(Session session, int statusCode, String reason) {
        feudManager.removeClient(new FeudClient(session));
    }

    @OnWebSocketMessage
    public void message(Session session, String message) {

    }

}
