package lumaceon.mods.clockworkphase.client.gui.components;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class GuiButtonItemActive extends GuiButton
{
    public boolean active;
    public ItemStack item;
    public RenderItem itemRender;
    public FontRenderer fontRenderer;
    public Minecraft mc;

    public GuiButtonItemActive(ItemStack is, int p_i1020_1_, int p_i1020_2_, int p_i1020_3_, String p_i1020_4_, RenderItem renderItem, FontRenderer fontRenderer, boolean active)
    {
        super(p_i1020_1_, p_i1020_2_, p_i1020_3_, 20, 20, p_i1020_4_);
        this.item = is;
        this.itemRender = renderItem;
        this.itemRender.renderWithColor = false;
        this.mc = Minecraft.getMinecraft();
        this.active = active;
    }

    @Override
    public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
    {
        if (this.visible)
        {
            FontRenderer fontrenderer = p_146112_1_.fontRenderer;
            p_146112_1_.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_LIGHTING);
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int k = this.getHoverState(this.field_146123_n);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
            this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
            int l = 14737632;

            if (packedFGColour != 0)
            {
                l = packedFGColour;
            }
            else if (!this.enabled)
            {
                l = 10526880;
            }
            else if (this.field_146123_n)
            {
                l = 16777120;
            }

            if(item != null)
            {
                if(!active)
                {
                    GL11.glColor4f(0.5F, 0.5F, 0.5F, 1.0F);
                }
                else
                {
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                }
                this.drawItemStack(item, this.xPosition + 2, this.yPosition + 2, this.displayString);
            }
        }
    }

    private void drawItemStack(ItemStack is, int x, int y, String name)
    {
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);
        float zLevelOrigin = this.zLevel;
        this.zLevel = 200.0F;
        itemRender.zLevel = 200.0F;
        FontRenderer font = null;
        if (is != null) font = is.getItem().getFontRenderer(is);
        if (font == null) font = fontRenderer;
        itemRender.renderItemAndEffectIntoGUI(font, this.mc.getTextureManager(), is, x, y);
        this.zLevel = zLevelOrigin;
        itemRender.zLevel = 0.0F;
    }
}
