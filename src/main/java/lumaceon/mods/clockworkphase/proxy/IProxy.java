package lumaceon.mods.clockworkphase.proxy;

import net.minecraft.world.World;

public interface IProxy
{
    public void initializeParticleGenerator();

    public World getStaticWorld();
}