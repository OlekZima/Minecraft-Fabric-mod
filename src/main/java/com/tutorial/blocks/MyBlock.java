package com.tutorial.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MyBlock extends Block {
    protected static final VoxelShape COLLISION_SHAPE;

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }
    private final DamageSource dmg = new DamageSource("SMTH") {
        public Text getDeathMessage(LivingEntity entity) {
            return Text.of("You have been ITN'ed!");
        }
    };

    public MyBlock(Settings settings) {
        super(settings);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient) {
            entity.damage(dmg, 1.5f);
        }
        super.onEntityCollision(state, world, pos, entity);
    }
    static {
        COLLISION_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 15.0, 15.0);
    }

}
