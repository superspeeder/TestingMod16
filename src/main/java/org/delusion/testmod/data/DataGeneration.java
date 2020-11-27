package org.delusion.testmod.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourcePackType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import org.delusion.testmod.TestMod;
import org.delusion.testmod.data.client.TestModBlockStates;
import org.delusion.testmod.data.client.TestModItemModels;
import org.delusion.testmod.data.client.TestModLang;
import org.delusion.testmod.data.server.LootProvider;
import org.delusion.testmod.data.server.TestModRecipesProvider;

import java.util.Collections;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TestMod.MODID)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper exfh = new ExistingFileHelper(Collections.emptyList(),false) {
            @Override
            public boolean exists(ResourceLocation loc, ResourcePackType type) {
                return true;
            }
        };
        gen.addProvider(new TestModItemModels(gen, exfh));
        gen.addProvider(new TestModBlockStates(gen, exfh));
        gen.addProvider(new TestModLang(gen, "en_us"));
        gen.addProvider(new LootProvider(gen));
        gen.addProvider(new TestModRecipesProvider(gen));

    }
}
