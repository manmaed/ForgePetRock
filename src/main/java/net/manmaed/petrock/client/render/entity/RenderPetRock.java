package net.manmaed.petrock.client.render.entity;


import net.manmaed.petrock.client.render.layers.*;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.libs.Refs;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by manmaed on 30/08/2019.
 */
public class RenderPetRock extends MobRenderer<EntityPetRock, ModelPetRock<EntityPetRock>> {

    public RenderPetRock(EntityRendererManager manager) {
        super(manager, new ModelPetRock(), 0.25F);
        this.addLayer(new BirthdayFeatureRenderer(this));
        this.addLayer(new ChristmasFeatureRenderer(this));
        this.addLayer(new HalloweenFeatureRenderer(this));
        this.addLayer(new SlowpokeFeatureRenderer(this));
        this.addLayer(new CageFeatureRenderer(this));
        this.addLayer(new SignFeatureRenderer(this));
    }

    private static final ResourceLocation skinuntame = new ResourceLocation(Refs.id, "textures/entity/petrock.png");
    private static final ResourceLocation skintame = new ResourceLocation(Refs.id, "textures/entity/petrock_tame.png");
    private static final ResourceLocation skintamesit = new ResourceLocation(Refs.id, "textures/entity/petrocktamesit.png");

    @Override
    public ResourceLocation getEntityTexture(EntityPetRock entityPetRock) {
        if(entityPetRock.isTamed()) {
            if (entityPetRock.isEntitySleeping() ) {
                return skintamesit;
            } else {
                return skintame;
            }
        } else {
            return skinuntame;
        }
    }
}
