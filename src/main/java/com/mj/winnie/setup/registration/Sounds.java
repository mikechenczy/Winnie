package com.mj.winnie.setup.registration;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

import static com.mj.winnie.Winnie.MODID;

/**
 * @author Mike_Chen
 * @date 2022/12/27
 * @apiNote
 */
public class Sounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(MODID, name)));
    }
    public static List<RegistryObject<SoundEvent>> XIJINPING_AMBIENT = new ArrayList<>();
    public static final RegistryObject<SoundEvent> XIJINPING_HURT = registerSoundEvent("xijinping_hurt");
    public static final RegistryObject<SoundEvent> XIJINPING_DEATH = registerSoundEvent("xijinping_death");
    public static final RegistryObject<SoundEvent> XIJINPING_ZHONGGUOHUA = registerSoundEvent("xijinping_zhongguohua");

    public static final RegistryObject<SoundEvent> THE_RED_SUN_IN_THE_SKY = registerSoundEvent("the_red_sun_in_the_sky");

    static {
        for(int i=1;i<=26;i++) {
            XIJINPING_AMBIENT.add(registerSoundEvent("score"+i));
        }
    }
}
