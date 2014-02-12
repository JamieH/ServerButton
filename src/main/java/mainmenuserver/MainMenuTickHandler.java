package mainmenuserver;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;

public class MainMenuTickHandler
        implements ITickHandler
{
    boolean skipNext = false;
    GuiScreen last;
    int counter = 0;
    public static boolean connect = false;

    public void tickStart(EnumSet<TickType> type, Object... tickData) {}

    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
        if (Minecraft.getMinecraft().theWorld == null) {
            try
            {
                if (Minecraft.getMinecraft().currentScreen != null)
                {
                    if (connect)
                    {
                        connect = false;
                        Minecraft.getMinecraft().displayGuiScreen(new GuiConnecting(new MainMenuFix(), Minecraft.getMinecraft(), PacketHandler.server, PacketHandler.port));
                        return;
                    }
                    if (Minecraft.getMinecraft().currentScreen.getClass().getName().equals("net.minecraft.client.gui.GuiMainMenu"))
                    {
                        if ((this.last instanceof GuiIngameMenu)) {
                            this.skipNext = false;
                        }
                        Minecraft.getMinecraft().displayGuiScreen(new MainMenuFix());
                    }
                    else if (Minecraft.getMinecraft().currentScreen.getClass().getName().equals("net.minecraft.client.gui.GuiSelectWorld"))
                    {
                        this.skipNext = true;
                    }
                    else if (!(Minecraft.getMinecraft().currentScreen instanceof MainMenuFix))
                    {
                        this.skipNext = false;
                    }
                    else
                    {
                        MainMenuFix.disabled = this.skipNext;
                    }
                }
            }
            catch (Throwable ex) {}
        }
        this.last = Minecraft.getMinecraft().currentScreen;
    }

    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.CLIENT);
    }

    public String getLabel()
    {
        return "MenuTickHandler";
    }
}