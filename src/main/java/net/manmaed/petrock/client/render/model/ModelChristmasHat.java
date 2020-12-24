package net.manmaed.petrock.client.render.model;

/**
 * Created by manmaed on 26/02/2017.
 */

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * PetRock - manmaed
 * Created using Tabula 5.1.0
 */
public class ModelChristmasHat<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer ballball;
    public ModelRenderer hatp1;
    public ModelRenderer hatp2;
    public ModelRenderer hatp3;
    public ModelRenderer hatp4;
    public ModelRenderer hatp5;
    public ModelRenderer HatBottem;

    public ModelChristmasHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.HatBottem = new ModelRenderer(this, 0, 7);
        this.HatBottem.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.HatBottem.addBox(-3.0F, 0.0F, -3.0F, 6, 1, 6, 0.0F);
        this.ballball = new ModelRenderer(this, 0, 15);
        this.ballball.setRotationPoint(0.0F, 21.2F, 2.6F);
        this.ballball.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(ballball, 1.1838568316277536F, 0.0F, 0.0F);
        this.hatp1 = new ModelRenderer(this, 0, 0);
        this.hatp1.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.hatp1.addBox(-2.5F, 0.0F, -2.5F, 5, 1, 5, 0.0F);
        this.hatp2 = new ModelRenderer(this, 0, 0);
        this.hatp2.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.hatp2.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
        this.hatp3 = new ModelRenderer(this, 0, 0);
        this.hatp3.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.hatp3.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.hatp4 = new ModelRenderer(this, 0, 0);
        this.hatp4.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.hatp4.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.hatp5 = new ModelRenderer(this, 0, 0);
        this.hatp5.setRotationPoint(0.0F, 19.5F, 0.0F);
        this.hatp5.addBox(-1.0F, 0.0F, -0.1F, 2, 2, 1, 0.0F);
        this.setRotateAngle(hatp5, 1.1838568316277536F, 0.0F, 0.0F);

    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(
                this.HatBottem,
                this.ballball,
                this.hatp1,
                this.hatp2,
                this.hatp3,
                this.hatp4,
                this.hatp5
        );
    }

    public void renderSanta(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn) {
        this.HatBottem.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.ballball.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.hatp1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.hatp2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.hatp3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.hatp4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.hatp5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    /*public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

        HatBottem,
        ballball,
        hatp1,
        hatp2,
        hatp3,
        hatp4,
        hatp5,
    }*/

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX  = x;
        model.rotateAngleY  = y;
        model.rotateAngleZ  = z;
    }
}