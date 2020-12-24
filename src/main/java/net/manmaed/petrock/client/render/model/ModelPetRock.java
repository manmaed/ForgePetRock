package net.manmaed.petrock.client.render.model;

/**
 * Created by manmaed on 26/02/2017.
 */

import com.google.common.collect.ImmutableList;
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
public class ModelPetRock<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer shape1;
   /* public Cuboid HatBottem;
    public Cuboid hatp1;
    public Cuboid hatp2;
    public Cuboid hatp3;
    public Cuboid hatp4;
    public Cuboid hatp5;
    public Cuboid ballball;
    public Cuboid cake;
    public Cuboid foot1F;
    public Cuboid foot2F;
    public Cuboid CreepsBody;
    public Cuboid foot1B;
    public Cuboid foot2B;
    public Cuboid CreepsHead;
*/
    public ModelPetRock() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.shape1.addBox(-4.5F, -9.0F, -4.5F, 9, 9, 9, 0.0F);

        /*//christmas Hat
        this.hatp2 = new Cuboid(this, 0, 27);
        this.hatp2.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.hatp2.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
        this.hatp3 = new Cuboid(this, 0, 28);
        this.hatp3.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.hatp3.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.hatp4 = new Cuboid(this, 0, 29);
        this.hatp4.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.hatp4.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.hatp1 = new Cuboid(this, 0, 26);
        this.hatp1.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.hatp1.addBox(-2.5F, 0.0F, -2.5F, 5, 1, 5, 0.0F);
        this.hatp5 = new Cuboid(this, 0, 29);
        this.hatp5.setRotationPoint(0.0F, 10.5F, 0.0F);
        this.hatp5.addBox(-1.0F, 0.0F, -0.1F, 2, 2, 1, 0.0F);
        this.setRotateAngle(hatp5, 1.1838568316277536F, 0.0F, 0.0F);
        this.HatBottem = new Cuboid(this, 0, 19);
        this.HatBottem.setRotationPoint(0.0F, 14.0F, 0.0F);
        this.HatBottem.addBox(-3.0F, 0.0F, -3.0F, 6, 1, 6, 0.0F);
        this.ballball = new Cuboid(this, 19, 19);
        this.ballball.setRotationPoint(0.0F, 12.2F, 2.6F);
        this.ballball.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(ballball, 1.1838568316277536F, 0.0F, 0.0F);

        //Birthday Cake
        this.cake = new Cuboid(this, 21, 21);
        this.cake.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.cake.addBox(-4.0F, -3.0F, -4.0F, 8, 3, 8, 0.0F);

        //Creeper
        this.foot2B = new Cuboid(this, 38, 0);
        this.foot2B.setRotationPoint(1.5F, 15.0F, 1.5F);
        this.foot2B.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.foot1F = new Cuboid(this, 38, 0);
        this.foot1F.setRotationPoint(-1.5F, 15.0F, -1.0F);
        this.foot1F.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.foot2F = new Cuboid(this, 38, 0);
        this.foot2F.setRotationPoint(1.5F, 15.0F, -1.0F);
        this.foot2F.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.CreepsHead = new Cuboid(this, 38, 7);
        this.CreepsHead.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.CreepsHead.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
        this.CreepsBody = new Cuboid(this, 47, 0);
        this.CreepsBody.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.CreepsBody.addBox(-1.5F, -4.0F, -1.0F, 3, 4, 2, 0.0F);
        this.foot1B = new Cuboid(this, 38, 0);
        this.foot1B.setRotationPoint(-1.5F, 15.0F, 1.5F);
        this.foot1B.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);*/

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
}