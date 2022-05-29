package ntdi.world.releamclient.DiscordBot;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import ntdi.world.releamclient.DiscordBot.Events.MessageSentEvent;

import javax.security.auth.login.LoginException;

public class ReleamClientBot {
    public static void main(String[] args) throws LoginException, InterruptedException {
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.addSlashCommands();
        builder.forceGuildOnly("980460715347427429");
        builder.setOwnerId("746146672689545327");
        builder.setCoOwnerIds(348587937144897537L);
        builder.setPrefix("+");
        builder.useHelpBuilder(false);

        builder.setActivity(Activity.watching("Releam"));
        CommandClient commandClient = builder.build();

        JDA jda = JDABuilder.createDefault("TOKEN")
                .disableCache(CacheFlag.VOICE_STATE)
                .setBulkDeleteSplittingEnabled(false)
                .addEventListeners(
                        commandClient,
                        new MessageSentEvent())
                .build();

        jda.awaitReady();
        CommandListUpdateAction commandListUpdateAction = jda.updateCommands();
        commandListUpdateAction.queue();
    }
}
