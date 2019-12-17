package net.manmaed.petrock.client.render.model;


import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;

/**
 * PetRock - manmaed
 * Created using Tabula 7.0.0
 */
public class ModelCreeperHat extends EntityModel {
    public RendererModel foot1F;
    public RendererModel foot2F;
    public RendererModel foot1B;
    public RendererModel foot2B;
    public RendererModel CreepsHead;
    public RendererModel CreepsBody;

    public ModelCreeperHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.foot2F = new RendererModel(this, 0, 20);
        this.foot2F.setRotationPoint(1.5F, 24.0F, -1.0F);
        this.foot2F.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.foot1B = new RendererModel(this, 0, 20);
        this.foot1B.setRotationPoint(-1.5F, 24.0F, 1.5F);
        this.foot1B.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.foot2B = new RendererModel(this, 0, 20);
        this.foot2B.setRotationPoint(1.5F, 24.0F, 1.5F);
        this.foot2B.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.CreepsHead = new RendererModel(this, 0, 0);
        this.CreepsHead.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.CreepsHead.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
        this.foot1F = new RendererModel(this, 0, 20);
        this.foot1F.setRotationPoint(-1.5F, 24.0F, -1.0F);
        this.foot1F.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.CreepsBody = new RendererModel(this, 0, 13);
        this.CreepsBody.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.CreepsBody.addBox(-1.5F, -4.0F, -1.0F, 3, 4, 2, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.foot2F.render(f5);
        this.foot1B.render(f5);
        this.foot2B.render(f5);
        this.CreepsHead.render(f5);
        this.foot1F.render(f5);
        this.CreepsBody.render(f5);
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
