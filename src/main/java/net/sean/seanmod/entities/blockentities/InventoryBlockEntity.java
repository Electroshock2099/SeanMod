package net.sean.seanmod.entities.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InventoryBlockEntity extends BlockEntity {

    //public InventoryBlockEntity(Properties properties) {
        //super(properties);
   // }
    public  int size;// = 48;
    protected int timer;
    protected boolean requiresUpdate;

    public final ItemStackHandler inventory;
    protected LazyOptional<ItemStackHandler> handler;

    public InventoryBlockEntity(BlockEntityType<?> entityType, BlockPos blockPos, BlockState state, int i) {
        super(entityType, blockPos, state);
        if (size<=0){
            size=1;
        }
        this.size=size;
        this.inventory = createInventory();
        this.handler = LazyOptional.of(()->this.inventory);
    }

public ItemStack extractItem(int slot){
        final int count = getItemInSlot(slot).getCount();
        this.requiresUpdate = true;
        return this.handler.map(inv -> inv.extractItem(slot, count, false)).orElse(ItemStack.EMPTY);
}

public ItemStack getItemInSlot(int slot){
        return this.handler.map(inv -> inv.getStackInSlot(slot)).orElse(ItemStack.EMPTY);
}
public ItemStack insertItem(int slot, ItemStack stack){
        ItemStack copy = stack.copy();
        stack.shrink(copy.getCount());
        this.requiresUpdate=true;
        return this.handler.map(inv -> inv.insertItem(slot, copy, false)).orElse(ItemStack.EMPTY);
}
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? this.handler.cast() :super.getCapability(cap,side);
    }

    public LazyOptional<ItemStackHandler> getHandler() {
        return handler;
    }

    public ItemStackHandler getInventory() {
        return inventory;
    }

    private ItemStackHandler createInventory(){
        return new ItemStackHandler(this.size){
            @NotNull
            @Override
            public ItemStack extractItem(int slot, int amount, boolean simulate) {
                InventoryBlockEntity.this.update();
                return super.extractItem(slot, amount, simulate);
            }

            @NotNull
            @Override
            public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }

        };

    }

    public void tick(){
        this.timer++;
        if (this.requiresUpdate && this.level!=null){
            update();
            this.requiresUpdate=false;
        }
    }
    public void update(){
        requestModelDataUpdate();
        setChanged();
        if(this.level !=null){
            this.level.setBlockAndUpdate(worldPosition,getBlockState());
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
                //super.getUpdatePacket();
    }

    @Override
    public CompoundTag getUpdateTag() {
        return serializeNBT();
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        load(tag);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Inventory",this.inventory.serializeNBT());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.inventory.deserializeNBT(tag.getCompound("Inventory"));
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.handler.invalidate();
    }



    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        handleUpdateTag(pkt.getTag());
    }
}
