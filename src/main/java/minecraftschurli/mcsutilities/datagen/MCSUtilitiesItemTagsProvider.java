package minecraftschurli.mcsutilities.datagen;

import minecraftschurli.mcslib.data.BaseItemTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author Minecraftschurli
 * @version 2019-10-22
 */
public class MCSUtilitiesItemTagsProvider extends BaseItemTagsProvider {

    private Set<ResourceLocation> filter = null;

    public MCSUtilitiesItemTagsProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    public void registerTags() {
        registerSuperTags();

        this.filter = this.tagToBuilder.keySet().stream().map(Tag::getId).collect(Collectors.toSet());

    }

    @Override
    protected Path makePath(ResourceLocation id) {
        return this.filter != null && this.filter.contains(id) ? null : super.makePath(id); //We don't want to save vanilla tags.
    }

    @Override
    @Nonnull
    public String getName() {
        return "MCSUtilities ItemTags";
    }

}
