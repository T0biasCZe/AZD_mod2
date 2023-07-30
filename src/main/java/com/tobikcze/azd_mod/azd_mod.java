package com.tobikcze.azd_mod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.tobikcze.azd_mod.blocks.AZDBlock.AZDBlock;
import com.tobikcze.azd_mod.blocks.AZDBlock.RenderTileEntityAZD;
import com.tobikcze.azd_mod.blocks.AZDBlock.TileEntityAZD;
import com.tobikcze.azd_mod.items.ItemAzdBarrier;

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

    public static Item itemAzdBarrier;

    public static Block azdBlock;
    public static Block barrierBlock0;
    public static Block barrierBlock1;
    public static Block barrierBlock2;
    public static Block barrierBlock3;
    public static Block crossBlock;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Item/Block init and registering
        itemAzdBarrier = new ItemAzdBarrier().setUnlocalizedName("ItemAzd")
            .setTextureName("azd:itemAzd"); // item.itemAzd.nameGameRegistry.registerItem(itemAzd,itemAzd.getUnlocalizedName().substring(5));

        GameRegistry.registerTileEntity(TileEntityAZD.class, "tileAZD");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAZD.class, new RenderTileEntityAZD());

        azdBlock = new AZDBlock().setBlockName("AzdBlock")
            .setBlockTextureName("azd:itemAzd.png");
        GameRegistry.registerBlock(
            azdBlock,
            azdBlock.getUnlocalizedName()
                .substring(5));

        GameRegistry.registerTileEntity(com.tobikcze.azd_mod.blocks.Barrier.TileEntityBarrier.class, "tileBarrier0");
        ClientRegistry.bindTileEntitySpecialRenderer(
            com.tobikcze.azd_mod.blocks.Barrier.TileEntityBarrier.class,
            new com.tobikcze.azd_mod.blocks.Barrier.RenderTileEntityBarrier());
        barrierBlock0 = new com.tobikcze.azd_mod.blocks.Barrier.BarrierBlock().setBlockName("BarrierBlock0");
        GameRegistry.registerBlock(
            barrierBlock0,
            barrierBlock0.getUnlocalizedName()
                .substring(5));

        GameRegistry.registerTileEntity(com.tobikcze.azd_mod.blocks.Barrier1.TileEntityBarrier.class, "tileBarrier1");
        ClientRegistry.bindTileEntitySpecialRenderer(
            com.tobikcze.azd_mod.blocks.Barrier1.TileEntityBarrier.class,
            new com.tobikcze.azd_mod.blocks.Barrier1.RenderTileEntityBarrier());
        barrierBlock1 = new com.tobikcze.azd_mod.blocks.Barrier1.BarrierBlock().setBlockName("BarrierBlock1");
        GameRegistry.registerBlock(
            barrierBlock1,
            barrierBlock1.getUnlocalizedName()
                .substring(5));

        GameRegistry.registerTileEntity(com.tobikcze.azd_mod.blocks.Barrier2.TileEntityBarrier.class, "tileBarrier2");
        ClientRegistry.bindTileEntitySpecialRenderer(
            com.tobikcze.azd_mod.blocks.Barrier2.TileEntityBarrier.class,
            new com.tobikcze.azd_mod.blocks.Barrier2.RenderTileEntityBarrier());
        barrierBlock2 = new com.tobikcze.azd_mod.blocks.Barrier2.BarrierBlock().setBlockName("BarrierBlock2");
        GameRegistry.registerBlock(
            barrierBlock2,
            barrierBlock2.getUnlocalizedName()
                .substring(5));

        GameRegistry.registerTileEntity(com.tobikcze.azd_mod.blocks.Barrier3.TileEntityBarrier.class, "tileBarrier3");
        ClientRegistry.bindTileEntitySpecialRenderer(
            com.tobikcze.azd_mod.blocks.Barrier3.TileEntityBarrier.class,
            new com.tobikcze.azd_mod.blocks.Barrier3.RenderTileEntityBarrier());
        barrierBlock3 = new com.tobikcze.azd_mod.blocks.Barrier3.BarrierBlock().setBlockName("BarrierBlock3");
        GameRegistry.registerBlock(
            barrierBlock3,
            barrierBlock3.getUnlocalizedName()
                .substring(5));

        GameRegistry.registerTileEntity(com.tobikcze.azd_mod.blocks.Cross.TileEntityCross.class, "tileCross");
        ClientRegistry.bindTileEntitySpecialRenderer(
            com.tobikcze.azd_mod.blocks.Cross.TileEntityCross.class,
            new com.tobikcze.azd_mod.blocks.Cross.RenderTileEntityCross());
        crossBlock = new com.tobikcze.azd_mod.blocks.Cross.CrossBlock().setBlockName("CrossBlock");
        GameRegistry.registerBlock(
            crossBlock,
            crossBlock.getUnlocalizedName()
                .substring(5));
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // Proxy, TileEntity, entity, GUI and Packet registering
        MinecraftForge.EVENT_BUS.register(new RenderTileEntityAZD());
        System.out.println("super weegie galaxyyy");

        GameRegistry.addRecipe(
            new net.minecraft.item.ItemStack(azdBlock, 1),
            new Object[] { "GLG", "NIN", "SRS", 'G', Blocks.glass_pane, 'L', Blocks.redstone_lamp, 'N',
                Blocks.noteblock, 'I', Items.iron_ingot, 'S', Blocks.stone, 'R', Items.redstone });

        GameRegistry.addRecipe(
            new net.minecraft.item.ItemStack(barrierBlock0, 1),
            new Object[] { "WRI", "PPM", "WRI", 'W', new ItemStack(Items.dye, 1, 15), 'R',
                new ItemStack(Items.dye, 1, 1), 'I', Items.iron_ingot, 'P', Blocks.planks, 'M', Blocks.piston });

        GameRegistry.addShapelessRecipe(
            new net.minecraft.item.ItemStack(barrierBlock1, 1),
            new Object[] { new ItemStack(barrierBlock0, 1) });

        GameRegistry.addShapelessRecipe(
            new net.minecraft.item.ItemStack(barrierBlock2, 1),
            new Object[] { new ItemStack(barrierBlock1, 1) });

        GameRegistry.addShapelessRecipe(
            new net.minecraft.item.ItemStack(barrierBlock3, 1),
            new Object[] { new ItemStack(barrierBlock2, 1) });

        GameRegistry.addShapelessRecipe(
            new net.minecraft.item.ItemStack(barrierBlock0, 1),
            new Object[] { new ItemStack(barrierBlock3, 1) });

        GameRegistry.addRecipe(
            new ItemStack(crossBlock, 1),
            new Object[] { "R R", " R ", "RIR", 'R', new ItemStack(Items.dye, 1, 1), 'I', Items.iron_ingot });
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
}
