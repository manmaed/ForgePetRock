package net.manmaed.petrock.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSetHat implements Command<CommandSource> {
    private static final CommandSetHat cmd = new CommandSetHat();

    public static  ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("sethat")
                .then(CommandSHBirthday.register(dispatcher))
                .then(CommandSHChristmas.register(dispatcher))
                .then(CommandSHBirthday.register(dispatcher))
                .then(CommandSHHallowen.register(dispatcher))
                .then(CommandSHLone.register(dispatcher))
                .then(CommandSHNone.register(dispatcher))
                .requires(cs -> cs.hasPermissionLevel(0))
                .executes(cmd);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        return 0;
    }
}
