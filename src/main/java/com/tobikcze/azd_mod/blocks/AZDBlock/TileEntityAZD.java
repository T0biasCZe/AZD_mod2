package com.tobikcze.azd_mod.blocks.AZDBlock;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TileEntityAZD extends TileEntity {

    public int redstonePower = 0;
    public int counterin = 0;
    public int counter = -1;
    public int currenttex_dur = 0;
    public int currenttex = 0;
    public int x = 0;
    public int y = 0;
    public int z = 0;
    public ResourceLocation texture = new ResourceLocation("azd", "models/Azd97_0.png");


    @Override
    public void updateEntity() {
        World world = this.worldObj;
        redstonePower = world.getStrongestIndirectPower(this.xCoord, this.yCoord - 2, this.zCoord);
        textureHandle();
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
        compound.setInteger("redstonePower", redstonePower);
        compound.setInteger("counterin", counterin);
        compound.setInteger("counter", counter);
        compound.setInteger("currenttex_dur", currenttex_dur);
        compound.setInteger("currenttex", currenttex);

        this.markDirty();
    }

    // Load the rotation from NBT data when the world is loaded
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        rotation = compound.getInteger("rotation");
        redstonePower = compound.getInteger("redstonePower");
        counterin = compound.getInteger("counterin");
        counter = compound.getInteger("counter");
        currenttex_dur = compound.getInteger("currenttex_dur");
        currenttex = compound.getInteger("currenttex");

    }

    public void textureHandle() {
        currenttex_dur++;
        if (redstonePower > 11) {
            // blinking red
            if (currenttex == 3) {
                if (currenttex_dur > 6f) {
                    currenttex = 2;
                    currenttex_dur = 0;
                }
            } else if (currenttex == 2) {
                if (currenttex_dur > 14f) {
                    playSound();
                    currenttex = 3;
                    currenttex_dur = 0;
                }
            } else {
                currenttex = 2;
            }
        } else if (redstonePower >= 1) {
            // blinking white (AŽD connected)
            if (currenttex_dur > 20) {
                if (currenttex == 0) currenttex = 1;
                else if (currenttex == 1) currenttex = 0;
                else currenttex = 0;
                currenttex_dur = 0;
            }
        } else {
            currenttex = 0;
        }
        texture = new ResourceLocation("azd", "models/Azd97_" + currenttex + ".png");
    }

    public void playSound() {
        try {
            World world = Minecraft.getMinecraft().theWorld;
            // calculate diagonal distance from 0,0,0 to the x,y,z
            double distance = Math.sqrt(x * x + y * y + z * z);
            //System.out.println(distance);
            //System.out.println("x: " + x + " y: " + y + " z: " + z);
            int volume = 150 - (int) (distance * 4);
            world.playSound(x, y, z, "azd:pe_ble", volume, 1, false);
        } catch (Exception e) {
            //System.out.println("Catched exception while playing sound: " + e);
        }
    }
}
