package ato.nightmare.datagen;

import ato.nightmare.registers.ModRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
                //not explained in docs, you need both smelt recipes as it is not automatic
                //https://minecraft.wiki/w/Smelting#Recipes
                oreSmelting(
                        List.of(ModRegister.HELLITE_ORE), // Inputs
                        RecipeCategory.MISC, // Category
                        ModRegister.HELLITE, // Output
                        0.7f, // Experience
                        200, // Cooking time
                        "hellite_smelt" // group
                );

                oreBlasting(
                        List.of(ModRegister.HELLITE_ORE), // Inputs
                        RecipeCategory.MISC, // Category
                        ModRegister.HELLITE, // Output
                        0.7f, // Experience
                        100, // Cooking time
                        "hellite_smelt" // group
                );
            }
        };
    }

    @Override
    public String getName() {
        return ("BTNModRecipeProvider");
    }
}
