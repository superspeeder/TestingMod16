package org.delusion.testmod.data.client;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.delusion.testmod.RegistryLists;
import org.delusion.testmod.TestMod;
import org.delusion.testmod.block.GlowstoneParticleFountainBlock;

public class TestModBlockStates extends BlockStateProvider {
    public TestModBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TestMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        Block glowfountain = RegistryLists.BLOCKS.get(modLoc("glowfountain"));
        VariantBlockStateBuilder glowfountain_variantbuilder = getVariantBuilder(glowfountain);
        glowfountain_variantbuilder.partialState().with(GlowstoneParticleFountainBlock.ON, false).addModels(new ConfiguredModel(models().cubeAll("glowfountain_off", modLoc("block/glowfountain_off"))));
        glowfountain_variantbuilder.partialState().with(GlowstoneParticleFountainBlock.ON, true).addModels(new ConfiguredModel(models().cubeAll("glowfountain_on", modLoc("block/glowfountain_on"))));

        itemModels().cubeAll("glowfountain",modLoc("block/glowfountain_on"));
    }
}
