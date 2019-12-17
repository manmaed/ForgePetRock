package net.manmaed.petrock.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHNone implements Command<CommandSource> {
    private static final CommandSHNone cmd = new CommandSHNone();

    public static  ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("none")
                .requires(cs -> cs.hasPermissionLevel(0))
                .executes(cmd);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        PRHats.setHat("none");
        //context.getSource().sendFeedback(new StringTextComponent("Happy Christmas!"), false);
        return 0;
    }
}
