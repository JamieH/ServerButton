package mainmenuserver;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiButtonServerConnect
        extends GuiButton
{
    ResourceLocation resource;
    boolean cont = false;
    static GuiMainMenu gmm;

    public GuiButtonServerConnect(int par1, int par2, int par3, String par4Str)
    {
        super(par1, par2, par3, par4Str);
        this.resource = new ResourceLocation("mainmenuserver:menuico.png");
    }

    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        super.drawButton(par1Minecraft, par2, par3);
        Minecraft.getMinecraft().renderEngine.bindTexture(this.resource);
        GL11.glBlendFunc(770, 771);
        drawTexturedModalRect(this.xPosition + 4, this.yPosition + 3, 14, 14);
        drawTexturedModalRect(this.xPosition + 182, this.yPosition + 3, 14, 14);
    }

    public void drawTexturedModalRect(int par1, int par2, int par5, int par6)
    {
        boolean shouldBlend = GL11.glGetBoolean(3042);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        if (!shouldBlend) {
            GL11.glEnable(3042);
        }
        tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 0.75F);
        tessellator.addVertexWithUV(par1 + 0, par2 + par6, this.zLevel, 0.0D, 1.0D);
        tessellator.addVertexWithUV(par1 + par5, par2 + par6, this.zLevel, 1.0D, 1.0D);
        tessellator.addVertexWithUV(par1 + par5, par2 + 0, this.zLevel, 1.0D, 0.0D);
        tessellator.addVertexWithUV(par1 + 0, par2 + 0, this.zLevel, 0.0D, 0.0D);
        tessellator.draw();
        tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
        if (!shouldBlend) {
            GL11.glDisable(3042);
        }
    }
}