package net.manmaed.petrock.client.render.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by manmaed on 29/11/2019.
 */
public class ModelCageHat<T extends Entity> extends SegmentedModel<T> {

    private ModelRenderer FB1;
    private ModelRenderer FB2;
    private ModelRenderer FB3;
    private ModelRenderer FB4;
    private ModelRenderer RB1;
    private ModelRenderer RB2;
    private ModelRenderer RB3;
    private ModelRenderer RB4;
    private ModelRenderer RiB2;
    private ModelRenderer RiB3;
    private ModelRenderer LeB3;
    private ModelRenderer TB1;
    private ModelRenderer TB2;
    private ModelRenderer nib1;
    private ModelRenderer nib2;
    private ModelRenderer nib3;
    private ModelRenderer nib4;
    private ModelRenderer nib5;
    private ModelRenderer nib6;
    private ModelRenderer nib7;
    private ModelRenderer nib8;
    private ModelRenderer nib9;
    private ModelRenderer nib10;
    private ModelRenderer nib11;
    private ModelRenderer nib12;
    private ModelRenderer snib6;
    private ModelRenderer snib1;
    private ModelRenderer LeB2;
    private ModelRenderer snib3;
    private ModelRenderer snib4;
    private ModelRenderer snib5;
    private ModelRenderer snib2;

    public ModelCageHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.nib6 = new ModelRenderer(this, 0, 17);
        this.nib6.setRotationPoint(0.0F, 23.0F, -3.0F);
        this.nib6.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.LeB2 = new ModelRenderer(this, 0, 0);
        this.LeB2.setRotationPoint(-6.0F, 33.1F, -2.0F);
        this.LeB2.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.nib1 = new ModelRenderer(this, 0, 17);
        this.nib1.setRotationPoint(-4.0F, 23.0F, -7.0F);
        this.nib1.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.FB4 = new ModelRenderer(this, 0, 0);
        this.FB4.setRotationPoint(6.0F, 33.0F, -6.0F);
        this.FB4.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.LeB3 = new ModelRenderer(this, 0, 0);
        this.LeB3.setRotationPoint(-6.0F, 33.1F, 2.0F);
        this.LeB3.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.nib7 = new ModelRenderer(this, 0, 17);
        this.nib7.setRotationPoint(0.0F, 23.0F, 1.0F);
        this.nib7.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.RB4 = new ModelRenderer(this, 0, 0);
        this.RB4.setRotationPoint(6.0F, 33.0F, 6.0F);
        this.RB4.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.snib6 = new ModelRenderer(this, 0, 17);
        this.snib6.setRotationPoint(6.0F, 23.0F, 3.0F);
        this.snib6.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.RiB2 = new ModelRenderer(this, 0, 0);
        this.RiB2.setRotationPoint(6.0F, 33.0F, -2.0F);
        this.RiB2.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.snib1 = new ModelRenderer(this, 0, 17);
        this.snib1.setRotationPoint(-6.0F, 23.0F, -5.0F);
        this.snib1.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.snib2 = new ModelRenderer(this, 0, 17);
        this.snib2.setRotationPoint(-6.0F, 23.0F, -1.0F);
        this.snib2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.nib10 = new ModelRenderer(this, 0, 17);
        this.nib10.setRotationPoint(4.0F, 23.0F, -3.0F);
        this.nib10.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.RB3 = new ModelRenderer(this, 0, 0);
        this.RB3.setRotationPoint(2.0F, 33.0F, 6.0F);
        this.RB3.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.nib9 = new ModelRenderer(this, 0, 17);
        this.nib9.setRotationPoint(4.0F, 23.0F, -7.0F);
        this.nib9.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.RiB3 = new ModelRenderer(this, 0, 0);
        this.RiB3.setRotationPoint(6.0F, 33.0F, 2.0F);
        this.RiB3.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.nib2 = new ModelRenderer(this, 0, 17);
        this.nib2.setRotationPoint(-4.0F, 23.0F, -3.0F);
        this.nib2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.snib3 = new ModelRenderer(this, 0, 17);
        this.snib3.setRotationPoint(-6.0F, 23.0F, 3.0F);
        this.snib3.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.FB3 = new ModelRenderer(this, 0, 0);
        this.FB3.setRotationPoint(2.0F, 33.0F, -6.0F);
        this.FB3.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.nib12 = new ModelRenderer(this, 0, 17);
        this.nib12.setRotationPoint(4.0F, 23.0F, 5.0F);
        this.nib12.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.snib4 = new ModelRenderer(this, 0, 17);
        this.snib4.setRotationPoint(6.0F, 23.0F, -5.0F);
        this.snib4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.TB1 = new ModelRenderer(this, 0, 4);
        this.TB1.setRotationPoint(-2.0F, 23.0F, 0.0F);
        this.TB1.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 10, 0.0F);
        this.nib11 = new ModelRenderer(this, 0, 17);
        this.nib11.setRotationPoint(4.0F, 23.0F, 1.0F);
        this.nib11.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.FB1 = new ModelRenderer(this, 0, 0);
        this.FB1.setRotationPoint(-6.0F, 33.0F, -6.0F);
        this.FB1.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.RB2 = new ModelRenderer(this, 0, 0);
        this.RB2.setRotationPoint(-2.0F, 33.0F, 6.0F);
        this.RB2.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.nib5 = new ModelRenderer(this, 0, 17);
        this.nib5.setRotationPoint(0.0F, 23.0F, -7.0F);
        this.nib5.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.snib5 = new ModelRenderer(this, 0, 17);
        this.snib5.setRotationPoint(6.0F, 23.0F, -1.0F);
        this.snib5.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.nib3 = new ModelRenderer(this, 0, 17);
        this.nib3.setRotationPoint(-4.0F, 23.0F, 1.0F);
        this.nib3.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.RB1 = new ModelRenderer(this, 0, 0);
        this.RB1.setRotationPoint(-6.0F, 33.0F, 6.0F);
        this.RB1.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.FB2 = new ModelRenderer(this, 0, 0);
        this.FB2.setRotationPoint(-2.0F, 33.0F, -6.0F);
        this.FB2.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F);
        this.TB2 = new ModelRenderer(this, 0, 4);
        this.TB2.setRotationPoint(2.0F, 23.0F, 0.0F);
        this.TB2.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 10, 0.0F);
        this.nib4 = new ModelRenderer(this, 0, 17);
        this.nib4.setRotationPoint(-4.0F, 23.0F, 5.0F);
        this.nib4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.nib8 = new ModelRenderer(this, 0, 17);
        this.nib8.setRotationPoint(0.0F, 23.0F, 5.0F);
        this.nib8.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(
                this.LeB2,
                this.nib1,
                this.FB4,
                this.LeB3,
                this.nib7,
                this.RB4,
                this.snib6,
                this.RiB2,
                this.snib1,
                this.snib2,
                this.nib10,
                this.RB3,
                this.nib9,
                this.RiB3,
                this.nib2,
                this.snib3,
                this.FB3,
                this.nib12,
                this.snib4,
                this.TB1,
                this.nib11,
                this.FB1,
                this.RB2,
                this.nib5,
                this.snib5,
                this.nib3,
                this.RB1,
                this.FB2,
                this.TB2,
                this.nib4,
                this.nib8
        );
    }
    public void renderCage(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn) {
        this.LeB2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.LeB2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FB4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.LeB3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib7.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.RB4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.snib6.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.RiB2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.snib1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.snib2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib10.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.RB3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib9.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.RiB3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.snib3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FB3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib12.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.snib4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.TB1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib11.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FB1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.RB2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.snib5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.RB1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FB2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.TB2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.nib8.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
