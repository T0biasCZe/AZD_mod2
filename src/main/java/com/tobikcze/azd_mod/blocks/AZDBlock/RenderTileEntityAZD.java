package com.tobikcze.azd_mod.blocks.AZDBlock;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class RenderTileEntityAZD extends TileEntitySpecialRenderer {

    ResourceLocation texture;
    ResourceLocation objModelLocation;
    IModelCustom model;

    public RenderTileEntityAZD() {
        texture = new ResourceLocation("azd", "models/Azd97_0.png");
        objModelLocation = new ResourceLocation("azd", "models/Azd97.obj");
        model = AdvancedModelLoader.loadModel(objModelLocation);
    }

    int currenttex = 0;
    double currenttex_dur = 0;
    int redstoneStrength = 0;
    float timeSinceLastTick;
    float x;
    float y;
    float z;
    int counterin = 0;
    int rotation;

    @Override
    public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
        this.x = (float) posX;
        this.y = (float) posY;
        this.z = (float) posZ;
        // System.out.println(timeSinceLastTick);
        this.timeSinceLastTick = timeSinceLastTick;
        textureHandle();
        TileEntityAZD te2 = (TileEntityAZD) te;
        redstoneStrength = te2.redstonePower;
        counterin = te2.counter;
        rotation = te2.rotation;

        bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5, posY, posZ + 0.5);
        GL11.glRotatef(rotation, 0F, 1F, 0F);
        GL11.glPushMatrix();
        model.renderAll();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    int counter = 0;

    public void textureHandle() {
        if (counterin != counter) {
            counter = counterin;
            currenttex_dur++;
        }
        if (redstoneStrength > 11) {
            // blinking red
            if (currenttex == 3) {
                if (currenttex_dur > 6f) {
                    currenttex = 2;
                    // currenttex_dur = currenttex_dur - 6.666f;
                    currenttex_dur = 0;
                }
            } else if (currenttex == 2) {
                if (currenttex_dur > 14f) {
                    playSound();
                    currenttex = 3;
                    // currenttex_dur = currenttex_dur - 17.083f;
                    currenttex_dur = 0;
                }
            } else {
                currenttex = 2;
            }
        } else if (redstoneStrength >= 1) {
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
        World world = Minecraft.getMinecraft().theWorld;
        // calculate diagonal distance from 0,0,0 to the x,y,z
        double distance = Math.sqrt(x * x + y * y + z * z);
        System.out.println(distance);
        int volume = 150 - (int) (distance * 5);
        world.playSound(x, y, z, "azd:pe_ble", volume, 1, false);
    }
}
