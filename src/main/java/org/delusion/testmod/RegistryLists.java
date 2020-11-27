package org.delusion.testmod;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraft.entity.ai.brain.schedule.Schedule;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DataSerializerEntry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

public class RegistryLists<T extends IForgeRegistryEntry<T>> {
    @SuppressWarnings("unchecked") // copied hack from net.minecraftforge.GameData for passing in typed classes
    private static <T> Class<T> c(Class<?> cls) { return (Class<T>)cls; }


    public static RegistryLists<Block>                           BLOCKS                     = new RegistryLists<Block>(Block.class);
    public static RegistryLists<Fluid>                           FLUIDS                     = new RegistryLists<Fluid>(Fluid.class);
    public static RegistryLists<Item>                            ITEMS                      = new RegistryLists<Item>(Item.class);
    public static RegistryLists<Effect>                          EFFECTS                    = new RegistryLists<Effect>(Effect.class);
    public static RegistryLists<SoundEvent>                      SOUND_EVENTS               = new RegistryLists<SoundEvent>(SoundEvent.class);
    public static RegistryLists<Potion>                          POTIONS                    = new RegistryLists<Potion>(Potion.class);
    public static RegistryLists<Enchantment>                     ENCHANTMENTS               = new RegistryLists<Enchantment>(Enchantment.class);
    public static RegistryLists<EntityType<?>>                   ENTITY_TYPES               = new RegistryLists<EntityType<?>>(c(EntityType.class));
    public static RegistryLists<TileEntityType<?>>               TILE_ENTITY_TYPES          = new RegistryLists<TileEntityType<?>>(c(TileEntityType.class));
    public static RegistryLists<ParticleType<?>>                 PARTICLE_TYPES             = new RegistryLists<ParticleType<?>>(c(ParticleType.class));
    public static RegistryLists<ContainerType<?>>                CONTAINER_TYPES            = new RegistryLists<ContainerType<?>>(c(ContainerType.class));
    public static RegistryLists<PaintingType>                    PAINTING_TYPES             = new RegistryLists<PaintingType>(PaintingType.class);
    public static RegistryLists<IRecipeSerializer<?>>            RECIPE_SERIALIZERS         = new RegistryLists<IRecipeSerializer<?>>(c(IRecipeSerializer.class));
    public static RegistryLists<Attribute>                       ATTRIBUTES                 = new RegistryLists<Attribute>(Attribute.class);
    public static RegistryLists<StatType<?>>                     STAT_TYPES                 = new RegistryLists<StatType<?>>(c(StatType.class));
    public static RegistryLists<VillagerProfession>              VILLAGER_PROFESSIONS       = new RegistryLists<VillagerProfession>(VillagerProfession.class);
    public static RegistryLists<PointOfInterestType>             POI_TYPES                  = new RegistryLists<PointOfInterestType>(PointOfInterestType.class);
    public static RegistryLists<MemoryModuleType<?>>             MEMORY_MODULE_TYPES        = new RegistryLists<MemoryModuleType<?>>(c(MemoryModuleType.class));
    public static RegistryLists<SensorType<?>>                   SENSOR_TYPES               = new RegistryLists<SensorType<?>>(c(SensorType.class));
    public static RegistryLists<Schedule>                        SCHEDULES                  = new RegistryLists<Schedule>(Schedule.class);
    public static RegistryLists<Activity>                        ACTIVITIES                 = new RegistryLists<Activity>(Activity.class);
    public static RegistryLists<WorldCarver<?>>                  WORLD_CARVERS              = new RegistryLists<WorldCarver<?>>(c(WorldCarver.class));
    public static RegistryLists<SurfaceBuilder<?>>               SURFACE_BUILDERS           = new RegistryLists<SurfaceBuilder<?>>(c(SurfaceBuilder.class));
    public static RegistryLists<Feature<?>>                      FEATURES                   = new RegistryLists<Feature<?>>(c(Feature.class));
    public static RegistryLists<Placement<?>>                    DECORATORS                 = new RegistryLists<Placement<?>>(c(Placement.class));
    public static RegistryLists<ChunkStatus>                     CHUNK_STATUS               = new RegistryLists<ChunkStatus>(ChunkStatus.class);
    public static RegistryLists<Structure<?>>                    STRUCTURE_FEATURES         = new RegistryLists<Structure<?>>(c(Structure.class));
    public static RegistryLists<BlockStateProviderType<?>>       BLOCK_STATE_PROVIDER_TYPES = new RegistryLists<BlockStateProviderType<?>>(c(BlockStateProviderType.class));
    public static RegistryLists<BlockPlacerType<?>>              BLOCK_PLACER_TYPES         = new RegistryLists<BlockPlacerType<?>>(c(BlockPlacerType.class));
    public static RegistryLists<FoliagePlacerType<?>>            FOLIAGE_PLACER_TYPES       = new RegistryLists<FoliagePlacerType<?>>(c(FoliagePlacerType.class));
    public static RegistryLists<TreeDecoratorType<?>>            TREE_DECORATOR_TYPES       = new RegistryLists<TreeDecoratorType<?>>(c(TreeDecoratorType.class));
    public static RegistryLists<Biome>                           BIOMES                     = new RegistryLists<Biome>(Biome.class);
    public static RegistryLists<DataSerializerEntry>             DATA_SERIALIZERS           = new RegistryLists<DataSerializerEntry>(DataSerializerEntry.class);
    public static RegistryLists<GlobalLootModifierSerializer<?>> LOOT_MODIFIER_SERIALIZERS  = new RegistryLists<GlobalLootModifierSerializer<?>>(c(GlobalLootModifierSerializer.class));


