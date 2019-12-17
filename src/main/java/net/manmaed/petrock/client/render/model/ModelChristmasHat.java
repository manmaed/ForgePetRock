package net.manmaed.petrock.client.render.model;

/**
 * Created by manmaed on 26/02/2017.
 */

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;

/**
 * PetRock - manmaed
 * Created using Tabula 5.1.0
 */
public class ModelChristmasHat extends EntityModel {
    public RendererModel ballball;
    public RendererModel hatp1;
    public RendererModel hatp2;
    public RendererModel hatp3;
    public RendererModel hatp4;
    public RendererModel hatp5;
    public RendererModel HatBottem;

    public ModelChristmasHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.HatBottem = new RendererModel(this, 0, 7);
        this.HatBottem.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.HatBottem.addBox(-3.0F, 0.0F, -3.0F, 6, 1, 6, 0.0F);
        this.ballball = new RendererModel(this, 0, 15);
        this.ballball.setRotationPoint(0.0F, 21.2F, 2.6F);
        this.ballball.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(ballball, 1.1838568316277536F, 0.0F, 0.0F);
        this.hatp1 = new RendererModel(this, 0, 0);
        this.hatp1.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.hatp1.addBox(-2.5F, 0.0F, -2.5F, 5, 1, 5, 0.0F);
        this.hatp2 = new RendererModel(this, 0, 0);
        this.hatp2.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.hatp2.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
        this.hatp3 = new RendererModel(this, 0, 0);
        this.hatp3.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.hatp3.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.hatp4 = new RendererModel(this, 0, 0);
        this.hatp4.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.hatp4.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.hatp5 = new RendererModel(this, 0, 0);
        this.hatp5.setRotationPoint(0.0F, 19.5F, 0.0F);
        this.hatp5.addBox(-1.0F, 0.0F, -0.1F, 2, 2, 1, 0.0F);
        this.setRotateAngle(hatp5, 1.1838568316277536F, 0.0F, 0.0F);

    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

        HatBottem.render(f5);
        ballball.render(f5);
        hatp1.render(f5);
        hatp2.render(f5);
        hatp3.render(f5);
        hatp4.render(f5);
        hatp5.render(f5);
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