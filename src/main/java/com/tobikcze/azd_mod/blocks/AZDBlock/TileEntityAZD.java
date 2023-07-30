package com.tobikcze.azd_mod.blocks.AZDBlock;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityAZD extends TileEntity {

    public int redstonePower = 0;
    public int counter = 0;

    @Override
    public void updateEntity() {
        counter++;
        World world = this.worldObj;
        redstonePower = world.getStrongestIndirectPower(this.xCoord, this.yCoord - 2, this.zCoord);
    }

    public int rotation;

    public void setRotation(int rotation) {
        this.rotation = rotation;
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
        compound.setInteger("rotation", rotation);
        this.markDirty();
    }

    // Load the rotation from NBT data when the world is loaded
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        rotation = compound.getInteger("rotation");
    }
}
