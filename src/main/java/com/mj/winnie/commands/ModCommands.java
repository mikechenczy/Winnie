package com.mj.winnie.commands;

import com.mj.winnie.Winnie;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class ModCommands {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> cmdTut = dispatcher.register(
                Commands.literal(Winnie.MODID)
                        //.then(CommandTest.register(dispatcher))
                        .then(CommandTpDim.register(dispatcher))
                        .then(CommandSpawner.register(dispatcher))
        );

        //dispatcher.register(Commands.literal("tut").redirect(cmdTut));
    }

}
