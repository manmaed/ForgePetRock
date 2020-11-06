package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.PetRockClient;
import net.manmaed.petrock.client.render.model.ModelPetRockHat;
import net.manmaed.petrock.hats.PRPHats;
import net.manmaed.petrock.hats.PlayerHatData;
import net.manmaed.petrock.libs.Refs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class PetRockFeatureRenderer extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {

    private final ModelPetRockHat hat = new ModelPetRockHat();
    private static final ResourceLocation skin = new ResourceLocation(Refs.id, "textures/entity/petrocktamesit.png");


    public PetRockFeatureRenderer(IEntityRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, AbstractClientPlayerEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entity.isInvisible())  {
            if (PetRockClient.HATS.doesPlayerHaveHat(entity.getUniqueID())) {
                IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(skin));
                matrixStackIn.push();
                getEntityModel().bipedHead.rotate(matrixStackIn);
                float size = 0.5F;
                matrixStackIn.translate(0.0F, -1.25F, 0.0F);
                matrixStackIn.scale(size, size, size);
                hat.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.DEFAULT_UV);
                matrixStackIn.pop();
            }
        }
    }
}
