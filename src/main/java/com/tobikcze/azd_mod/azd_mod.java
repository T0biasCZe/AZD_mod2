package com.tobikcze.azd_mod;

import com.tobikcze.azd_mod.blocks.Barrier.RenderTileEntityBarrier;
import com.tobikcze.azd_mod.blocks.Barrier.TileEntityBarrier;
import com.tobikcze.azd_mod.blocks.Cross.RenderTileEntityCross;
import com.tobikcze.azd_mod.blocks.Cross.TileEntityCross;
import com.tobikcze.azd_mod.items.ItemAzdBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
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
import cpw.mods.fml.common.SidedProxy;
@Mod(
    modid = Reference.MOD_ID,
    version = Reference.VERSION,
    name = Reference.NAME,
    acceptedMinecraftVersions = "[1.7.10]"
)
public class azd_mod {

    @SidedProxy(clientSide = "com.tobikcze.azd_mod.ClientProxy", serverSide = "com.tobikcze.azd_mod.CommonProxy")
    public static CommonProxy proxy;
    public static Item itemAzdBarrier;
    public static Item  itemAzdBlock;

    public static Block azdBlock;
    public static Block azdBlock1;
    public static Block azdBlock2;
    public static Block azdBlock3;
    public static Block barrierBlock0;
    public static Block barrierBlock1;
    public static Block barrierBlock2;
    public static Block barrierBlock3;
    public static Block crossBlock;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Item/Block init and registering

        itemAzdBlock = new ItemAzdBlock().setUnlocalizedName("itemAzdBlock");
        GameRegistry.registerItem(itemAzdBlock, itemAzdBlock.getUnlocalizedName().substring(5));
        System.out.println("test 1");
        azdBlock = new com.tobikcze.azd_mod.blocks.AZDBlock.AZDBlock().setBlockName("AzdBlock");
        GameRegistry.registerBlock(azdBlock, azdBlock.getUnlocalizedName().substring(5));
        System.out.println("test 2");
        azdBlock1 = new com.tobikcze.azd_mod.blocks.AZDBlock1.AZDBlock().setBlockName("AzdBlock1");
        GameRegistry.registerBlock(azdBlock1, azdBlock1.getUnlocalizedName().substring(5));
        System.out.println("test 3");
        azdBlock2 = new com.tobikcze.azd_mod.blocks.AZDBlock2.AZDBlock().setBlockName("AzdBlock2");
        GameRegistry.registerBlock(azdBlock2, azdBlock2.getUnlocalizedName().substring(5));
        System.out.println("test 4");
        azdBlock3 = new com.tobikcze.azd_mod.blocks.AZDBlock3.AZDBlock().setBlockName("AzdBlock3");
        GameRegistry.registerBlock(azdBlock3, azdBlock3.getUnlocalizedName().substring(5));
        System.out.println("test 5");


        itemAzdBarrier = new ItemAzdBarrier().setUnlocalizedName("itemAzdBarrier");;
        System.out.println("test 5.5");
        GameRegistry.registerItem(itemAzdBarrier, itemAzdBarrier.getUnlocalizedName().substring(5));
        System.out.println("test 6");
        barrierBlock0 = new com.tobikcze.azd_mod.blocks.Barrier.BarrierBlock().setBlockName("BarrierBlock0");
        GameRegistry.registerBlock(barrierBlock0, barrierBlock0.getUnlocalizedName().substring(5));
        System.out.println("test 7");
        barrierBlock1 = new com.tobikcze.azd_mod.blocks.Barrier1.BarrierBlock().setBlockName("BarrierBlock1");
        GameRegistry.registerBlock(barrierBlock1, barrierBlock1.getUnlocalizedName().substring(5));
        System.out.println("test 8");
        barrierBlock2 = new com.tobikcze.azd_mod.blocks.Barrier2.BarrierBlock().setBlockName("BarrierBlock2");
        GameRegistry.registerBlock(barrierBlock2, barrierBlock2.getUnlocalizedName().substring(5));
        System.out.println("test 9");
        barrierBlock3 = new com.tobikcze.azd_mod.blocks.Barrier3.BarrierBlock().setBlockName("BarrierBlock3");
        GameRegistry.registerBlock(barrierBlock3, barrierBlock3.getUnlocalizedName().substring(5));
        System.out.println("test 10");

        crossBlock = new com.tobikcze.azd_mod.blocks.Cross.CrossBlock().setBlockName("CrossBlock");
        GameRegistry.registerBlock(crossBlock, crossBlock.getUnlocalizedName().substring(5));

        System.out.println("super luigi galaxyyy");
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("super weegie galaxyyy");
        proxy.init(event);
        // Proxy, TileEntity, entity, GUI and Packet registering


        GameRegistry.addRecipe(new net.minecraft.item.ItemStack(itemAzdBlock, 1), new Object[]{"GLG", "NIN", "SRS", 'G', Blocks.glass_pane, 'L', Blocks.redstone_lamp, 'N', Blocks.noteblock, 'I', Items.iron_ingot, 'S', Blocks.stone, 'R', Items.redstone});

        GameRegistry.addRecipe(new net.minecraft.item.ItemStack(itemAzdBarrier, 1), new Object[]{"WRI", "PPM", "WRI", 'W', new ItemStack(Items.dye, 1, 15), 'R', new ItemStack(Items.dye, 1, 1), 'I', Items.iron_ingot, 'P', Blocks.planks, 'M', Blocks.piston});

        GameRegistry.addRecipe(new ItemStack(crossBlock, 1), new Object[]{"R R", " R ", "RIR", 'R', new ItemStack(Items.dye, 1, 1), 'I', Items.iron_ingot});
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
