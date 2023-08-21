package com.tobikcze.azd_mod.blocks.Barrier3;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityBarrier extends TileEntity {

    public float rotation = 0;
    public int redstonePower = 0;
    public int counterin = 0;
    public int counter = -1;
    public int redstonePower2 = 0;
    public int tick = 0;

    @Override
    public void updateEntity() {
        counterin++;
        World world = this.worldObj;
        redstonePower = world.getStrongestIndirectPower(this.xCoord, this.yCoord - 3, this.zCoord);
    }
}
