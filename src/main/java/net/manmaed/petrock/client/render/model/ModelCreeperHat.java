package net.manmaed.petrock.client.render.model;


import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * PetRock - manmaed
 * Created using Tabula 7.0.0
 */
public class ModelCreeperHat<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer foot1F;
    public ModelRenderer foot2F;
    public ModelRenderer foot1B;
    public ModelRenderer foot2B;
    public ModelRenderer CreepsHead;
    public ModelRenderer CreepsBody;

    public ModelCreeperHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.foot2F = new ModelRenderer(this, 0, 20);
        this.foot2F.setRotationPoint(1.5F, 24.0F, -1.0F);
        this.foot2F.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.foot1B = new ModelRenderer(this, 0, 20);
        this.foot1B.setRotationPoint(-1.5F, 24.0F, 1.5F);
        this.foot1B.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.foot2B = new ModelRenderer(this, 0, 20);
        this.foot2B.setRotationPoint(1.5F, 24.0F, 1.5F);
        this.foot2B.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.CreepsHead = new ModelRenderer(this, 0, 0);
        this.CreepsHead.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.CreepsHead.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
        this.foot1F = new ModelRenderer(this, 0, 20);
        this.foot1F.setRotationPoint(-1.5F, 24.0F, -1.0F);
        this.foot1F.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.CreepsBody = new ModelRenderer(this, 0, 13);
        this.CreepsBody.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.CreepsBody.addBox(-1.5F, -4.0F, -1.0F, 3, 4, 2, 0.0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(
                this.foot2F,
                this.foot1B,
                this.foot2B,
                this.CreepsHead,
                this.foot1F,
                this.CreepsBody
        );
    }

    public void renderCreeper(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn) {
        this.foot2F.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.foot1B.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.foot2B.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.CreepsHead.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.foot1F.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.CreepsBody.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
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
