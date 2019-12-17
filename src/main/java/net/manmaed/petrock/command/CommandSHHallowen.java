package net.manmaed.petrock.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHHallowen implements Command<CommandSource> {
    private static final CommandSHHallowen cmd = new CommandSHHallowen();

    public static  ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("halloween")
                .requires(cs -> cs.hasPermissionLevel(0))
                .executes(cmd);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if(!PRHats.slowpoke) {
            context.getSource().sendFeedback(new StringTextComponent("Happy Halloween!"), false);
            PRHats.setHat("halloween");
        } else {
            context.getSource().sendFeedback(new StringTextComponent("No custom hat set with Slowpoke mode enabled"), false);
        }
        return 0;
    }
}
