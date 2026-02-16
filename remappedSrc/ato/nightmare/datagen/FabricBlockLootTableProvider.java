package ato.nightmare.datagen;

import ato.nightmare.registers.ModRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import java.util.concurrent.CompletableFuture;

public class FabricBlockLootTableProvider extends net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider {

    public FabricBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
    dropOther(ModRegister.HELLITE_ORE, ModRegister.HELLITE);
    }
}