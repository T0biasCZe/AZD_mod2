package com.tobikcze.azd_mod.blocks.Cross3;

import com.tobikcze.azd_mod.azd_mod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CrossBlock extends BlockContainer {

    public CrossBlock() {
        super(Material.iron);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        TileEntityCross tileEntityCross = new TileEntityCross();
        return tileEntityCross;
    }
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        dropCustomItem(world, x, y, z); // Custom method to drop the custom item
        super.breakBlock(world, x, y, z, block, metadata);
    }

    private void dropCustomItem(World world, int x, int y, int z) {
        // Spawn your custom item as an EntityItem at the block's position
        if (!world.isRemote) {
            ItemStack itemStack = new ItemStack(azd_mod.itemCrossBlock); // Replace with your custom item
            float xOffset = 0.7F;
            float yOffset = 0.7F;
            float zOffset = 0.7F;
            world.spawnEntityInWorld(new EntityItem(world, x + xOffset, y + yOffset, z + zOffset, itemStack));
        }
    }
}
