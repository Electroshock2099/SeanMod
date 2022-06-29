package net.sean.seanmod.items.custom;

import net.sean.seanmod.init.SeanItems;
import net.sean.seanmod.init.SeanParticles;
import net.sean.seanmod.util.InventoryUtil;
import net.sean.seanmod.util.SeanTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

import javax.annotation.Nullable;
import java.util.List;

public class SeanItem extends Item {
    public SeanItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if (isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;

                    if (InventoryUtil.hasPlayerStackInInventory(player, SeanItems.DATA_TABLET.get())) {
                        addNbtToDataTablet(player, positionClicked.below(i), blockBelow);
                    }

                    spawnFoundParticles(pContext, positionClicked);

                    pContext.getLevel().playSound(player, positionClicked, SoundType.CHAIN.getStepSound(),
                            SoundSource.BLOCKS, 1f, 1f);

                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.seanmod.dowsing_rod.no_valuables"),
                        player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void spawnFoundParticles(UseOnContext pContext, BlockPos positionClicked) {
        for (int i = 0; i < 360; i++) {
            if (i % 20 == 0) {
                pContext.getLevel().addParticle(SeanParticles.VOID_CHAOS.get(),
                        positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d,
                        Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.15d);
            }
        }
    }

    private void addNbtToDataTablet(Player player, BlockPos pos, Block blockBelow) {
        ItemStack dataTablet =
                player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, SeanItems.DATA_TABLET.get()));

        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("seanmod.last_ore", "Found " + blockBelow.asItem().getRegistryName().toString() + " at (" +
                pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")");

        dataTablet.setTag(nbtData);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.seanmod.dowsing_rod.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.seanmod.dowsing_rod.tooltip"));
        }
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isValuableBlock(Block block) {
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get()).is(SeanTags.Blocks.DOWSING_ROD_VALUABLES);
    }
}
