package lumaceon.mods.clockworkphase.item.component.base;

import lumaceon.mods.clockworkphase.item.component.generic.ItemBaseComponentGeneric;
import lumaceon.mods.clockworkphase.item.construct.abstracts.IDisassemble;
import lumaceon.mods.clockworkphase.util.DisassembleHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGearBronze extends ItemBaseComponentGeneric implements IDisassemble
{
    @Override
    public boolean isComponentSpeedy(ItemStack is)
    {
        return true;
    }

    @Override
    public boolean isComponentQuality(ItemStack is)
    {
        return true;
    }

    @Override
    public boolean isComponentMemory(ItemStack is)
    {
        return false;
    }

    @Override
    public int getGearQuality(ItemStack is)
    {
        return 50;
    }

    @Override
    public int getGearSpeed(ItemStack is)
    {
        return 25;
    }

    @Override
    public int getMemoryValue(ItemStack is)
    {
        return 0;
    }

    @Override
    public void disassemble(World world, double x, double y, double z, ItemStack is)
    {
        if(!world.isRemote)
        {
            DisassembleHelper.disassembleMetalGear(world, x, y, z, is, "ingotBronze");
        }
    }
}
