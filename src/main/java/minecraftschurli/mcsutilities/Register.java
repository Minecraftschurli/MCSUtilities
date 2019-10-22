package minecraftschurli.mcsutilities;

import minecraftschurli.mcsutilities.objects.blocks.DarkGlassBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.RegistryObject;

import java.awt.*;

import static minecraftschurli.mcsutilities.MCSUtilities.*;

/**
 * @author Minecraftschurli
 * @version 2019-10-17
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class Register {

    private static final Item.Properties STANDARD_ITEM_PROPERTIES = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);

    public static final RegistryObject<Block> GOLD_DARK_GLASS_BLOCK = BLOCKS.register("gold_dark_glass", () -> new DarkGlassBlock(Block.Properties.create(net.minecraft.block.material.Material.GLASS).hardnessAndResistance(0.6F).sound(SoundType.GLASS), true));
    public static final RegistryObject<Item> GOLD_DARK_GLASS_ITEM = ITEMS.register("gold_dark_glass", () -> new BlockItem(GOLD_DARK_GLASS_BLOCK.get(), STANDARD_ITEM_PROPERTIES));
    public static final RegistryObject<Block> IRON_DARK_GLASS_BLOCK = BLOCKS.register("iron_dark_glass", () -> new DarkGlassBlock(Block.Properties.create(net.minecraft.block.material.Material.GLASS).hardnessAndResistance(0.6F).sound(SoundType.GLASS), false));
    public static final RegistryObject<Item> IRON_DARK_GLASS_ITEM = ITEMS.register("iron_dark_glass", () -> new BlockItem(IRON_DARK_GLASS_BLOCK.get(), STANDARD_ITEM_PROPERTIES));

    public static final RegistryObject<Block> GOLD_METALLIC_SAND_BLOCK = BLOCKS.register("gold_metallic_sand", () -> new SandBlock(new Color(0xDADB8F).getRGB(), Block.Properties.create(Material.SAND, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Item> GOLD_METALLIC_SAND_ITEM = ITEMS.register("gold_metallic_sand", () -> new BlockItem(GOLD_METALLIC_SAND_BLOCK.get(), STANDARD_ITEM_PROPERTIES));
    public static final RegistryObject<Block> IRON_METALLIC_SAND_BLOCK = BLOCKS.register("iron_metallic_sand", () -> new SandBlock(new Color(0xDBDBB4).getRGB(), Block.Properties.create(Material.SAND, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Item> IRON_METALLIC_SAND_ITEM = ITEMS.register("iron_metallic_sand", () -> new BlockItem(IRON_METALLIC_SAND_BLOCK.get(), STANDARD_ITEM_PROPERTIES));

    public static void register() {
    }
}
