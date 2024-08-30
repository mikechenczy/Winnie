package com.mj.winnie.data;

import com.mj.winnie.Winnie;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldSavedData;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

/**
 * @author Mike_Chen
 * @date 2022/12/27
 * @apiNote
 */
public class ModSavedData extends WorldSavedData {

    public static final String NAME = Winnie.MODID + "_saved";

    public final List<ModSavedObject> DATA = new ArrayList<>();

    public ModSavedData(String p_i2141_1_) {
        super(p_i2141_1_);
    }

    public ModSavedData() {
        this(NAME);
    }

    @Override
    public void load(CompoundNBT nbt) {
        if(DATA.isEmpty())
            return;
        CompoundNBT savedData = nbt.getCompound("savedData");
        for(int i = 0; savedData.contains("data" + i); i++) {
            DATA.add(ModSavedObject.serialize(savedData.getCompound("data" + i)));
        }
    }

    @Override
    @Nonnull
    public CompoundNBT save(@Nonnull CompoundNBT nbt) {
        CompoundNBT savedData = new CompoundNBT();
        for(ListIterator<ModSavedObject> iterator = DATA.listIterator(); iterator.hasNext(); ) {
            savedData.put("data"+iterator.nextIndex(), iterator.next().deserializer());
        }
        nbt.put("savedData", savedData);
        return nbt;
    }

    public static void putData(ModSavedObject object, ServerWorld world) {
        ModSavedData data = world.getDataStorage().computeIfAbsent(ModSavedData::new, ModSavedData.NAME);
        data.DATA.add(object);
        data.setDirty();
    }

    public static ModSavedData getData(ServerWorld world) {
        return world.getDataStorage().get(ModSavedData::new, ModSavedData.NAME);
    }

    public static class ModSavedObject {
        private final int randomInt;
        private final BlockPos blockPos;
        private final UUID id;

        public ModSavedObject(int randomInt, BlockPos blockPos, UUID id) {
            this.randomInt = randomInt;
            this.blockPos = blockPos;
            this.id = id;
        }

        public CompoundNBT deserializer() {
            CompoundNBT nbt = new CompoundNBT();
            nbt.putInt("randomInt", randomInt);
            nbt.putLong("pos", blockPos.asLong());
            nbt.putUUID("id", id);
            return nbt;
        }

        public static ModSavedObject serialize(CompoundNBT nbt) {
            return new ModSavedObject(nbt.getInt("randomInt"), BlockPos.of(nbt.getLong("pos")), nbt.getUUID("id"));
        }
    }
}
