package com.tobikcze.azd_mod.blocks.Cross3;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RenderTileEntityCross extends TileEntitySpecialRenderer {

    ResourceLocation texture;
    ResourceLocation objModelLocation;
    IModelCustom model;

    public RenderTileEntityCross() {
        texture = new ResourceLocation("azd", "models/AzdCrossSingle.png");
        objModelLocation = new ResourceLocation("azd", "models/Cross.obj");
        model = AdvancedModelLoader.loadModel(objModelLocation);
    }

    float x;
    float y;
    float z;
    int rotation;

    @Override
    public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
        this.x = (float) posX;
        this.y = (float) posY;
        this.z = (float) posZ;

        bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5, posY, posZ + 0.5);
        GL11.glRotatef(270, 0F, 1F, 0F);
        GL11.glPushMatrix();
        model.renderAll();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
