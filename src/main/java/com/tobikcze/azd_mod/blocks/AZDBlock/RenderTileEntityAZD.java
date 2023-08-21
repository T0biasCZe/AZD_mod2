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

    ResourceLocation objModelLocation;
    IModelCustom model;
    ResourceLocation texture;

    public RenderTileEntityAZD() {
        objModelLocation = new ResourceLocation("azd", "models/Azd97.obj");
        texture = new ResourceLocation("azd", "models/Azd97_0.png");
        model = AdvancedModelLoader.loadModel(objModelLocation);
    }
    @Override
    public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
        TileEntityAZD te2 = (TileEntityAZD) te;
        te2.x = (int) posX;
        te2.y = (int) posY;
        te2.z = (int) posZ;

        texture = te2.texture;

        bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5, posY, posZ + 0.5);
        GL11.glRotatef(0, 0F, 1F, 0F);
        GL11.glPushMatrix();
        model.renderAll();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