    private HashMap<ResourceLocation,T> registryContents = new HashMap<>();
    private Class<T> supertype;

    public RegistryLists(Class<T> supertype) {
        this.supertype = supertype;
    }

    public Supplier<T> getter(String name) {
        return () -> registryContents.get(new ResourceLocation(TestMod.MODID, name));
    }

    @SubscribeEvent
    public void register(RegistryEvent.Register<T> registryEvent) {
        registryContents.values().forEach(registryEvent.getRegistry()::register);
    }

    private void setupSelf(IEventBus modEventBus) {
        modEventBus.addGenericListener(supertype,this::register);
    }

    public static void setupAll(IEventBus modEventBus) {

        BLOCKS.setupSelf(modEventBus);
        FLUIDS.setupSelf(modEventBus);
        ITEMS.setupSelf(modEventBus);
        EFFECTS.setupSelf(modEventBus);
        SOUND_EVENTS.setupSelf(modEventBus);
        POTIONS.setupSelf(modEventBus);
        ENCHANTMENTS.setupSelf(modEventBus);
        ENTITY_TYPES.setupSelf(modEventBus);
        TILE_ENTITY_TYPES.setupSelf(modEventBus);
        PARTICLE_TYPES.setupSelf(modEventBus);
        CONTAINER_TYPES.setupSelf(modEventBus);
        PAINTING_TYPES.setupSelf(modEventBus);
        RECIPE_SERIALIZERS.setupSelf(modEventBus);
        ATTRIBUTES.setupSelf(modEventBus);
        STAT_TYPES.setupSelf(modEventBus);
        VILLAGER_PROFESSIONS.setupSelf(modEventBus);
        POI_TYPES.setupSelf(modEventBus);
        MEMORY_MODULE_TYPES.setupSelf(modEventBus);
        SENSOR_TYPES.setupSelf(modEventBus);
        SCHEDULES.setupSelf(modEventBus);
        ACTIVITIES.setupSelf(modEventBus);
        WORLD_CARVERS.setupSelf(modEventBus);
        SURFACE_BUILDERS.setupSelf(modEventBus);
        FEATURES.setupSelf(modEventBus);
        DECORATORS.setupSelf(modEventBus);
        CHUNK_STATUS.setupSelf(modEventBus);
        STRUCTURE_FEATURES.setupSelf(modEventBus);
        BLOCK_STATE_PROVIDER_TYPES.setupSelf(modEventBus);
        BLOCK_PLACER_TYPES.setupSelf(modEventBus);
        FOLIAGE_PLACER_TYPES.setupSelf(modEventBus);
        TREE_DECORATOR_TYPES.setupSelf(modEventBus);
        BIOMES.setupSelf(modEventBus);
        DATA_SERIALIZERS.setupSelf(modEventBus);
        LOOT_MODIFIER_SERIALIZERS.setupSelf(modEventBus);
    }

    public void add(String name, T object) {
        add(new ResourceLocation(TestMod.MODID, name), object);
    }

    public void add(ResourceLocation name, T object) {
        add(object.setRegistryName(name));
    }

    public void add(T object) {
        this.registryContents.put(object.getRegistryName(), object);
    }

    public T get(ResourceLocation rl) {
        return registryContents.get(rl);
    }

    public T get(String name) {
        return registryContents.get(new ResourceLocation(TestMod.MODID, name));
    }
}
