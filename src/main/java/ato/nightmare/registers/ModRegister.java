package ato.nightmare.registers;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import java.util.function.Function;

import static ato.nightmare.BetterThanNightmares.MOD_ID;
import static net.minecraft.world.item.CreativeModeTabs.*;

public final class ModRegister {
    // ITEMS
    public static final Item HELLITE = registerItem("hellite", Item::new, new Item.Properties());

    public static final Block HELLITE_ORE = register("hellite_ore",
            settings -> new DropExperienceBlock(UniformInt.of(2, 5), settings),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.NETHER)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
                    .sound(SoundType.NETHER_ORE)

    );

    private static Block register(String path, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        final Identifier identifier = Identifier.fromNamespaceAndPath(MOD_ID, path);
        final ResourceKey<Block> registryKey = ResourceKey.create(Registries.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, properties);
        Items.registerBlock(block);
        return block;
    }

    //WretchWood
    //HopesStone

    public static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> factory, Block.Properties properties) {
        final ResourceKey<Block> registryKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, name));
        return Blocks.register(registryKey, factory, properties);
    }

//    public static final ResourceKey<CreativeModeTab> BTN_CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MOD_ID, "btn_creative_tab"));
//
//    public static final CreativeModeTab BTN_CREATIVE_TAB_ITEMS = FabricItemGroup.builder()
//            .icon(() -> new ItemStack(HELLITE))
//            .title(Component.translatable("better-than-nightmares.itemGroup.btn"))
//            .displayItems((params, output) -> {
//                output.accept(HELLITE);
//                output.accept(HELLITE_ORE);
//            })
//            .build();

    public static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
        final ResourceKey<Item> registryKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));
        return Items.registerItem(registryKey, factory, properties);
    }
    public static void initialize() {
        // Register the group.
//        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BTN_CUSTOM_CREATIVE_TAB_KEY, BTN_CREATIVE_TAB_ITEMS);

        ItemGroupEvents.modifyEntriesEvent(INGREDIENTS).register(content -> {
            content.addAfter(Items.NETHERITE_INGOT, HELLITE);
        });

        ItemGroupEvents.modifyEntriesEvent(NATURAL_BLOCKS).register(content -> {
            content.addAfter(Items.NETHER_GOLD_ORE, HELLITE_ORE);
        });
    }

}