package net.manmaed.petrock.client.render.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * (MPH) Honeydew.tc2 - TechneToTabulaImporter
 * Created using Tabula 7.0.0
 */
public class ModelSlowpokeHat<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer Shape1;
    public ModelRenderer Shape1_1;
    public ModelRenderer Shape1_2;
    public ModelRenderer head2;
    public ModelRenderer Shape1_3;
    public ModelRenderer Shape1_4;
    public ModelRenderer Shape1_5;

    public ModelSlowpokeHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Shape1_1 = new ModelRenderer(this, 32, 1);
        this.Shape1_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1_1.addBox(-1.5F, 10.0F, -1.5F, 2, 4, 3, 0.0F);
        this.setRotateAngle(Shape1_1, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
        this.Shape1_5 = new ModelRenderer(this, 0, 0);
        this.Shape1_5.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1_5.addBox(-4.0F, 2.0F, -3.5F, 8, 8, 8, 0.0F);
        this.Shape1_2 = new ModelRenderer(this, 32, 8);
        this.Shape1_2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Shape1_2.addBox(-1.0F, 10.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(Shape1_2, -0.017453292519943295F, 1.3962634015954636F, 0.0F);
        this.Shape1_4 = new ModelRenderer(this, 32, 8);
        this.Shape1_4.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Shape1_4.addBox(-1.0F, 10.0F, -2.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(Shape1_4, 3.141592653589793F, 1.3962634015954636F, 3.141592653589793F);
        this.Shape1 = new ModelRenderer(this, 0, 16);
        this.Shape1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1.addBox(-1.5F, 10.0F, 1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Shape1, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
        this.head2 = new ModelRenderer(this, 0, 16);
        this.head2.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.head2.addBox(-4.0F, 2.0F, -3.5F, 8, 8, 8, 0.1F);
        this.Shape1_3 = new ModelRenderer(this, 0, 16);
        this.Shape1_3.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1_3.addBox(-1.5F, 10.0F, -3.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Shape1_3, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(
                this.Shape1_1,
                this.Shape1_5,
                this.Shape1_2,
                this.Shape1_4,
                this.Shape1,
                this.head2,
                this.Shape1_3
        );
    }

    public void renderSlowpoke(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn) {
        this.Shape1_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Shape1_5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Shape1_2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Shape1_4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Shape1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.head2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Shape1_3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX  = x;
        model.rotateAngleY  = y;
        model.rotateAngleZ  = z;
    }
}
