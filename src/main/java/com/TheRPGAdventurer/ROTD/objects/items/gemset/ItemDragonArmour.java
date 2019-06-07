package com.TheRPGAdventurer.ROTD.objects.items.gemset;


import com.TheRPGAdventurer.ROTD.DragonMounts;
import com.TheRPGAdventurer.ROTD.inits.ModArmour;
import com.TheRPGAdventurer.ROTD.objects.items.EnumItemBreedTypes;
import com.TheRPGAdventurer.ROTD.util.DMUtils;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemDragonArmour extends ItemArmor {

    public EnumItemBreedTypes type;

    public ItemDragonArmour(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocalizedName, EnumItemBreedTypes type) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setUnlocalizedName("dragonscale_" + equipmentSlotIn.toString().toLowerCase());
        this.setRegistryName(new ResourceLocation(DragonMounts.MODID, unlocalizedName));
        this.setCreativeTab(DragonMounts.armoryTab);
        this.type=type;

        new ItemStack(this).setStackDisplayName(type.color + new ItemStack(this).getDisplayName());

    }


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(type.color + DMUtils.translateToLocal("dragon." + type.toString().toLowerCase()));
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        Item head=player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem();
        Item chest=player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem();
        Item legs=player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem();
        Item feet=player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem();

        if (head==ModArmour.forestDragonScaleCap && player.fishEntity!=null && new Random().nextInt(25)==1)
            player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 300, 0, false, false));
        if (head==ModArmour.moonlightDragonScaleCap && !player.world.isDaytime())
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 300, 0, false, false));
        if (chest==ModArmour.forestDragonScaleTunic && player.getAttackingEntity()!=null && player.attackEntityFrom(DamageSource.causeMobDamage(player.getAttackingEntity()), (float) player.getAttackingEntity().getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()) && new Random().nextInt(25)==1)
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 0, false, false));
        if (chest==ModArmour.iceDragonScaleTunic && player.getAttackingEntity()!=null && new Random().nextInt(25)==1)
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 0, false, false));
        if (((head==ModArmour.fireDragonScaleCap || head==ModArmour.fireDragonScaleCap2) && (chest==ModArmour.fireDragonScaleTunic || chest==ModArmour.fireDragonScaleTunic2) && (legs==ModArmour.fireDragonScaleLeggings || legs==ModArmour.fireDragonScaleLeggings2) && (feet==ModArmour.fireDragonScaleBoots || feet==ModArmour.fireDragonScaleBoots2)) && !(player.isInLava() || player.world.isMaterialInBB(player.getEntityBoundingBox().grow(-0.1, -0.4, -0.1), Material.FIRE) || player.isBurning())) {
            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
        }
        if (head==ModArmour.waterDragonScaleCap && player.isInWater()) {
            player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 300, 0, false, false));
        }

    }

}