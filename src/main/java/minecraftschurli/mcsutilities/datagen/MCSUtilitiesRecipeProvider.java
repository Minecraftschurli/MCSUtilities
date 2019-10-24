package minecraftschurli.mcsutilities.datagen;

import minecraftschurli.mcslib.data.RecipeHelper;
import minecraftschurli.mcsutilities.MCSUtilities;
import minecraftschurli.mcsutilities.Register;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

/**
 * @author Minecraftschurli
 * @version 2019-10-22
 */
public class MCSUtilitiesRecipeProvider extends RecipeProvider {
    public MCSUtilitiesRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder
                .shapedRecipe(Register.IRON_METALLIC_SAND_ITEM.get())
                .patternLine("XY")
                .patternLine("YX")
                .key('Y', Tags.Items.SAND)
                .key('X', Tags.Items.NUGGETS_IRON)
                .addCriterion("sand", InventoryChangeTrigger.Instance.forItems(ItemPredicate.Builder.create().tag(Tags.Items.SAND).build()))
                .addCriterion("nugget", InventoryChangeTrigger.Instance.forItems(ItemPredicate.Builder.create().tag(Tags.Items.NUGGETS_IRON).build()))
                .build(consumer, new ResourceLocation(MCSUtilities.MODID, "iron_metallic_sand"));
        ShapedRecipeBuilder
                .shapedRecipe(Register.GOLD_METALLIC_SAND_ITEM.get())
                .patternLine("XY")
                .patternLine("YX")
                .key('Y', Tags.Items.SAND)
                .key('X', Tags.Items.NUGGETS_GOLD)
                .addCriterion("sand", InventoryChangeTrigger.Instance.forItems(ItemPredicate.Builder.create().tag(Tags.Items.SAND).build()))
                .addCriterion("nugget", InventoryChangeTrigger.Instance.forItems(ItemPredicate.Builder.create().tag(Tags.Items.NUGGETS_GOLD).build()))
                .build(consumer, new ResourceLocation(MCSUtilities.MODID, "gold_metallic_sand"));
        CookingRecipeBuilder
                .blastingRecipe(Ingredient.fromItems(Register.GOLD_METALLIC_SAND_ITEM.get()), Register.GOLD_DARK_GLASS_ITEM.get(), 0, 200)
                .addCriterion("metallic_sand", InventoryChangeTrigger.Instance.forItems(Register.GOLD_METALLIC_SAND_ITEM.get()))
                .build(consumer, new ResourceLocation(MCSUtilities.MODID, "gold_dark_glass_0"));
        CookingRecipeBuilder
                .blastingRecipe(Ingredient.fromItems(Register.IRON_METALLIC_SAND_ITEM.get()), Register.IRON_DARK_GLASS_ITEM.get(), 0, 200)
                .addCriterion("metallic_sand", InventoryChangeTrigger.Instance.forItems(Register.IRON_METALLIC_SAND_ITEM.get()))
                .build(consumer, new ResourceLocation(MCSUtilities.MODID, "iron_dark_glass_0"));
    }

    @Override
    @Nonnull
    public String getName() {
        return "MCSUtilities Recipes";
    }
}
