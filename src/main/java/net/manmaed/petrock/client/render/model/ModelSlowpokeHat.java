package net.manmaed.petrock.client.render.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;

/**
 * (MPH) Honeydew.tc2 - TechneToTabulaImporter
 * Created using Tabula 7.0.0
 */
public class ModelSlowpokeHat extends EntityModel {
    public RendererModel Shape1;
    public RendererModel Shape1_1;
    public RendererModel Shape1_2;
    public RendererModel head2;
    public RendererModel Shape1_3;
    public RendererModel Shape1_4;
    public RendererModel Shape1_5;

    public ModelSlowpokeHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Shape1_1 = new RendererModel(this, 32, 1);
        this.Shape1_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1_1.addBox(-1.5F, 10.0F, -1.5F, 2, 4, 3, 0.0F);
        this.setRotateAngle(Shape1_1, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
        this.Shape1_5 = new RendererModel(this, 0, 0);
        this.Shape1_5.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1_5.addBox(-4.0F, 2.0F, -3.5F, 8, 8, 8, 0.0F);
        this.Shape1_2 = new RendererModel(this, 32, 8);
        this.Shape1_2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Shape1_2.addBox(-1.0F, 10.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(Shape1_2, -0.017453292519943295F, 1.3962634015954636F, 0.0F);
        this.Shape1_4 = new RendererModel(this, 32, 8);
        this.Shape1_4.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Shape1_4.addBox(-1.0F, 10.0F, -2.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(Shape1_4, 3.141592653589793F, 1.3962634015954636F, 3.141592653589793F);
        this.Shape1 = new RendererModel(this, 0, 16);
        this.Shape1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1.addBox(-1.5F, 10.0F, 1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Shape1, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
        this.head2 = new RendererModel(this, 0, 16);
        this.head2.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.head2.addBox(-4.0F, 2.0F, -3.5F, 8, 8, 8, 0.1F);
        this.Shape1_3 = new RendererModel(this, 0, 16);
        this.Shape1_3.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1_3.addBox(-1.5F, 10.0F, -3.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Shape1_3, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Shape1_1.render(f5);
        this.Shape1_5.render(f5);
        this.Shape1_2.render(f5);
        this.Shape1_4.render(f5);
        this.Shape1.render(f5);
        this.head2.render(f5);
        this.Shape1_3.render(f5);
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
