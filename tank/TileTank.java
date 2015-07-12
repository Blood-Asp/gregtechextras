package bloodasp.gregtechextras.tank;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;

public class TileTank extends TileEntity {

	
	
	@Override
	public void updateEntity(){
		
	}
	
	@SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
        return 65536.0D;
    }
	
}
