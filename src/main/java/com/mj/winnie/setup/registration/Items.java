package com.mj.winnie.setup.registration;

import com.mj.winnie.items.*;
import com.mj.winnie.setup.ModSetup;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

import static com.mj.winnie.Winnie.MODID;

/**
 * @author Mike_Chen
 * @date 2022/12/27
 * @apiNote
 */
public class Items {
    public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore",
            () -> new BlockItem(Blocks.RUBY_ORE.get(), new Item.Properties().tab(ModSetup.ITEM_GROUP)));

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(ModSetup.ITEM_GROUP)));

    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block",
            () -> new BlockItem(Blocks.RUBY_BLOCK.get(), new Item.Properties().tab(ModSetup.ITEM_GROUP)));

    //public static final RegistryObject<Item> MY_GRASS_BLOCK_ITEM = VANILLA_ITEMS.register("grass_block",
    //        () -> new BlockItem(Blocks.MY_GRASS_BLOCK.get(), new Item.Properties().tab(ModSetup.ITEM_GROUP)));

    public static final RegistryObject<DiamondSickle> DIAMOND_SICKLE = ITEMS.register("diamond_sickle", DiamondSickle::new);
    public static final RegistryObject<NetheriteSickle> NETHERITE_SICKLE = ITEMS.register("netherite_sickle", NetheriteSickle::new);
    public static final RegistryObject<DiamondHammer> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", DiamondHammer::new);
    public static final RegistryObject<NetheriteHammer> NETHERITE_HAMMER = ITEMS.register("netherite_hammer", NetheriteHammer::new);
    public static final RegistryObject<NormalCommunist> NORMAL_COMMUNIST = ITEMS.register("normal_communist", NormalCommunist::new);
    public static final RegistryObject<RubyCommunist> RUBY_COMMUNIST = ITEMS.register("ruby_communist", RubyCommunist::new);

    public static final RegistryObject<SocialCreditCertificate> SOCIAL_CREDIT_CERTIFICATE = ITEMS.register("social_credit_certificate", SocialCreditCertificate::new);

    public static final RegistryObject<RubyArrowItem> RUBY_ARROW = ITEMS.register("ruby_arrow", () -> new RubyArrowItem(
            new Item.Properties().tab(ModSetup.ITEM_GROUP), 10));


    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().tab(ModSetup.ITEM_GROUP)));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().tab(ModSetup.ITEM_GROUP)));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().tab(ModSetup.ITEM_GROUP)));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().tab(ModSetup.ITEM_GROUP)));


    public static final RegistryObject<Item> XIJINPING_ZHONGGUOHUA_DISC = ITEMS.register("xijinping_zhongguohua_disc", () ->
            new MusicDiscItem(1, () -> Sounds.XIJINPING_ZHONGGUOHUA.get(), new Item.Properties().stacksTo(1).tab(ModSetup.ITEM_GROUP)){
                @Override
                public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> list, ITooltipFlag flags) {
                    list.add(new TranslationTextComponent("message.xijinping_zhongguohua_disc"));
                }
            });

    public static final RegistryObject<Item> THE_RED_SUN_IN_THE_SKY_DISC = ITEMS.register("the_red_sun_in_the_sky_disc", () ->
            new MusicDiscItem(1, () -> Sounds.THE_RED_SUN_IN_THE_SKY.get(), new Item.Properties().stacksTo(1).tab(ModSetup.ITEM_GROUP)){
                @Override
                public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> list, ITooltipFlag flags) {
                    list.add(new TranslationTextComponent("message.the_red_sun_in_the_sky_disc"));
                }
            });

    public static final Food NUCLEIC_ACID = new Food.Builder().nutrition(1).saturationMod(0.4F)
            .effect(new EffectInstance(Effects.POISON, 1200, 3), 1.0F)
            .effect(new EffectInstance(Effects.HUNGER, 300, 2), 1.0F)
            .effect(new EffectInstance(Effects.CONFUSION, 300, 0), 1.0F).alwaysEat().build();
    public static final RegistryObject<Item> NUCLEIC_ACID_ITEM = ITEMS.register("nucleic_acid",
            () -> new Item(new Item.Properties().tab(ModSetup.ITEM_GROUP).food(NUCLEIC_ACID)));
    public static final Food VACCINE = new Food.Builder().nutrition(1).saturationMod(0.4F)
            .effect(new EffectInstance(Effects.POISON, 1200, 3), 1.0F)
            .effect(new EffectInstance(Effects.HUNGER, 300, 2), 1.0F)
            .effect(new EffectInstance(Effects.CONFUSION, 300, 0), 1.0F)
            .effect(new EffectInstance(Effects.WITHER, 600, 2), 1.0F).alwaysEat().build();
    public static final RegistryObject<Item> VACCINE_ITEM = ITEMS.register("vaccine",
            () -> new Item(new Item.Properties().tab(ModSetup.ITEM_GROUP).food(VACCINE)));
}
