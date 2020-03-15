package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.manmaed.petrock.client.render.model.ModelSign;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.libs.Refs;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

/**
 * Created by manmaed on 30/08/2019.
 */
public class SignFeatureRenderer extends LayerRenderer<EntityPetRock, ModelPetRock<EntityPetRock>> {

    private final ModelSign hat = new ModelSign();
    private static final ResourceLocation skin = new ResourceLocation(Refs.id, "textures/entity/event/sign.png");

    public SignFeatureRenderer(IEntityRenderer entityRendererIn) {
        super(entityRendererIn);
    }


    private float interpolateValues(float prevVal, float nextVal, float partialTick) {
        return prevVal + partialTick * (nextVal - prevVal);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityPetRock entityPetRock, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (PRHats.loneztar) {
            GlStateManager.pushMatrix();
            GlStateManager.translatef(0F, -0.5626F, 0F);
            float pitch = interpolateValues(entityPetRock.prevRotationPitch, entityPetRock.rotationPitch, partialTicks);
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(skin));
            hat.renderSign(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY);
            //GlStateManager.rotate(pitch, 1.0F, 0.0F, 0.0F);
            GlStateManager.popMatrix();
        }
    }
}
