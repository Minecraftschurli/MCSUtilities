package minecraftschurli.mcsutilities.datagen;

import minecraftschurli.mcslib.data.BaseLootTableProvider;
import minecraftschurli.mcsutilities.MCSUtilities;
import minecraftschurli.mcsutilities.Register;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.storage.loot.ConstantRange;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;

import javax.annotation.Nonnull;

/**
 * @author Minecraftschurli
 * @version 2019-10-22
 */
public class MCSUtilitiesBlockLootTableProvider extends BaseLootTableProvider {

    public MCSUtilitiesBlockLootTableProvider(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(Register.GOLD_DARK_GLASS_BLOCK.get(), LootTable.builder().addLootPool(LootPool.builder().acceptCondition(HAS_SILK_TOUCH).rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(Register.GOLD_DARK_GLASS_BLOCK.get()))));
        lootTables.put(Register.IRON_DARK_GLASS_BLOCK.get(), LootTable.builder().addLootPool(LootPool.builder().acceptCondition(HAS_SILK_TOUCH).rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(Register.IRON_DARK_GLASS_BLOCK.get()))));
    }// func_218466_b

    @Override
    @Nonnull
    public String getName() {
        return "MCSUtilities LootTables";
    }
}
