package com.mj.winnie.world;

import com.mj.winnie.Winnie;
import com.mj.winnie.world.dimension.ModDimensions;
import net.minecraft.block.BedBlock;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.state.properties.BedPart;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

/**
 * @author Mike_Chen
 * @date 2022/12/27
 * @apiNote
 */
@Mod.EventBusSubscriber(modid = Winnie.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {

    @SubscribeEvent
    public static void onBreakBed(final BlockEvent.BreakEvent event) {
        if (!(event.getState().getBlock() instanceof BedBlock))
            return;
        if(event.getPlayer().level.dimension() != ModDimensions.COMMUNISM_DIM)
            return;
        BlockPos pos = ((ServerPlayerEntity)event.getPlayer()).getRespawnPosition();
        if(pos==null)
            return;
        int x = event.getPos().getX();
        int y = event.getPos().getY();
        int z = event.getPos().getZ();
        int x1 = pos.getX();
        int y1 = pos.getY();
        int z1 = pos.getZ();
        Winnie.LOGGER.debug(event.getState().getValue(BedBlock.PART));
        if(event.getState().getValue(BedBlock.PART) != BedPart.HEAD) {
            switch (event.getState().getBlock().getBedDirection(event.getState(), null, null)) {
                case EAST:
                    x++;
                    break;
                case SOUTH:
                    z++;
                    break;
                case WEST:
                    x--;
                    break;
                case NORTH:
                    z--;
                    break;
            }
        }
        Winnie.LOGGER.debug(x+","+y+","+z);
        Winnie.LOGGER.debug(x1+","+y1+","+z1);
        if(x==x1&&y==y1&&z==z1) {
            //long l = ModSavedData.getData((ServerWorld) event.getWorld()).DATA.get(0).deserializer().getLong("pos");
            //long l = event.getPlayer().getPersistentData(). getLong("dim_respawn_pos");
            //BlockPos position = BlockPos.of(l);
            Random random = event.getWorld().getRandom();
            int sx = -200+random.nextInt(401);
            int sz = -200+random.nextInt(401);
            int sy = 63;
            while (!(event.getWorld().isEmptyBlock(new BlockPos(sx, sy, sz)) && event.getWorld().isEmptyBlock(new BlockPos(sx, sy+1, sz)))) {
                sy++;
            }
            BlockPos position = new BlockPos(sx, sy, sz);
            Winnie.LOGGER.debug(position);
            ((ServerPlayerEntity)event.getPlayer()).setRespawnPosition(event.getPlayer().level.dimension(),
                    position, 0.0F, true, false);
        }
    }
}
