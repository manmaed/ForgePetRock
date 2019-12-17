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
public class CommandSHBirthday implements Command<CommandSource> {
    private static final CommandSHBirthday cmd = new CommandSHBirthday();

    public static  ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("birthday")
                .requires(cs -> cs.hasPermissionLevel(0))
                .executes(cmd);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        PRHats.setHat("birthday");
        //context.getSource().sendFeedback(new StringTextComponent("Happy Christmas!"), false);
        return 0;
    }
}
