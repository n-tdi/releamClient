package ntdi.world.releamclient.DiscordBot.Utils;

import net.dv8tion.jda.api.entities.Member;
import ntdi.world.releamclient.ReleamClient;

import java.time.Duration;

public class Checks {
    public static void addWarn(String id, Member member) {
        if (ReleamClient.warns.containsKey(id)) {
            ReleamClient.warns.put(id, ReleamClient.warns.get(id) + 1);
        } else {
            ReleamClient.warns.put(id, 1);
        }

        if (ReleamClient.warns.get(id) >= 2) {
            ReleamClient.warns.remove(id);
            try {
                member.timeoutFor(Duration.ofHours(1)).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
