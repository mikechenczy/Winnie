package com.mj.winnie.network;

import com.mj.winnie.gui.SpawnerScreen;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;


public class PacketOpenGui {

    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(SpawnerScreen::open);
        return true;
    }

}
