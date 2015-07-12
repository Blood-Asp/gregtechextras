package bloodasp.gregtechextras.tank;

import bloodasp.gregtechextras.GTExtras;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;

public class BlockTank extends Block{
	
	
	static int renderType; 

	protected BlockTank(Material material) {
		super(material);
		if(FMLCommonHandler.instance().getSide().isClient()){
		renderType=GTExtras.getUniqueBlockModelID("bloodasp.gregtechextras.LampRenderCubeStatic");}
	}
	
	public BlockTank(){
		this(Material.iron);
		this.setBlockBounds(0.45F, 0.45F, 0.45F, 0.55F, 0.55F, 0.55F);
	}
	
	@Override
	public int getRenderType() {
		return renderType;
	}
	
	@Override
	public String getUnlocalizedName(){
		return String.format("tile.gregtechexras:"+super.getUnlocalizedName());
	}
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		//blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
		blockIcon = iconRegister.registerIcon(Blocks.air.getUnlocalizedName());
	}
}
