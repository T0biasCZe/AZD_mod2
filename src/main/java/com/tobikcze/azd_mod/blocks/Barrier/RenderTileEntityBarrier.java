package com.tobikcze.azd_mod.blocks.Barrier;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class RenderTileEntityBarrier extends TileEntitySpecialRenderer {

    ResourceLocation texture;
    ResourceLocation objModelLocation;
    IModelCustom model;
    int firstload = 0;

    public RenderTileEntityBarrier() {
        firstload = 0;
        System.out.println("veemo");
        texture = new ResourceLocation("azd", "models/Barrier.png");
        objModelLocation = new ResourceLocation("azd", "models/Barrier_0.obj");
        model = AdvancedModelLoader.loadModel(objModelLocation);
    }

    public int redstonePower;
    float timeSinceLastTick;
    float rotation = 0;
    int counterin = 0;

    @Override
    public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
        TileEntityBarrier te2 = (TileEntityBarrier) te;
        this.timeSinceLastTick = timeSinceLastTick;
        redstonePower = te2.redstonePower;
        counterin = te2.counter;
        int rotation2 = te2.rotation2;
        float scale = te2.scale;
        calcRotation();

        bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5 - 0.2, posY + 0.1, posZ + 0.5);
        GL11.glScalef(scale, scale, scale);
        GL11.glPushMatrix();
        GL11.glRotatef(rotation, 0F, 0F, 1F);
        model.renderAll();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    int counter = 0;
    public int tick = 0;

    public void calcRotation() {
        if (counterin != counter) {
            counter = counterin;
            tick = 1;
        } else tick = 0;
        if (redstonePower > 14) {
            if (rotation < 90) {
                rotation += 2 * tick;
            }
        } else {
            if (rotation > 0) {
                rotation -= 2 * tick;
            }
        }
    }
}
