package ntdi.world.releamclient.DiscordBot.Events;


import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import ntdi.world.releamclient.DiscordBot.BadWordList;
import ntdi.world.releamclient.DiscordBot.Utils.Checks;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.Locale;

public class MessageSentEvent implements EventListener {
    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if (event instanceof MessageReceivedEvent) {
            MessageReceivedEvent e = (MessageReceivedEvent) event;
            String text = e.getMessage().getContentRaw();
            String[] msgWords = text.split("\\b");
            for (String word : msgWords) {
                if (BadWordList.badWords.contains(word.toLowerCase(Locale.US))) {
                    e.getChannel().sendTyping().queue();
                    e.getMessage().delete().queue();
                    e.getChannel().sendMessage("Hey, " + e.getAuthor().getAsMention() + "! Don't use bad words!").queue();
                    Checks.addWarn(e.getAuthor().getId(), e.getMember());
                    break;
                }
            }
        }
    }
}
