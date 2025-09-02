package ato.nightmare.registers;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static ato.nightmare.BetterThanNightmares.MOD_ID;

public final class ModItems {
    //WretchWood
    //HopesStone

    public static final Item ROSE_QUARTZ = register("hellite", Item::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    public static void initialize() {
    }

}