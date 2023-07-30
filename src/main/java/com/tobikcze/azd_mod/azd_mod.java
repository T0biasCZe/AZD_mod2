package com.tobikcze.azd_mod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import com.tobikcze.azd_mod.blocks.AZDBlock.AZDBlock;
import com.tobikcze.azd_mod.blocks.AZDBlock.RenderTileEntityAZD;
import com.tobikcze.azd_mod.blocks.AZDBlock.TileEntityAZD;
import com.tobikcze.azd_mod.blocks.Barrier.BarrierBlock;
import com.tobikcze.azd_mod.blocks.Barrier.RenderTileEntityBarrier;
import com.tobikcze.azd_mod.blocks.Barrier.TileEntityBarrier;
import com.tobikcze.azd_mod.items.ItemAzd;
import com.tobikcze.azd_mod.items.ItemAzdCrossMulti;
import com.tobikcze.azd_mod.items.ItemAzdCrossSingle;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
    modid = Reference.MOD_ID,
    version = Reference.VERSION,
    name = Reference.NAME,
    acceptedMinecraftVersions = "[1.7.10]")
public class azd_mod {

    public static Item itemAzd;
    public static Item itemAzdCrossSingle;
    public static Item itemAzdCrossMulti;

    public static Block blockAzd;
    public static Block blockAzdCrossSingle;
    public static Block blockAzdCrossMulti;

    public static Block azdBlock;
    public static Block barrierBlock;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Item/Block init and registering
        itemAzd = new ItemAzd().setUnlocalizedName("ItemAzd")
            .setTextureName("azd:itemAzd"); // item.itemAzd.name
        GameRegistry.registerItem(
            itemAzd,
            itemAzd.getUnlocalizedName()
                .substring(5));

        itemAzdCrossSingle = new ItemAzdCrossSingle().setUnlocalizedName("ItemAzdCrossSingle")
            .setTextureName("azd:itemAzdCrossSingle"); // item.itemAzdCrossSingle.name
        GameRegistry.registerItem(
            itemAzdCrossSingle,
            itemAzdCrossSingle.getUnlocalizedName()
                .substring(5));

        itemAzdCrossMulti = new ItemAzdCrossMulti().setUnlocalizedName("ItemAzdCrossMulti")
            .setTextureName("azd:itemAzdCrossMulti"); // item.itemAzdCrossMulti.name
        GameRegistry.registerItem(
            itemAzdCrossMulti,
            itemAzdCrossMulti.getUnlocalizedName()
                .substring(5));

        GameRegistry.registerTileEntity(TileEntityAZD.class, "tileAZD");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAZD.class, new RenderTileEntityAZD());

        azdBlock = new AZDBlock().setBlockName("AzdBlock");
        GameRegistry.registerBlock(
            azdBlock,
            azdBlock.getUnlocalizedName()
                .substring(5));

        GameRegistry.registerTileEntity(TileEntityBarrier.class, "tileBarrier");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrier.class, new RenderTileEntityBarrier());

        barrierBlock = new BarrierBlock().setBlockName("BarrierBlock");
        GameRegistry.registerBlock(
            barrierBlock,
            barrierBlock.getUnlocalizedName()
                .substring(5));
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // Proxy, TileEntity, entity, GUI and Packet registering
        MinecraftForge.EVENT_BUS.register(new RenderTileEntityAZD());
        System.out.println("super weegie galaxyyy");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
}
