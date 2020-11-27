package org.delusion.testmod.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import org.delusion.testmod.RegistryLists;
import org.delusion.testmod.TestMod;
import org.delusion.testmod.block.GlowstoneParticleFountainBlock;

import java.util.ArrayList;
import java.util.List;

public class BlockInit implements IInit {

    @Override
    public void init() {
        addBlock("glowfountain", new GlowstoneParticleFountainBlock(
                AbstractBlock.Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.3f).setRequiresTool()),
                new Item.Properties().group(ItemGroup.REDSTONE));
    }


    /* --- FACTORY --- */

    private void addBlock(Block block, Item.Properties itemProperties) {
        RegistryLists.BLOCKS.add(block);
        RegistryLists.ITEMS.add(block.getRegistryName(), new BlockItem(block, itemProperties));
    }

    private void addBlock(ResourceLocation name, Block block, Item.Properties itemProperties) {
        addBlock(block.setRegistryName(name), itemProperties);
    }

    private void addBlock(String name, Block block, Item.Properties itemProperties) {
        addBlock(new ResourceLocation(TestMod.MODID, name), block, itemProperties);
    }
}
