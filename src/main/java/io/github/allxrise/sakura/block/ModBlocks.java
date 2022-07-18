package io.github.allxrise.sakura.block;

import io.github.allxrise.sakura.Sakura;
import io.github.allxrise.sakura.util.SakuraModIdentifier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class ModBlocks {
    public static final Block SAKURA_LEAVES;
    public static final PillarBlock SAKURA_LOG;
    public static final Block SAKURA_PLANKS;
    public static final StairsBlock SAKURA_STAIRS;
    public static final SlabBlock SAKURA_SLAB;
    public static final FenceBlock SAKURA_FENCE;

    static {
        SAKURA_LEAVES = new SakuraLeaves(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).suffocates(((state, world, pos) -> false)).nonOpaque().allowsSpawning(ModBlocks::canSpawnOnLeaves).blockVision((state, world, pos) -> false).sounds(BlockSoundGroup.GRASS).ticksRandomly());
        SAKURA_LOG = new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? MapColor.DULL_RED : MapColor.OFF_WHITE).strength(2.0f).sounds(BlockSoundGroup.WOOD));
        SAKURA_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
        SAKURA_STAIRS = new StairsBlock(SAKURA_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(SAKURA_PLANKS));
        SAKURA_SLAB = new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.OAK_TAN).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
        SAKURA_FENCE = new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, SAKURA_PLANKS.getDefaultMapColor()).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    }

    // not stolen from minecraft's code, mojang won't mind it, right? :)
    private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }

    public static void initBlocks() {
        Registry.register(Registry.BLOCK, new SakuraModIdentifier("sakura_leaves"), SAKURA_LEAVES);
        Registry.register(Registry.BLOCK, new SakuraModIdentifier("sakura_log"), SAKURA_LOG);
        Registry.register(Registry.BLOCK, new SakuraModIdentifier("sakura_planks"), SAKURA_PLANKS);
        Registry.register(Registry.BLOCK, new SakuraModIdentifier("sakura_stairs"), SAKURA_STAIRS);
        Registry.register(Registry.BLOCK, new SakuraModIdentifier("sakura_slab"), SAKURA_SLAB);
        Registry.register(Registry.BLOCK, new SakuraModIdentifier("sakura_fence"), SAKURA_FENCE);
    }

    public static void initBlockItems() {
        Registry.register(Registry.ITEM, new SakuraModIdentifier("sakura_leaves"), new BlockItem(SAKURA_LEAVES, new FabricItemSettings().group(Sakura.SAKURA_ITEMGROUP)));
        Registry.register(Registry.ITEM, new SakuraModIdentifier("sakura_log"), new BlockItem(SAKURA_LOG, new FabricItemSettings().group(Sakura.SAKURA_ITEMGROUP)));
        Registry.register(Registry.ITEM, new SakuraModIdentifier("sakura_planks"), new BlockItem(SAKURA_PLANKS, new FabricItemSettings().group(Sakura.SAKURA_ITEMGROUP)));
        Registry.register(Registry.ITEM, new SakuraModIdentifier("sakura_stairs"), new BlockItem(SAKURA_STAIRS, new FabricItemSettings().group(Sakura.SAKURA_ITEMGROUP)));
        Registry.register(Registry.ITEM, new SakuraModIdentifier("sakura_slab"), new BlockItem(SAKURA_SLAB, new FabricItemSettings().group(Sakura.SAKURA_ITEMGROUP)));
        Registry.register(Registry.ITEM, new SakuraModIdentifier("sakura_fence"), new BlockItem(SAKURA_FENCE, new FabricItemSettings().group(Sakura.SAKURA_ITEMGROUP)));
    }
}
