package com.tobikcze.azd_mod.blocks.AZDBlock;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
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

    boolean init = true;
    @Override
    public void updateEntity() {
        World world = this.worldObj;
        redstonePower = world.getStrongestIndirectPower(this.xCoord, this.yCoord - 2, this.zCoord);
        if(world.isRemote) textureHandle();

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
            //System.out.println("x: " + xCoord + " y: " + yCoord + " z: " + zCoord);
            //get player position
            double px = Minecraft.getMinecraft().thePlayer.posX;
            double py = Minecraft.getMinecraft().thePlayer.posY;
            double pz = Minecraft.getMinecraft().thePlayer.posZ;
            double distance = Math.sqrt(Math.pow(px - xCoord, 2) + Math.pow(py - yCoord, 2) + Math.pow(pz - zCoord, 2));

            if(distance > 50) return;
            String sound;
            if(distance < 5) sound = "azd:pe_ble";
            else if(distance < 10) sound = "azd:pe_ble75";
            else if(distance < 15) sound = "azd:pe_ble50";
            else if(distance < 25) sound = "azd:pe_ble25";
            else if(distance < 35) sound = "azd:pe_ble12";
            else sound = "azd:pe_ble5";
            world.playSound(x, y, z, sound, 1000, 1, false);
        } catch (Exception e) {
            //System.out.println("Catched exception while playing sound: " + e);
        }
    }
}
