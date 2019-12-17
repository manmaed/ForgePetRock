package net.manmaed.petrock.client.render.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;

/**
 * ModelPetRock - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelCakeHat extends EntityModel {
    public RendererModel cake;

    public ModelCakeHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.cake = new RendererModel(this, 0, 0);
        this.cake.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.cake.addBox(-4.0F, -3.0F, -4.0F, 8, 3, 8, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.cake.render(f5);
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
