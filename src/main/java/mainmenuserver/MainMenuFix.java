package mainmenuserver;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.multiplayer.GuiConnecting;

public class MainMenuFix
        extends GuiMainMenu
{
    static boolean disabled = false;
    public boolean drawing = false;

    public void initGui()
    {
        int i = this.height/ 4 + 48;
        GuiButtonServerConnect button = new GuiButtonServerConnect(7, this.width / 2 - 100, i - 24, "Connect to official server");
        this.buttonList.add(button);
        super.initGui();
    }

    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.id == 7)
        {
            if (!disabled) {
                Minecraft.getMinecraft().displayGuiScreen(new GuiConnecting(this, Minecraft.getMinecraft(), "ftb.bybservers.co.uk", 24565));
            }
        }
        else {
            super.actionPerformed(par1GuiButton);
        }
    }

    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawing = true;
        super.drawScreen(par1, par2, par3);
    }
}