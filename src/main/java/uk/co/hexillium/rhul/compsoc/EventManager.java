package uk.co.hexillium.rhul.compsoc;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;

import javax.annotation.Nonnull;

public class EventManager implements EventListener{

    me.jcsawyer.classroombot.CommandDispatcher dispatcher;

    EventManager(){
        this.dispatcher = new me.jcsawyer.classroombot.CommandDispatcher();
    }

    @Override
    public void onEvent(@Nonnull GenericEvent event) {
        if (event instanceof ReadyEvent){
            System.out.println("Ready!");
            dispatcher.onLoad(event.getJDA());
        }
        if (event instanceof GuildMessageReceivedEvent){
            dispatcher.dispatchCommand((GuildMessageReceivedEvent) event);
        }
        if (event instanceof PrivateMessageReceivedEvent){
            dispatcher.dispatchCommand((PrivateMessageReceivedEvent) event);
        }
    }
}
