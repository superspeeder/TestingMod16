package org.delusion.testmod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.delusion.testmod.block.GlowstoneParticleFountainBlock;
import org.delusion.testmod.init.BlockInit;
import org.delusion.testmod.init.IInit;
import org.delusion.testmod.init.ItemInit;

@Mod(TestMod.MODID)
public class TestMod {
    public static final String MODID = "testmod";
    public static final Logger logger = LogManager.getLogger("TestMod16");

    private void initAll(IInit... inits) {
        for (IInit init : inits) {
            init.init();
        }
    }

    public TestMod() {
        logger.info("Hello from TestMod16");
        RegistryLists.setupAll(FMLJavaModLoadingContext.get().getModEventBus());


        BlockInit blockInit = new BlockInit();
        ItemInit itemInit = new ItemInit();

        initAll(blockInit,itemInit);


        RegistryLists.ITEMS.add("testitem",new Item(new Item.Properties().group(ItemGroup.MISC)));
    }
}
