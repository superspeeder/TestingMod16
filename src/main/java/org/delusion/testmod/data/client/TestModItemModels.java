package org.delusion.testmod.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.delusion.testmod.TestMod;

public class TestModItemModels extends ItemModelProvider {
    public TestModItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.singleTexture("testitem", mcLoc("generated"), "layer0",modLoc("item/testitem"));
    }
}
