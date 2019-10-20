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
public class DarkGlassBlock extends StainedGlassBlock {
    public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;
    public DarkGlassBlock(Properties properties) {
        super(DyeColor.BLACK, properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(ENABLED, true));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ENABLED);
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        worldIn.setBlockState(pos, state.with(ENABLED, !(worldIn.isBlockPowered(fromPos) || worldIn.isBlockPowered(pos) || !isEnabled(worldIn, fromPos))));
    }

    private boolean isEnabled(World worldIn, BlockPos fromPos) {
        if (worldIn.getBlockState(fromPos).getBlock() instanceof DarkGlassBlock){
            return worldIn.getBlockState(fromPos).get(ENABLED);
        }
        return true;
    }

    @Override
    public int getOpacity(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        if (state.get(ENABLED)) {
            return 15;
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
    }
}
