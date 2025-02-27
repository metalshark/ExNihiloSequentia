package novamachina.exnihilosequentia.common.init;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import novamachina.exnihilosequentia.common.fluid.SeaWaterFluid;
import novamachina.exnihilosequentia.common.fluid.WitchWaterFluid;
import novamachina.exnihilosequentia.common.utility.ExNihiloConstants;
import novamachina.exnihilosequentia.common.utility.ExNihiloLogger;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nonnull;

public class ExNihiloFluids {

    @Nonnull private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister
            .create(ForgeRegistries.FLUIDS, ExNihiloConstants.ModIds.EX_NIHILO_SEQUENTIA);
    @Nonnull public static final RegistryObject<FlowingFluid> WITCH_WATER = FLUIDS
            .register(ExNihiloConstants.Fluids.WITCH_WATER,
                    () -> new WitchWaterFluid.Source(WitchWaterFluid.WITCH_WATER_PROPS));
    @Nonnull public static final RegistryObject<FlowingFluid> WITCH_WATER_FLOW = FLUIDS
            .register(ExNihiloConstants.Fluids.WITCH_WATER_FLOW,
                    () -> new WitchWaterFluid.Flowing(WitchWaterFluid.WITCH_WATER_PROPS));
    @Nonnull public static final RegistryObject<FlowingFluid> SEA_WATER = FLUIDS
            .register(ExNihiloConstants.Fluids.SEA_WATER,
                    () -> new SeaWaterFluid.Source(SeaWaterFluid.SEA_WATER_PROPS));
    @Nonnull public static final RegistryObject<FlowingFluid> SEA_WATER_FLOW = FLUIDS
            .register(ExNihiloConstants.Fluids.SEA_WATER_FLOW,
                    () -> new SeaWaterFluid.Flowing(SeaWaterFluid.SEA_WATER_PROPS));
    @Nonnull private static final ExNihiloLogger logger = new ExNihiloLogger(LogManager.getLogger());

    private ExNihiloFluids() {

    }

    public static void init(@Nonnull final IEventBus modEventBus) {
        logger.debug("Register fluids");
        FLUIDS.register(modEventBus);
    }
}
