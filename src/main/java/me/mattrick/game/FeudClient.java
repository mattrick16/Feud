package me.mattrick.game;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.jetty.websocket.api.Session;

public class FeudClient {

    @Getter
    @Setter
    private Session session;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private int points;

    @Getter
    @Setter
    private boolean host;

    public FeudClient(Session session) {
        this.session = session;
    }

}
