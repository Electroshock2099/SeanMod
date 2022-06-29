package net.sean.seanmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.sean.seanmod.entities.client.Mo_Renderer;
import net.sean.seanmod.init.*;
import net.sean.seanmod.util.seancore.KeyInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.sean.seanmod.init.SeanBlocks;
import net.sean.seanmod.init.SeanItems;
import net.sean.seanmod.init.SeanFluids.*;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;

import static net.sean.seanmod.init.SeanFluids.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SeanMod.modid)
public class SeanMod
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String modid = "seanmod";

    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("thrown_weapons", "thrown_weapons"), () -> "1", "1"::equals, "1"::equals);

    public SeanMod()
    {   IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
       // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
         SeanBlocks.register(eventBus);
         SeanItems.register(eventBus);
         SeanFluids.register(eventBus);
         SeanEffects.register(eventBus);
         SeanBlockEntities.register(eventBus);
         //SeanPlants.register(eventBus);
        SeanParticles.register(eventBus);




        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);


       // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
       // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in

        MinecraftForge.EVENT_BUS.register(this);

        EntityRenderers.register(SeanEntities.MO.get(), Mo_Renderer::new);
        GeckoLib.initialize();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
private void clientSetup(final FMLClientSetupEvent event)
    {

        ItemBlockRenderTypes.setRenderLayer(TEST_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TEST_SOURCE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TEST_BLOCK.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SeanFluids.MDN_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeanFluids.MDN_SOURCE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeanFluids.MDN_BLOCK.get(), RenderType.translucent());

        KeyInit.init();
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("seanmod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // Some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {

        /**
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }**/
    }
    static{

    };
/**
    public static final EntityType<GenericThrownItemEntity> GenericThrownItemEntityType = Registry.register(
            Registry.ENTITY_TYPE_REGISTRY,
            new Identifier(modid, "generic_thrown_item"),
            EntityType.Builder.<GenericThrownItemEntity>create()
                    //GenericThrownItemEntity::new)
                    .dimensions(EntityDimensions.fixed(0.65F, 0.65F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(100).trackedUpdateRate(20) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                    .build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
    );

    public static final Block GENERIC_ITEM_BLOCK = new GenericItemBlock(FabricBlockSettings.of(Material.METAL).strength(-1.0f, 9999999f).nonOpaque());

    public static BlockEntityType<GenericItemBlockEntity> GENERIC_ITEM_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(GenericItemBlockEntity::new, GENERIC_ITEM_BLOCK).build();


    public static Enchantment WorthyWeapon = Registry.register(Registry.ENCHANTMENT,
            new Identifier(modid, "worthyweapon"),
            new WorthyWeaponEnchantment());

    public static Enchantment WorthyTool = Registry.register(Registry.ENCHANTMENT,
            new Identifier(modid, "worthytool"),
            new WorthyToolEnchantment());

    public static Enchantment PinnedWeapon  = Registry.register(Registry.ENCHANTMENT,
            new Identifier(modid, "pinnedweapon"),
            new PinnedWeaponEnchantment());

    public static Enchantment PinnedTool  = Registry.register(Registry.ENCHANTMENT,
            new Identifier(modid, "pinnedtool"),
            new PinnedToolEnchantment());

    public static Enchantment FlameWeapon = Registry.register(Registry.ENCHANTMENT,
            new Identifier(modid, "flameweapon"),
            new FlameWeaponEnchantment());

    public static Enchantment FlameTool = Registry.register(Registry.ENCHANTMENT,
            new Identifier(modid, "flametool"),
            new FlameToolEnchantment());

    public static Enchantment FrostWeapon = Registry.register(Registry.ENCHANTMENT,
            new Identifier(modid, "frostweapon"),
            new FrostWeaponEnchantment());

    public static Enchantment FrostTool = Registry.register(Registry.ENCHANTMENT,
            new Identifier(modid, "frosttool"),
            new FrostToolEnchantment());

    public static Enchantment LightningWeapon = Registry.register(Registry.ENCHANTMENT,
            new Identifier(modid, "lightningweapon"),
            new LightningWeaponEnchantment());

    public static Enchantment LightningTool = Registry.register(Registry.ENCHANTMENT,
            new Identifier(modid, "lightningtool"),
            new LightningToolEnchantment());



    public static final StatusEffect Paralysis = new ParalysisEffect();




    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("In the main");

        Registry.register(Registry.BLOCK_REGISTRY, new Identifier(ModID, "generic_item_block"), GENERIC_ITEM_BLOCK);

        Registry.register(Registry.BLOCK_ENTITY_TYPE_REGISTRY, new Identifier(ModID, "generic_item_block_entity"), GENERIC_ITEM_BLOCK_ENTITY);

        Registry.register(Registry.MOB_EFFECT_REGISTRY, new Identifier("bns", "paralysis"), Paralysis);

        CommandRegistrationCallback.EVENT.register((dispatcher, access, dedicated) -> {

            dispatcher.register(CommandManager.literal("BNS").then(CommandManager.literal("bar")
                    .executes(context -> {
                        MinecraftServer server = context.getSource().getServer();
                        BNSCore.resetStacks(server.getWorld(World.OVERWORLD));
                        BNSCore.resetStacks(server.getWorld(World.NETHER));
                        BNSCore.resetStacks(server.getWorld(World.END));
                        BNSCore.LOGGER.info("Resetting Stacks!");
                        return 1;

                    })));
        });

        NetworkHandlerServer.registerServerResponses();

        ParticleRegistery.registerParticles();

        SoundRegistry.registerSounds();
    }

    public static void removeEntityFromStack(ServerWorld world, String name, int id){
        //UUIDStackComponent uuidstack = mycomponents.EntityUUIDs.get(world.getLevelProperties());
        UUIDStackComponent uuidstack = mycomponents.EntityUUIDs.get(world);

        uuidstack.Remove(name, id);
    }

    public static int pushEntityOntoStack(ServerWorld world, String name, UUID uuid){
        //UUIDStackComponent stack = mycomponents.EntityUUIDs.get(world.getLevelProperties());
        UUIDStackComponent stack = mycomponents.EntityUUIDs.get(world);
        int id = stack.Push(name, uuid);
        return id;
    }

    public static void removeBEFromStack(ServerWorld world, String name, int id){
        //BlockPosStackComponent stack = mycomponents.BlockEntityPositions.get(world.getLevelProperties());
        BlockPosStackComponent stack = mycomponents.BlockEntityPositions.get(world);

        stack.Remove(name, id);
    }

    public static int pushBEOntoStack(ServerWorld world, String name, BlockPos hitpos){
        //BlockPosStackComponent stack = mycomponents.BlockEntityPositions.get(world.getLevelProperties());
        BlockPosStackComponent stack = mycomponents.BlockEntityPositions.get(world);

        int id = stack.Push(name, hitpos);

        return id;
    }

    public static void removePlayerBlock(ServerWorld world, String name){
        PlayerBlockComponent stack = BNSCore.getPlayerBlockStack(world);

        stack.Remove(name, 0);
    }

    public static void pushPlayerBlock(ServerWorld world, String name, boolean value){
        PlayerBlockComponent stack = BNSCore.getPlayerBlockStack(world);

        stack.Push(name, value);
    }

    public static boolean getPlayerBlock(ServerWorld world, String name){
        PlayerBlockComponent stack = BNSCore.getPlayerBlockStack(world);
        Boolean res = stack.Peek(name);
        return res == null ? false : res;
    }

    public static void resetStacks(ServerWorld world){
        BlockPosStackComponent bstack = BNSCore.getBlockStack(world);
        UUIDStackComponent eStack = BNSCore.getEntitytack(world);

        bstack.Reset();
        eStack.Reset();
    }

    public static BlockPosStackComponent getBlockStack(ServerWorld world){
        return  mycomponents.BlockEntityPositions.get(world);
    }

    public static UUIDStackComponent getEntitytack(ServerWorld world){
        return  mycomponents.EntityUUIDs.get(world);
    }

    public static PlayerBlockComponent getPlayerBlockStack(ServerWorld world){
        return mycomponents.PlayerBlocks.get(world);
        //return null;
    }



    public void HandleBlockRecall(ServerWorld world){

    }**/
}
