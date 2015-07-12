package bloodasp.gregtechextras.tank;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class TankRenderCubeStatic {

	public boolean renderWorldBlock(RenderBlocks render, IBlockAccess world, int x, int y, int z, Block block, int model) {
		render.renderStandardBlock(block, x, y, z);
		TankHalo.addLamp(world, x, y, z);
		System.out.println("add lamp" + x + " " + y + " " + z + "-------------------------------------------------------------------------------------");
		return true;
	}

	public void renderInvBlock(RenderBlocks render, Block block, int meta, int model) {
		BlockTank.renderType = 0;
		render.renderBlockAsItem(block, meta, 1);
		BlockTank.renderType = model;
	}
}
