package org.delusion.testmod.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import org.delusion.testmod.RegistryLists;
import org.delusion.testmod.TestMod;

public class TestModLang extends LanguageProvider {
    public TestModLang(DataGenerator gen, String locale) {
        super(gen, TestMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        addItem(RegistryLists.ITEMS.getter("testitem"), "Test Item");
        addBlock(RegistryLists.BLOCKS.getter("glowfountain"), "Glowstone Fountain");
    }
}
