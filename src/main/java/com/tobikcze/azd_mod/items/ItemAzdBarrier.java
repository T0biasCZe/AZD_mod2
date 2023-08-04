package com.tobikcze.azd_mod.items;

import com.tobikcze.azd_mod.azd_mod;
import com.tobikcze.azd_mod.blocks.Barrier2.BarrierBlock;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemAzdBarrier extends Item {
    public ItemAzdBarrier(String unlocalizedName) {
        // Set appropriate prperties for your item, such as name and creative tab
        setUnlocalizedName("azd_barrier");
        setCreativeTab(CreativeTabs.tabBlock);
        setTextureName("azd:itemAzdBarrier");

    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hiStY, float hitZ) {
        // Get the direction the player is facing
        int facing = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        // Determine the block to place based on the player's facing direction
        Block blockVariant;
        switch (facing) {
            case 0: // South
                blockVariant = azd_mod.barrierBlock2;
                break;
            case 1: // West
                blockVariant = azd_mod.barrierBlock3;
                break;
            case 2: // North
                blockVariant = azd_mod.barrierBlock0;
                break;
            default: // East
                blockVariant = azd_mod.barrierBlock1;
                break;
        }
        switch (side) {
            case 0: // Bottom
                world.setBlock(x, y - 1, z, blockVariant);
                break;
            case 1: // Top
                world.setBlock(x, y + 1, z, blockVariant);
                break;
            case 2: // North
                world.setBlock(x, y, z - 1, blockVariant);
                break;
            case 3: // South
                world.setBlock(x, y, z + 1, blockVariant);
                break;
            case 4: // West
                world.setBlock(x - 1, y, z, blockVariant);
                break;
            case 5: // East
                world.setBlock(x + 1, y, z, blockVariant);
                break;
        }

        return true;
    }
}
