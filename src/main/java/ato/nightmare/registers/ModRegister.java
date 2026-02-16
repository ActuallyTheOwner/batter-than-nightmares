package ato.nightmare.registers;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static ato.nightmare.BetterThanNightmares.MOD_ID;

public final class ModRegister {
    // ITEMS
    public static final Item HELLITE = registerItem("hellite", Item::new, new Item.Settings());
//    public static final Block HELLITE_ORE = register("hellite_ore",
//            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), settings),
//            AbstractBlock.Settings.create()
//                    .mapColor(MapColor.DARK_RED)
//                    .instrument(NoteBlockInstrument.BASEDRUM)
//                    .requiresTool()
//                    .strength(3.0F, 3.0F)
//                    .sounds(BlockSoundGroup.NETHER_ORE)
//
//    );

    public static final Block HELLITE_ORE = register("hellite_ore", Block::new, Block.Settings.create()
                    .mapColor(MapColor.DARK_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(3.0F, 3.0F)
                    .sounds(BlockSoundGroup.NETHER_ORE)

    );
    
    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    //WretchWood
    //HopesStone
    //FUNCTIONS
    public static Block registerBlock(String name, Function<Block.Settings, Block> factory, Block.Settings settings) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name));
        return Blocks.register(registryKey, factory, settings);
    }

    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
        return Items.register(registryKey, factory, settings);
    }
    public static void initialize() {
    }

}