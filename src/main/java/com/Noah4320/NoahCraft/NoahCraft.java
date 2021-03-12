package com.Noah4320.NoahCraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.Noah4320.NoahCraft.client.event.ClientEvents;
import com.Noah4320.NoahCraft.client.event.KeybindingsEvent;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("noahcraft")
public class NoahCraft
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "noahcraft";
    public static KeyBinding guiKeybind;

    public NoahCraft() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ClientEvents.class);
        MinecraftForge.EVENT_BUS.register(KeybindingsEvent.class);
        
        guiKeybind = new KeyBinding("Modify Text", 293, "key.categories.gameplay");
		ClientRegistry.registerKeyBinding(guiKeybind);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

}
