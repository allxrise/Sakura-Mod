package io.github.allxrise.sakura;

import io.github.allxrise.sakura.block.ModBlocks;
import io.github.allxrise.sakura.util.SakuraModIdentifier;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;

public class Sakura implements ModInitializer {

    public static final ItemGroup SAKURA_ITEMGROUP = FabricItemGroupBuilder.create(new SakuraModIdentifier("itemgroup")).build();

    @Override
    public void onInitialize() {
        ModBlocks.initBlocks();
        ModBlocks.initBlockItems();
    }
}
