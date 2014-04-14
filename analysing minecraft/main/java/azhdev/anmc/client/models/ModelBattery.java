package azhdev.anmc.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class ModelBattery extends ModelBase{
  //fields
    ModelRenderer main_body;
    ModelRenderer plus_connection;
    ModelRenderer negative_connection;
  
  public ModelBattery(){
    textureWidth = 32;
    textureHeight = 32;
    
      main_body = new ModelRenderer(this, 0, 0);
      main_body.addBox(0F, 0F, 0F, 10, 5, 4);
      main_body.setRotationPoint(-5F, 19F, -2F);
      main_body.setTextureSize(32, 32);
      main_body.mirror = true;
      setRotation(main_body, 0F, 0F, 0F);
      plus_connection = new ModelRenderer(this, 0, 0);
      plus_connection.addBox(0F, 0F, 0F, 1, 1, 1);
      plus_connection.setRotationPoint(3F, 18F, 0F);
      plus_connection.setTextureSize(32, 32);
      plus_connection.mirror = true;
      setRotation(plus_connection, 0F, 0F, 0F);
      negative_connection = new ModelRenderer(this, 0, 0);
      negative_connection.addBox(0F, 0F, 0F, 1, 1, 0);
      negative_connection.setRotationPoint(3F, 18F, -1F);
      negative_connection.setTextureSize(32, 32);
      negative_connection.mirror = true;
      setRotation(negative_connection, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    main_body.render(f5);
    plus_connection.render(f5);
    negative_connection.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z){
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5){
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
