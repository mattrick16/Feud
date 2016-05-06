package me.mattrick.game;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class FeudGame {

    @Getter
    private String hash;

    @Getter
    @Setter
    private GameState state;

    @Getter
    private Set<FeudClient> clients = new HashSet<>();

    public FeudGame(String hash, GameState state) {
        this.hash = hash;
        this.state = state;
    }

    public void addClient(FeudClient client) {
        this.clients.add(client);
    }

    public void removeClient(FeudClient client) {
        this.clients.remove(client);
    }

    public FeudClient getHost() {
        for (FeudClient client : clients) {
            if (client.isHost()) {
                return client;
            }
        }
        return null;
    }

    public void promoteToHost(FeudClient client) {
        client.setHost(true);
        getHost().setHost(false);
    }

}
