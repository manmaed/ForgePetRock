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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * PetRock - manmaed
 * Created using Tabula 5.1.0
 */

@OnlyIn(Dist.CLIENT)
public class ModelPetRockHat<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer shape1;

    public ModelPetRockHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.shape1.addBox(-4.5F, -9.0F, -4.5F, 9, 9, 9, 0.0F);

    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(shape1);
    }


    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX  = x;
        model.rotateAngleY  = y;
        model.rotateAngleZ  = z;
    }

    public void render(MatrixStack matrixStackIn, IVertexBuilder ivertexbuilder, int packedLightIn, int packedOverlayIn) {
        this.shape1.render(matrixStackIn, ivertexbuilder, packedLightIn, packedOverlayIn);
    }
}