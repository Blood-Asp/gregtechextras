package bloodasp.gregtechextras.armor;

import java.util.HashMap;
import java.util.Map;

import gregapi.data.MT;
import gregapi.oredict.OreDictMaterial;

public class Values {
	public static Values INSTANCE;
	public static final Map<OreDictMaterial, Values> MATERIAL_MAP = new HashMap<OreDictMaterial, Values>();

	public int weight;
	public float physicalDef;
	public float projectileDef;
	public float fireDef;
	public float magicDef;
	public float explosionDef;

	public Values(OreDictMaterial material, int weight, float physicalDef, float projectileDef, float fireDef, float magicDef, float explosionDef) {
		this.weight = weight;
		this.physicalDef = physicalDef;
		this.projectileDef = projectileDef;
		this.fireDef = fireDef;
		this.magicDef = magicDef;
		this.explosionDef = explosionDef;
	}

	public Values() {
		INSTANCE = this;
		MATERIAL_MAP.put(MT.NULL, new Values(MT.NULL, 0, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f));
		MATERIAL_MAP.put(MT.Rubber, new Values(MT.Rubber, 60, 0.06f, 0.06f, 0.02f, 0.1f, 0.1f));
		MATERIAL_MAP.put(MT.Wood, new Values(MT.Wood, 80, 0.08f, 0.09f, 0.02f, 0.08f, 0.08f));
		MATERIAL_MAP.put(MT.Brass, new Values(MT.Brass, 140, 0.12f, 0.12f, 0.10f, 0.10f, 0.12f));
		MATERIAL_MAP.put(MT.Copper, new Values(MT.Copper, 140, 0.11f, 0.11f, 0.10f, 0.10f, 0.11f));
		MATERIAL_MAP.put(MT.Lead, new Values(MT.Lead, 280, 0.05f, 0.05f, 0.05f, 0.05f, 0.05f));
		MATERIAL_MAP.put(MT.Plastic, new Values(MT.Plastic, 60, 0.10f, 0.10f, 0.02f, 0.02f, 0.10f));
		MATERIAL_MAP.put(MT.Aluminium, new Values(MT.Aluminium, 120, 0.14f, 0.14f, 0.12f, 0.12f, 0.14f));
		MATERIAL_MAP.put(MT.AstralSilver, new Values(MT.AstralSilver, 180, 0.10f, 0.10f, 0.10f, 0.18f, 0.10f));
		MATERIAL_MAP.put(MT.BismuthBronze, new Values(MT.BismuthBronze, 160, 0.12f, 0.12f, 0.10f, 0.10f, 0.12f));
		MATERIAL_MAP.put(MT.BlackBronze, new Values(MT.BlackBronze, 160, 0.13f, 0.13f, 0.10f, 0.10f, 0.13f));
		MATERIAL_MAP.put(MT.BlackSteel, new Values(MT.BlackSteel, 200, 0.19f, 0.19f, 0.17f, 0.17f, 0.19f));
		MATERIAL_MAP.put(MT.BlueSteel, new Values(MT.BlueSteel, 200, 0.21f, 0.21f, 0.19f, 0.19f, 0.21f));
		MATERIAL_MAP.put(MT.Bronze, new Values(MT.Bronze, 160, 0.13f, 0.13f, 0.12f, 0.12f, 0.13f));
		MATERIAL_MAP.put(MT.CobaltBrass, new Values(MT.CobaltBrass, 180, 0.15f, 0.15f, 0.14f, 0.14f, 0.15f));
		MATERIAL_MAP.put(MT.DamascusSteel, new Values(MT.DamascusSteel, 200, 0.22f, 0.22f, 0.20f, 0.20f, 0.22f));
		MATERIAL_MAP.put(MT.Electrum, new Values(MT.Electrum, 250, 0.11f, 0.11f, 0.10f, 0.10f, 0.11f));
		MATERIAL_MAP.put(MT.Emerald, new Values(MT.Emerald, 160, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.Gold, new Values(MT.Gold, 300, 0.09f, 0.09f, 0.05f, 0.25f, 0.09f));
		MATERIAL_MAP.put(MT.GreenSapphire, new Values(MT.GreenSapphire, 160, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.Invar, new Values(MT.Invar, 190, 0.10f, 0.10f, 0.22f, 0.22f, 0.10f));
		MATERIAL_MAP.put(MT.Iron, new Values(MT.Iron, 200, 0.12f, 0.12f, 0.10f, 0.10f, 0.12f));
		MATERIAL_MAP.put(MT.IronWood, new Values(MT.IronWood, 150, 0.17f, 0.17f, 0.02f, 0.02f, 0.17f));
		MATERIAL_MAP.put(MT.Magnalium, new Values(MT.Magnalium, 120, 0.15f, 0.15f, 0.17f, 0.17f, 0.15f));
		MATERIAL_MAP.put(MT.NeodymiumMagnetic, new Values(MT.NeodymiumMagnetic, 220, 0.14f, 0.14f, 0.14f, 0.14f, 0.14f));
		MATERIAL_MAP.put(MT.Manganese, new Values(MT.Manganese, 180, 0.15f, 0.15f, 0.14f, 0.14f, 0.15f));
		MATERIAL_MAP.put(MT.MeteoricIron, new Values(MT.MeteoricIron, 200, 0.18f, 0.18f, 0.16f, 0.16f, 0.18f));
		MATERIAL_MAP.put(MT.MeteoricSteel, new Values(MT.MeteoricSteel, 200, 0.21f, 0.21f, 0.19f, 0.19f, 0.21f));
		MATERIAL_MAP.put(MT.Molybdenum, new Values(MT.Molybdenum, 140, 0.14f, 0.14f, 0.14f, 0.14f, 0.14f));
		MATERIAL_MAP.put(MT.Nickel, new Values(MT.Nickel, 180, 0.12f, 0.12f, 0.15f, 0.15f, 0.12f));
		MATERIAL_MAP.put(MT.Olivine, new Values(MT.Olivine, 180, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.Opal, new Values(MT.Opal, 180, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.Palladium, new Values(MT.Palladium, 280, 0.14f, 0.14f, 0.12f, 0.12f, 0.14f));
		MATERIAL_MAP.put(MT.Platinum, new Values(MT.Platinum, 290, 0.15f, 0.15f, 0.13f, 0.13f, 0.15f));
		MATERIAL_MAP.put(MT.GarnetRed, new Values(MT.GarnetRed, 180, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.RedSteel, new Values(MT.RedSteel, 200, 0.20f, 0.20f, 0.18f, 0.18f, 0.20f));
		MATERIAL_MAP.put(MT.RoseGold, new Values(MT.RoseGold, 240, 0.10f, 0.10f, 0.08f, 0.18f, 0.10f));
		MATERIAL_MAP.put(MT.Ruby, new Values(MT.Ruby, 180, 0.10f, 0.10f, 0.20f, 0.20f, 0.10f));
		MATERIAL_MAP.put(MT.Sapphire, new Values(MT.Sapphire, 180, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.Silver, new Values(MT.Silver, 220, 0.11f, 0.11f, 0.07f, 0.24f, 0.11f));
		MATERIAL_MAP.put(MT.StainlessSteel, new Values(MT.StainlessSteel, 200, 0.16f, 0.16f, 0.21f, 0.21f, 0.16f));
		MATERIAL_MAP.put(MT.Steel, new Values(MT.Steel, 200, 0.18f, 0.18f, 0.16f, 0.16f, 0.18f));
		MATERIAL_MAP.put(MT.SterlingSilver, new Values(MT.SterlingSilver, 210, 0.15f, 0.15f, 0.13f, 0.13f, 0.15f));
		MATERIAL_MAP.put(MT.Tanzanite, new Values(MT.Tanzanite, 180, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.Thorium, new Values(MT.Thorium, 280, 0.13f, 0.13f, 0.16f, 0.16f, 0.13f));
		MATERIAL_MAP.put(MT.WroughtIron, new Values(MT.WroughtIron, 200, 0.14f, 0.14f, 0.12f, 0.12f, 0.14f));
		MATERIAL_MAP.put(MT.GarnetYellow, new Values(MT.GarnetYellow, 180, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.Carbon, new Values(MT.Carbon, 60, 0.06f, 0.23f, 0.05f, 0.05f, 0.06f));
		MATERIAL_MAP.put(MT.InfusedAir,new Values(MT.InfusedAir, 10, 0.10f, 0.10f, 0.10f,0.10f, 0.10f));
		MATERIAL_MAP.put(MT.Amethyst, new Values(MT.Amethyst, 180, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.InfusedWater,new Values(MT.InfusedWater, 150, 0.10f, 0.10f,0.20f, 0.20f, 0.10f));
		MATERIAL_MAP.put(MT.BlueTopaz, new Values(MT.BlueTopaz, 180, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.Chrome, new Values(MT.Chrome, 200, 0.12f, 0.12f, 0.21f, 0.21f, 0.12f));
		MATERIAL_MAP.put(MT.Cobalt, new Values(MT.Cobalt, 220, 0.16f, 0.16f, 0.14f, 0.14f, 0.16f));
		MATERIAL_MAP.put(MT.DarkIron, new Values(MT.DarkIron, 200, 0.21f, 0.21f, 0.19f, 0.19f, 0.21f));
		MATERIAL_MAP.put(MT.Diamond, new Values(MT.Diamond, 200, 0.20f, 0.20f, 0.22f, 0.22f, 0.20f));
		MATERIAL_MAP.put(MT.Enderium, new Values(MT.Enderium, 250, 0.22f, 0.22f, 0.21f, 0.21f, 0.22f));
		MATERIAL_MAP.put(MT.ElectrumFlux,new Values(MT.ElectrumFlux, 180, 0.19f, 0.19f, 0.16f, 0.16f, 0.19f));
		MATERIAL_MAP.put(MT.Force, new Values(MT.Force, 180, 0.10f, 0.10f, 0.20f, 0.20f, 0.10f));
		MATERIAL_MAP.put(MT.HSLA, new Values(MT.HSLA, 200, 0.21f, 0.21f, 0.17f, 0.17f, 0.21f));
		MATERIAL_MAP.put(MT.InfusedFire,new Values(MT.InfusedFire, 150, 0.12f, 0.10f, 0.30f, 0.30f, 0.12f));
		MATERIAL_MAP.put(MT.InfusedGold, new Values(MT.InfusedGold, 300, 0.15f, 0.15f, 0.05f, 0.05f, 0.15f));
		MATERIAL_MAP.put(MT.Mithril, new Values(MT.Mithril, 200, 0.25f, 0.25f, 0.10f, 0.30f, 0.25f));
		MATERIAL_MAP.put(MT.InfusedOrder,new Values(MT.InfusedOrder, 150, 0.18f, 0.22f,0.22f, 0.25f, 0.22f));
		MATERIAL_MAP.put(MT.Steeleaf, new Values(MT.Steeleaf, 120, 0.16f, 0.16f, 0.06f, 0.06f, 0.16f));
		MATERIAL_MAP.put(MT.InfusedEarth,new Values(MT.InfusedEarth, 350, 0.30f, 0.30f,0.30f, 0.30f, 0.30f));
		MATERIAL_MAP.put(MT.Thaumium, new Values(MT.Thaumium, 200, 0.18f, 0.19f, 0.20f, 0.30f, 0.18f));
		MATERIAL_MAP.put(MT.Titanium, new Values(MT.Titanium, 140, 0.20f, 0.20f, 0.18f, 0.18f, 0.20f));
		MATERIAL_MAP.put(MT.Tungsten, new Values(MT.Tungsten, 270, 0.27f, 0.26f, 0.23f, 0.26f, 0.26f));
		MATERIAL_MAP.put(MT.Topaz, new Values(MT.Topaz, 180, 0.10f, 0.10f, 0.14f, 0.14f, 0.10f));
		MATERIAL_MAP.put(MT.Ultimet, new Values(MT.Ultimet, 180, 0.21f, 0.21f, 0.19f, 0.19f, 0.21f));
		MATERIAL_MAP.put(MT.Uranium238, new Values(MT.Uranium238, 290, 0.27f, 0.23f, 0.20f, 0.15f, 0.21f));
		MATERIAL_MAP.put(MT.Vinteum, new Values(MT.Vinteum, 180, 0.10f, 0.12f, 0.14f, 0.28f, 0.12f));
		MATERIAL_MAP.put(MT.Duranium, new Values(MT.Duranium, 140, 0.24f, 0.24f, 0.24f, 0.24f, 0.24f));
		MATERIAL_MAP.put(MT.Iridium, new Values(MT.Iridium, 220, 0.24f, 0.24f, 0.22f, 0.22f, 0.24f));
		MATERIAL_MAP.put(MT.Osmiridium, new Values(MT.Osmiridium, 240, 0.18f, 0.18f, 0.16f, 0.16f, 0.18f));
		MATERIAL_MAP.put(MT.Osmium, new Values(MT.Osmium, 250, 0.12f, 0.12f, 0.10f, 0.10f, 0.12f));
		MATERIAL_MAP.put(MT.Naquadah, new Values(MT.Naquadah, 250, 0.27f, 0.27f, 0.25f, 0.25f, 0.27f));
		MATERIAL_MAP.put(MT.NetherStar, new Values(MT.NetherStar, 140, 0.22f, 0.22f, 0.24f, 0.24f, 0.22f));
		MATERIAL_MAP.put(MT.InfusedEntropy,new Values(MT.InfusedEntropy, 150, 0.10f, 0.10f,0.10f, 0.10f, 0.10f));
		MATERIAL_MAP.put(MT.Tritanium, new Values(MT.Tritanium, 140, 0.26f, 0.26f, 0.26f, 0.26f, 0.26f));
		MATERIAL_MAP.put(MT.TungstenSteel, new Values(MT.TungstenSteel, 270, 0.30f, 0.28f, 0.25f, 0.28f, 0.30f));
		MATERIAL_MAP.put(MT.Adamantium, new Values(MT.Adamantium, 200, 0.28f, 0.28f, 0.26f, 0.30f, 0.30f));
		MATERIAL_MAP.put(MT.NaquadahAlloy, new Values(MT.NaquadahAlloy, 300, 0.33f, 0.33f, 0.33f, 0.33f, 0.33f));
		MATERIAL_MAP.put(MT.Neutronium, new Values(MT.Neutronium, 600, 0.50f, 0.50f, 0.50f, 0.50f, 0.50f));
	}

	public Values getValues(OreDictMaterial mat) {
		Values tmp = MATERIAL_MAP.get(mat);

		if (tmp == null) {
			return MATERIAL_MAP.get(MT.NULL);
		}
		return tmp;
	}
}
