package com.Noah4320.NoahCraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.Noah4320.NoahCraft.client.event.ClientEvents;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("noahcraft")
public class NoahCraft
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "noahcraft";

    public NoahCraft() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
       
        MinecraftForge.EVENT_BUS.register(ClientEvents.class);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

}
