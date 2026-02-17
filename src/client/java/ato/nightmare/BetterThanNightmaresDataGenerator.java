package ato.nightmare;

import ato.nightmare.datagen.ModBlockLootTableProvider;
import ato.nightmare.datagen.ModBlockTagProvider;
import ato.nightmare.datagen.ModModelProvider;
import ato.nightmare.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BetterThanNightmaresDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModModelProvider::new);
	}
}
