package net.manmaed.petrock.entitys;

import net.manmaed.petrock.libs.Refs;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.ObjectHolder;

/**
 * Created by manmaed on 26/11/2019.
 */
public class PREntitys
{

    @ObjectHolder(Refs.Register + "petrock")
    public static EntityType<EntityPetRock> petrock;


    public static void load()
    {
        /**
         * Register the mod entity type with FML
         * This will also register a spawn egg.

         * @param texture Main Texture?
         * @param entityClass The entity class
         * @param entityName A unique name for the entity
         * @param id A mod specific ID for the entity
         * @param eggPrimary Primary egg color BackGround
         * @param eggSecondary Secondary egg color Dots
         */

        EntityType.Builder.create(EntityPetRock:: new, EntityClassification.MISC).size(0.5f, 0.5f).build("petrock").setRegistryName("petrock");

        /*EntityRegisterUtil.registerEntity(new ResourceLocation(Refs.id, "petrock"), EntityPetRock.class, "PetRock", id++, 0xdcd5d5, 0x686565);*/
        //REQUEST: Add Evil Petrock LOL
        //EntityRegisterUtil.registerEntity(ResourceLocationHelper.getResourceLocation("petrock"), EntityEvilRock.class, "EvilRock", id++, 0xdcd5d5, 0x686565);
    }

}
