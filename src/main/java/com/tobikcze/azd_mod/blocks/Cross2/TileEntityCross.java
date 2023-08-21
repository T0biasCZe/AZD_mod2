package com.tobikcze.azd_mod.blocks.Cross2;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCross extends TileEntity {

    public int rotation = 0;

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        nbtTagCompound.setInteger("rotation", rotation);
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
        try{
        compound.setInteger("rotation", rotation);
        super.writeToNBT(compound);
        this.markDirty();} catch (Exception e) {
            System.out.println("Error while saving tile entity");
        }
    }

    // Load the rotation from NBT data when the world is loaded
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        try {
            super.readFromNBT(compound);
            rotation = compound.getInteger("rotation");
        } catch(Exception e) {
            System.out.println("Error while loading tile entity");
        }
    }
}
