package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.manmaed.petrock.client.render.model.ModelChristmasHat;
import net.manmaed.petrock.client.render.model.ModelPetRockHat;
import net.manmaed.petrock.hats.HatData;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.hats.PRHats2;
import net.manmaed.petrock.libs.LogHelper;
import net.manmaed.petrock.libs.Refs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class PetRockFeatureRenderer extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {

    private final ModelPetRockHat hat = new ModelPetRockHat();
    private static final ResourceLocation skin = new ResourceLocation(Refs.id, "textures/entity/petrocktamesit.png");
    public PetRockFeatureRenderer(IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, AbstractClientPlayerEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        int packedOverlayIn = LivingRenderer.getOverlay(entitylivingbaseIn, 0.0F);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(skin));
        LogHelper.info("PlayerUUID: " + Minecraft.getInstance().getSession().getPlayerID().replace("-","") + " - " + PRHats2.uuid);
        if(Minecraft.getInstance().getSession().getPlayerID().replace("-","").equals(PRHats2.uuid)) {
            hat.render(matrixStackIn, ivertexbuilder, packedLightIn, packedOverlayIn);
        }
    }
}
