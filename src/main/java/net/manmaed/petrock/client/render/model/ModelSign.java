package net.manmaed.petrock.client.render.model;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;

/**
 * Created by manmaed on 07/12/2019.
 */
public class ModelSign extends EntityModel {
    public RendererModel sign;

    public ModelSign() {
        textureWidth = 128;
        this.textureHeight = 128;
        this.sign = new RendererModel(this, 0, 0);
        this.sign.setRotationPoint(-3.0F, 12.2F, 1.0F);
        this.sign.addBox(0.0F, 0.0F, 0.0F, 64, 39, 1, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        GlStateManager.scaled(0.175D, 0.175D, 0.175D);
        GlStateManager.translatef(-1.8F, 7.5F,-2.6F);

        /*GlStateManager.translatef(this.sign.offsetX, this.sign.offsetY, this.sign.offsetZ);
        //GlStateManager.translatef(this.sign.rotationPointX * f5, this.sign.rotationPointY * f5, this.sign.rotationPointZ * f5);
        GlStateManager.scaled(0.5D, 0.5D, 0.5D);
        //GlStateManager.translatef(-this.sign.offsetX, -this.sign.offsetY, -this.sign.offsetZ);
        //GlStateManager.translatef(-this.sign.rotationPointX * f5, -this.sign.rotationPointY * f5, -this.sign.rotationPointZ * f5);*/
        this.sign.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel model, float x, float y, float z) {
        model.rotateAngleX  = x;
        model.rotateAngleY  = y;
        model.rotateAngleZ  = z;
    }
}
