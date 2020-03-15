package net.manmaed.petrock.client.render.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPetRock - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelCakeHat<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer cake;

    public ModelCakeHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.cake = new ModelRenderer(this, 0, 0);
        this.cake.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.cake.addBox(-4.0F, -3.0F, -4.0F, 8, 3, 8, 0.0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(
                this.cake
        );
    }

    public void renderCake(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn) {
        this.cake.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
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
