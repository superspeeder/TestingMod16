package org.delusion.testmod.data.server;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import org.delusion.testmod.RegistryLists;

import java.util.function.Consumer;

public class TestModRecipesProvider extends RecipeProvider {
    public TestModRecipesProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(RegistryLists.ITEMS.get("glowfountain"))
                .patternLine("IGI")
                .patternLine("GRG")
                .patternLine("IGI")
                .key('I', Items.IRON_INGOT)
                .key('G', Items.GLOWSTONE_DUST)
                .key('R', Items.REDSTONE)
                .setGroup("testmod")
                .addCriterion("iron_ingot", InventoryChangeTrigger.Instance.forItems(Items.IRON_INGOT))
                .addCriterion("glowstone_dust", InventoryChangeTrigger.Instance.forItems(Items.GLOWSTONE_DUST))
                .addCriterion("redstone", InventoryChangeTrigger.Instance.forItems(Items.REDSTONE))
                .build(consumer);
    }
}
