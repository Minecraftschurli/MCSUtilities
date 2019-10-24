package minecraftschurli.mcsutilities.datagen;

import minecraftschurli.mcsutilities.MCSUtilities;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * @author Minecraftschurli
 * @version 2019-10-22
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MCSUtilities.MODID)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            // generator.addProvider(new MCSUtilitiesItemTagsProvider(generator));
            // generator.addProvider(new MCSUtilitiesBlockTagsProvider(generator));
            generator.addProvider(new MCSUtilitiesRecipeProvider(generator));
            generator.addProvider(new MCSUtilitiesBlockLootTableProvider(generator));
        }
    }
}
