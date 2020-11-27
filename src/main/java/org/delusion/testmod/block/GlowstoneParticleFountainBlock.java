package org.delusion.testmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PistonBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class GlowstoneParticleFountainBlock extends Block {
    public static final BooleanProperty ON = BooleanProperty.create("on");

    public GlowstoneParticleFountainBlock(Properties properties) {
        super(properties);
        setDefaultState(this.getStateContainer().getBaseState().with(ON,false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(ON);
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        if (worldIn.isBlockPowered(pos))
            worldIn.addOptionalParticle(new RedstoneParticleData(1.0f,1.0f,0.0f, 1.0f),pos.getX() + 0.5d, pos.getY() + 1.25d, pos.getZ() + 0.5d, rand.nextDouble() / 2d + 1d, rand.nextDouble() * 2d + 13.5d, rand.nextDouble() / 2d + 1d);
    }

    @Override
    public boolean canConnectRedstone(BlockState state, IBlockReader world, BlockPos pos, Direction side) {
        return true;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (!worldIn.isRemote) {
            if (worldIn.isBlockPowered(pos))
                worldIn.setBlockState(pos,state.with(ON, true));
            else
                worldIn.setBlockState(pos,state.with(ON, false));
        }
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
        if (!worldIn.isRemote) {
            if (worldIn.isBlockPowered(pos))
                worldIn.setBlockState(pos,state.with(ON, true));
            else
                worldIn.setBlockState(pos,state.with(ON, false));
        }
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
        if (!worldIn.isRemote) {
            if (worldIn.isBlockPowered(pos))
                worldIn.setBlockState(pos,state.with(ON, true));
            else
                worldIn.setBlockState(pos,state.with(ON, false));
        }
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        if (state.get(ON)) {
            return 15;
        }
        return 0;
    }
}
