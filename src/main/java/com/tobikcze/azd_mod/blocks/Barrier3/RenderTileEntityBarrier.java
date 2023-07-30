package com.tobikcze.azd_mod.blocks.Barrier3;

import com.tobikcze.azd_mod.blocks.Barrier3.TileEntityBarrier;
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

    public RenderTileEntityBarrier() {
        System.out.println("veemo");
        texture = new ResourceLocation("azd", "models/Barrier.png");
        objModelLocation = new ResourceLocation("azd", "models/Barrier_3.obj");
        model = AdvancedModelLoader.loadModel(objModelLocation);
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
        TileEntityBarrier te2 = (TileEntityBarrier) te;
        int redstonePower = te2.redstonePower;
        int counterin = te2.counterin;
        int counter = te2.counter;
        int tick = te2.tick;
        float rotation = te2.rotation;
        double[] e = calcRotation(rotation, counterin, counter, redstonePower, tick);
        te2.rotation = (int) e[0];
        te2.tick = (int) e[1];
        te2.counterin = (int) e[2];
        te2.counter = (int) e[3];

        bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5 - 0.01, posY + 0.1, posZ + 0.5 + 0.2);
        GL11.glPushMatrix();
        GL11.glRotatef(rotation, 1F, 0F, 0F);
        model.renderAll();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    int counter = 0;
    public int tick = 0;

    public double[] calcRotation(double rotation, int counterin, int counter, int redstonePower, int tick) {
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
        return new double[]{(double) rotation, (int) tick, (int) counterin, (int) counter};
    }
}
