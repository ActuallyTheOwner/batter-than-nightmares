package ato.nightmare.registers;

import net.minecraft.block.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.registry.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import java.util.function.Function;

import static ato.nightmare.BetterThanNightmares.MOD_ID;

public final class ModRegister {
    // ITEMS
    public static final Item HELLITE = registerItem("hellite", Item::new, new Item.Properties());
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

    public static final Block HELLITE_ORE = register("hellite_ore", Block::new, Block.Settings.of()
                    .mapColor(MapColor.NETHER)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
                    .sound(SoundType.NETHER_ORE)

    );
    
    private static Block register(String path, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        final Identifier identifier = Identifier.fromNamespaceAndPath(MOD_ID, path);
        final ResourceKey<Block> registryKey = ResourceKey.create(Registries.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.registerBlock(block);
        return block;
    }

    //WretchWood
    //HopesStone
    //FUNCTIONS
    public static Block registerBlock(String name, Function<Block.Settings, Block> factory, Block.Settings settings) {
        final ResourceKey<Block> registryKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, name));
        return Blocks.register(registryKey, factory, settings);
    }

    public static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
        final ResourceKey<Item> registryKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));
        return Items.registerItem(registryKey, factory, settings);
    }
    public static void initialize() {
    }

}