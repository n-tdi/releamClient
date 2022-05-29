package ntdi.world.releamclient.DiscordBot;

import javax.security.auth.login.LoginException;

public class BotThread extends Thread {
    public void run() {
        try {
            ReleamClientBot.main(null);
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
