package mainmenuserver;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = MainMenuServer.ID,name=MainMenuServer.NAME, version = MainMenuServer.VERSION)
public class MainMenuServer {
    public static final String ID = "mainmenuserver";
    public static final String NAME = "Button for server";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        if (FMLCommonHandler.instance().getEffectiveSide().isClient())
        {
            TickRegistry.registerTickHandler(new MainMenuTickHandler(), Side.CLIENT);
        }
    }
}
