package me.mattrick.server.message;

import me.mattrick.game.FeudClient;
import me.mattrick.game.FeudGame;
import me.mattrick.game.FeudManager;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageHandler {

    private FeudManager feudManager = FeudManager.getManager();

    public void parse(Session session, String raw) {
        try {
            JSONObject object = new JSONObject(raw);
            FeudClient client = feudManager.getClientBySession(session);

            switch (object.getString("message_type")) {
                case "name": {
                    client.setUsername(object.getString("value"));
                    break;
                }
                case "join": {
                    FeudGame game = feudManager.getGameByHash(object.getString("value"));
                    if (game != null) {
                        game.addClient(client);

                        if (game.getClients().size() == 0) {
                            client.setHost(true);
                        }
                    }
                    break;
                }
                case "quit": {
                    FeudGame game = feudManager.getGameByClient(client);

                    if (game != null) {
                        game.removeClient(client);
                    }
                    break;
                }
                case "guess": {
                    FeudGame game = feudManager.getGameByClient(client);

                    if(game != null) {

                    }
                }
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
