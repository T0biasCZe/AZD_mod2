package com.tobikcze.azd_mod;


import com.tobikcze.azd_mod.blocks.AZDBlock.RenderTileEntityAZD;
import com.tobikcze.azd_mod.blocks.AZDBlock.TileEntityAZD;
import com.tobikcze.azd_mod.blocks.Cross.RenderTileEntityCross;
import com.tobikcze.azd_mod.blocks.Cross.TileEntityCross;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import static com.tobikcze.azd_mod.azd_mod.azdBlock;
import static com.tobikcze.azd_mod.azd_mod.crossBlock;

public class ClientProxy extends CommonProxy {

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods as well.
    //create preInit method
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAZD.class, new RenderTileEntityAZD());
        ClientRegistry.bindTileEntitySpecialRenderer(com.tobikcze.azd_mod.blocks.Cross.TileEntityCross.class, new com.tobikcze.azd_mod.blocks.Cross.RenderTileEntityCross());
        ClientRegistry.bindTileEntitySpecialRenderer(com.tobikcze.azd_mod.blocks.Barrier3.TileEntityBarrier.class, new com.tobikcze.azd_mod.blocks.Barrier3.RenderTileEntityBarrier());
        ClientRegistry.bindTileEntitySpecialRenderer(com.tobikcze.azd_mod.blocks.Barrier2.TileEntityBarrier.class, new com.tobikcze.azd_mod.blocks.Barrier2.RenderTileEntityBarrier());
        ClientRegistry.bindTileEntitySpecialRenderer(com.tobikcze.azd_mod.blocks.Barrier1.TileEntityBarrier.class, new com.tobikcze.azd_mod.blocks.Barrier1.RenderTileEntityBarrier());
        ClientRegistry.bindTileEntitySpecialRenderer(com.tobikcze.azd_mod.blocks.Barrier.TileEntityBarrier.class, new com.tobikcze.azd_mod.blocks.Barrier.RenderTileEntityBarrier());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(azdBlock), new GenericBlockItemRenderer(new RenderTileEntityAZD(), new TileEntityAZD()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(crossBlock), new GenericBlockItemRenderer(new RenderTileEntityCross(), new TileEntityCross()));
        System.out.println("veemo");
    }

}
