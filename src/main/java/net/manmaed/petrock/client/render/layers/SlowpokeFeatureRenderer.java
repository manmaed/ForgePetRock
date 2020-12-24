package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.manmaed.petrock.client.render.model.ModelSlowpokeHat;
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
 * Created by manmaed on 31/08/2019.
 */
public class SlowpokeFeatureRenderer extends LayerRenderer<EntityPetRock, ModelPetRock<EntityPetRock>> {

    private final ModelSlowpokeHat hat = new ModelSlowpokeHat();
    private static final ResourceLocation skin = new ResourceLocation(Refs.id, "textures/entity/event/slowpoke.png");

    public SlowpokeFeatureRenderer(IEntityRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    /*@Override
    public void render(EntityPetRock entityPetRock, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (PRHats.slowpoke) {
            GlStateManager.pushMatrix();
            bindTexture(skin);
            if(PRHats.birthday) {
                GlStateManager.translatef(0F, -0.19F, 0F);
            } else {
                GlStateManager.translatef(0F, -0.005F, 0F);
            }
            float pitch = interpolateValues(entityPetRock.prevRotationPitch, entityPetRock.rotationPitch, partialTicks);
            hat.render(entityPetRock, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            //GlStateManager.rotate(pitch, 1.0F, 0.0F, 0.0F);
            GlStateManager.popMatrix();
        }
    }*/

    private float interpolateValues(float prevVal, float nextVal, float partialTick) {
        return prevVal + partialTick * (nextVal - prevVal);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityPetRock entityPetRock, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (PRHats.slowpoke) {
            matrixStackIn.push();
            if(PRHats.birthday) {
                matrixStackIn.translate(0F, -0.19F, 0F);
            } else {
                matrixStackIn.translate(0F, -0.005F, 0F);
            }
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityCutout(skin));
            hat.renderSlowpoke(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.pop();
        }
    }
}
