package com.tobikcze.azd_mod;


import com.tobikcze.azd_mod.blocks.AZDBlock.RenderTileEntityAZD;
import com.tobikcze.azd_mod.blocks.AZDBlock.TileEntityAZD;
import com.tobikcze.azd_mod.blocks.Barrier.RenderTileEntityBarrier;
import com.tobikcze.azd_mod.blocks.Cross.RenderTileEntityCross;
import com.tobikcze.azd_mod.blocks.Cross.TileEntityCross;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import static com.tobikcze.azd_mod.azd_mod.*;

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

        itemAzdBarrier.setCreativeTab(CreativeTabs.tabBlock);
        azdBlock.setCreativeTab(CreativeTabs.tabBlock);
        crossBlock.setCreativeTab(CreativeTabs.tabBlock);

        System.out.println("veemo");
    }
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        MinecraftForge.EVENT_BUS.register(new RenderTileEntityAZD());
        MinecraftForge.EVENT_BUS.register(new RenderTileEntityBarrier());
        MinecraftForge.EVENT_BUS.register(new RenderTileEntityCross());
        MinecraftForge.EVENT_BUS.register(new RenderTileEntityBarrier());
        MinecraftForge.EVENT_BUS.register(new RenderTileEntityBarrier());
        MinecraftForge.EVENT_BUS.register(new RenderTileEntityBarrier());
    }

}
