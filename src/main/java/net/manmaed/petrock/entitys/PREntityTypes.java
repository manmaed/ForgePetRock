package net.manmaed.petrock.entitys;

import net.manmaed.petrock.libs.Refs;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PREntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Refs.id);

    //Entity Types
    /*@ObjectHolder(Refs.Register + "petrock")*/
    /*public static EntityType<EntityPetRock> PETROCK;*/

    public static final RegistryObject<EntityType<EntityPetRock>> PETROCK = ENTITY_TYPES.register("petrock",
            () -> EntityType.Builder.create(EntityPetRock:: new, EntityClassification.MISC)
                    .size(0.5f, 0.5f)
                    .build("petrock")
    );

}
