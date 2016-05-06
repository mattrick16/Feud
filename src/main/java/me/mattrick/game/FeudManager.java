package me.mattrick.game;

import lombok.Getter;
import me.mattrick.Feud;
import org.eclipse.jetty.websocket.api.Session;

import java.util.HashSet;
import java.util.Set;

public class FeudManager {

    @Getter
    private static FeudManager manager = new FeudManager();

    @Getter
    private Set<FeudClient> clients = new HashSet<>();

    @Getter
    private Set<FeudGame> games = new HashSet<>();

    private FeudManager(){}

    public void addClient(FeudClient client) {
        this.clients.add(client);
    }

    public void removeClient(FeudClient client) {
        clients.remove(client);
        getGameByClient(client).removeClient(client);
    }

    public FeudClient getClientBySession(Session session) {
        for (FeudClient client : clients) {
            if (client.getSession() == session) {
                return client;
            }
        }
        return null;
    }

    public void addGame(FeudGame game) {
        games.add(game);
    }

    public void removeGame(FeudGame game) {
        games.remove(game);
    }

    public FeudGame getGameByHash(String hash) {
        for (FeudGame game : games) {
            if (game.getHash().equals(hash)) {
                return game;
            }
        }
        return null;
    }

    public FeudGame getGameByClient(FeudClient client) {
        for (FeudGame game : games) {
            if (game.getClients().contains(client)) {
                return game;
            }
        }
        return null;
    }

}
