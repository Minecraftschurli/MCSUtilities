package minecraftschurli.mcsutilities.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Minecraftschurli
 * @version 2019-10-20
 */
@SuppressWarnings("deprecation")
public class DarkGlassBlock extends StainedGlassBlock {
    public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;
    private final boolean toggleable;

    public DarkGlassBlock(Properties properties, boolean toggleable) {
        super(DyeColor.BLACK, properties);
        this.toggleable = toggleable;
        this.setDefaultState(this.stateContainer.getBaseState().with(ENABLED, true));
    }

    @Override
    protected void fillStateContainer(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ENABLED);
    }

    @Override
    public void neighborChanged(@Nonnull BlockState state, @Nonnull World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (toggleable)
            worldIn.setBlockState(pos, state.with(ENABLED, isEnabled(worldIn, pos, fromPos)));
    }

    private boolean isEnabled(@Nonnull World worldIn, BlockPos pos, BlockPos fromPos) {
        if (worldIn.isBlockPowered(fromPos) || worldIn.isBlockPowered(pos)) {
            return false;
        }
        if (worldIn.getBlockState(fromPos).getBlock() instanceof DarkGlassBlock){
            return worldIn.getBlockState(fromPos).get(ENABLED);
        }
        return true;
    }

    @Override
    public int getOpacity(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        if (state.get(ENABLED)) {
            return worldIn.getMaxLightLevel();
        }
        return super.getOpacity(state, worldIn, pos);
    }

    @Nullable
    @Override
    public float[] getBeaconColorMultiplier(BlockState state, IWorldReader world, BlockPos pos, BlockPos beaconPos) {
        return null;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("desc.dark_glass").setStyle(new Style().setColor(TextFormatting.GRAY)));
        if (toggleable)
            tooltip.add(new TranslationTextComponent("desc.dark_glass.toggleable").setStyle(new Style().setColor(TextFormatting.GRAY)));
    }
}
