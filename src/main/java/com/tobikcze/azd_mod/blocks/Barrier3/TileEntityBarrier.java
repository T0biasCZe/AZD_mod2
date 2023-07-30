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


    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        writeToNBT(nbtTagCompound);
        int metadata = getBlockMetadata();
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, metadata, nbtTagCompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }

    // Save the rotation to NBT data when the world is saved
    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setFloat("rotation", rotation);
        compound.setInteger("redstonePower", redstonePower);
        compound.setInteger("counterin", counterin);
        compound.setInteger("counter", counter);
        compound.setInteger("redstonePower2", redstonePower2);
        compound.setInteger("tick", tick);
        this.markDirty();
    }

    // Load the rotation from NBT data when the world is loaded
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        rotation = compound.getFloat("rotation");
        redstonePower = compound.getInteger("redstonePower");
        counterin = compound.getInteger("counterin");
        counter = compound.getInteger("counter");
        redstonePower2 = compound.getInteger("redstonePower2");
        tick = compound.getInteger("tick");

    }
}
