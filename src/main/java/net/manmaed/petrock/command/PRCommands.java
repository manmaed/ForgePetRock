package net.manmaed.petrock.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.manmaed.petrock.libs.Refs;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

/**
 * Created by manmaed on 29/11/2019.
 */
public class PRCommands {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> cmdpr = dispatcher.register(Commands.literal(Refs.id)
                //how to add new commad to /petrock
                //.then(CommadA.register(dispatcher)
                .then(CommandSetHat.register(dispatcher))
                .then(CommandIASP101.register(dispatcher))
        );
        dispatcher.register(Commands.literal(Refs.id).redirect(cmdpr));
    }
}
