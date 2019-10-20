package minecraftschurli.mcsutilities;

import minecraftschurli.mcsutilities.objects.blocks.DarkGlassBlock;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

import static minecraftschurli.mcsutilities.MCSUtilities.*;

/**
 * @author Minecraftschurli
 * @version 2019-10-17
 */
public class Register {

    /*private static final ItemGroup GROUP = new ItemGroup(MODID) {
        @Override
        public ItemStack createIcon() {
            return ItemStack.EMPTY;
        }
    };*/
    private static final Item.Properties STANDARD_ITEM_PROPERTIES = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);

    /*public static final Material COPPER = new Material("copper")
            .withStorageBlock(Block.Properties.create(net.minecraft.block.material.Material.IRON, DyeColor.ORANGE), STANDARD_ITEM_PROPERTIES)
            .withIngot(STANDARD_ITEM_PROPERTIES)
            .withNugget(STANDARD_ITEM_PROPERTIES)
            .withDust(STANDARD_ITEM_PROPERTIES);

    public static final Material TIN = new Material("tin")
            .withStorageBlock(Block.Properties.create(net.minecraft.block.material.Material.IRON, DyeColor.WHITE), STANDARD_ITEM_PROPERTIES)
            .withIngot(STANDARD_ITEM_PROPERTIES)
            .withNugget(STANDARD_ITEM_PROPERTIES)
            .withDust(STANDARD_ITEM_PROPERTIES);

    public static final Material ALUMINIUM = new Material("aluminium")
            .withStorageBlock(Block.Properties.create(net.minecraft.block.material.Material.IRON, DyeColor.WHITE), STANDARD_ITEM_PROPERTIES)
            .withIngot(STANDARD_ITEM_PROPERTIES)
            .withNugget(STANDARD_ITEM_PROPERTIES)
            .withDust(STANDARD_ITEM_PROPERTIES);

    public static final Material SILVER = new Material("silver")
            .withStorageBlock(Block.Properties.create(net.minecraft.block.material.Material.IRON, DyeColor.WHITE), STANDARD_ITEM_PROPERTIES)
            .withIngot(STANDARD_ITEM_PROPERTIES)
            .withNugget(STANDARD_ITEM_PROPERTIES)
            .withDust(STANDARD_ITEM_PROPERTIES);

    public static final Material LEAD = new Material("lead")
            .withStorageBlock(Block.Properties.create(net.minecraft.block.material.Material.IRON, DyeColor.WHITE), STANDARD_ITEM_PROPERTIES)
            .withIngot(STANDARD_ITEM_PROPERTIES)
            .withNugget(STANDARD_ITEM_PROPERTIES)
            .withDust(STANDARD_ITEM_PROPERTIES);

    public static final Material STEEL = new Material("steel")
            .withStorageBlock(Block.Properties.create(net.minecraft.block.material.Material.IRON, DyeColor.GRAY), STANDARD_ITEM_PROPERTIES)
            .withIngot(STANDARD_ITEM_PROPERTIES)
            .withNugget(STANDARD_ITEM_PROPERTIES)
            .withDust(STANDARD_ITEM_PROPERTIES);*/

    /*public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));*/

    public static final RegistryObject<Block> DARK_GLASS_BLOCK = BLOCKS.register("dark_glass", () -> new DarkGlassBlock(Block.Properties.create(net.minecraft.block.material.Material.GLASS).hardnessAndResistance(0.6F).sound(SoundType.GLASS)));
    public static final RegistryObject<Item> DARK_GLASS_ITEM = ITEMS.register("dark_glass", () -> new BlockItem(DARK_GLASS_BLOCK.get(), STANDARD_ITEM_PROPERTIES));

    public static void register() {
        /*COPPER.register(BLOCKS, ITEMS);
        TIN.register(BLOCKS, ITEMS);
        ALUMINIUM.register(BLOCKS, ITEMS);
        SILVER.register(BLOCKS, ITEMS);
        LEAD.register(BLOCKS, ITEMS);
        STEEL.register(BLOCKS, ITEMS);*/
    }
}
