package bloodasp.gregtechextras;

import static gregapi.data.CS.U;
import static gregapi.data.MT.*;
import net.minecraft.enchantment.Enchantment;
import gregapi.data.MT;
import gregapi.data.TC;
import static gregapi.data.TD.Compounds.ALLOY;
import static gregapi.data.TD.Compounds.DECOMPOSABLE;
import static gregapi.data.TD.ItemGenerator.G_INGOT;
import static gregapi.data.TD.ItemGenerator.G_INGOT_MACHINE;
import static gregapi.data.TD.Processing.*;
import gregapi.oredict.OreDictMaterial;
import static gregapi.render.TextureSet.*;

public class Materials {

	public static final OreDictMaterial TungstenCarbide = registerNewMaterial(OreDictMaterial.createMaterial(20000, "tungstencarbide", "Tungstencarbide")).setRGBa(80, 80, 120, 255).setQuality(14.0F, 1280, 4).setMcfg(0, Carbon, 1 * U, W, 1 * U).setEnchantmentForTools(Enchantment.sharpness, 5),
										VanadiumSteel = registerNewMaterial(OreDictMaterial.createMaterial(20001, "vanadiumsteel", "Vanadium Steel")).setRGBa(80, 80, 120, 255).setQuality(3.0F, 1920, 3).setMcfg(0, Vanadium, 1 * U, Chrome, 1 * U, Steel, 7*U),
										HSSG = registerNewMaterial(OreDictMaterial.createMaterial(20002, "hssg", "HSS-G")).setRGBa(80, 80, 120, 255).setQuality(10.0F, 4000, 3).setMcfg(0, TungstenSteel, 5 * U, Chrome, 1 * U, Molybdenum, 2 * U, Vanadium, 1 * U),
										HSSE = registerNewMaterial(OreDictMaterial.createMaterial(20003, "hsse", "HSS-E")).setRGBa(80, 80, 120, 255).setQuality(10.0F, 5120, 4).setMcfg(0, HSSG, 6 * U, Cobalt, 1 * U, Manganese, 1 * U, Silicon, 1 * U),
										HSSS = registerNewMaterial(OreDictMaterial.createMaterial(20004, "hsss", "HSS-S")).setRGBa(80, 80, 120, 255).setQuality(14.0F, 3000, 4).setMcfg(0, HSSG, 6 * U, Iridium, 2 * U, Osmium, 1 * U),
										
										HardenedIron = registerNewMaterial(OreDictMaterial.createMaterial(20005, "hardenediron", "Hardened Iron")).steal(MT.Iron).setAllToTheOutputOf(MT.Iron).setQuality(7.0F,308,2),
										HardenedWroughtIron = registerNewMaterial(OreDictMaterial.createMaterial(20006, "hardenedwroughtiron", "Hardened Wrought Iron")).steal(MT.WroughtIron).setAllToTheOutputOf(MT.WroughtIron).setQuality(7.0F,460,2),
										HardenedSteel = registerNewMaterial(OreDictMaterial.createMaterial(20007, "hardenedsteel", "Hardened Steel")).steal(MT.Steel).setAllToTheOutputOf(MT.Steel).setQuality(7.0F,614,2),
										HardenedBlackSteel = registerNewMaterial(OreDictMaterial.createMaterial(20008, "Hardened Black Steel", "Hardened Black Steel")).steal(MT.BlackSteel).setAllToTheOutputOf(MT.BlackSteel).setQuality(7.5F,921,2),
										HardenedRedSteel = registerNewMaterial(OreDictMaterial.createMaterial(20009, "Hardened Red Steel", "Hardened Red Steel")).steal(MT.RedSteel).setAllToTheOutputOf(MT.RedSteel).setQuality(8.0F,1075,2),
										HardenedBlueSteel = registerNewMaterial(OreDictMaterial.createMaterial(20010, "Hardened Blue Steel", "Hardened Blue Steel")).steal(MT.BlueSteel).setAllToTheOutputOf(MT.BlueSteel).setQuality(8.5F,1228,2),
										HardenedTitanium = registerNewMaterial(OreDictMaterial.createMaterial(200011, "Hardened Titanium", "Hardened Titanium")).steal(MT.Titanium).setAllToTheOutputOf(MT.Titanium).setQuality(9.0F,1920,3),
										HardenedIridium = registerNewMaterial(OreDictMaterial.createMaterial(200012, "Hardened Iridium", "Hardened Iridium")).steal(MT.Iridium).setAllToTheOutputOf(MT.Iridium).setQuality(7.0F, 3072, 3),
										HardenedOsmiridium = registerNewMaterial(OreDictMaterial.createMaterial(20013, "Hardened Osmiridium", "Hardened Osmiridium")).steal(MT.Osmiridium).setAllToTheOutputOf(MT.Osmiridium).setQuality(8.0F, 1920, 4),
										HardenedTungsten = registerNewMaterial(OreDictMaterial.createMaterial(20014, "Hardened Tungsten", "Hardened Tungsten")).steal(MT.Tungsten).setAllToTheOutputOf(MT.Tungsten).setQuality(8.0F, 3072, 3),
										HardenedTungstenSteel = registerNewMaterial(OreDictMaterial.createMaterial(20015, "Hardened Tungsten Steel", "Hardened Tungsten Steel")).steal(MT.TungstenSteel).setAllToTheOutputOf(MT.TungstenSteel).setQuality(9.0F, 3072, 4),
										HardenedTungstenCarbide = registerNewMaterial(OreDictMaterial.createMaterial(20016, "Hardened Tungstencarbide", "Hardened Tungstencarbide")).steal(TungstenCarbide).setAllToTheOutputOf(TungstenCarbide).setQuality(15.0F, 1536, 4),
										HardenedVanadiumSteel = registerNewMaterial(OreDictMaterial.createMaterial(20017, "Hardened Vanadium Steel", "Hardened Vanadium Steel")).steal(VanadiumSteel).setAllToTheOutputOf(VanadiumSteel).setQuality(4.0F, 2304, 3),
										HardenedHSSG = registerNewMaterial(OreDictMaterial.createMaterial(20018, "hardenedhssg", "Hardened HSS-G")).steal(HSSG).setAllToTheOutputOf(HSSG).setQuality(11.0F, 5000, 3),
										HardenedHSSE = registerNewMaterial(OreDictMaterial.createMaterial(20019, "hardenedhsse", "Hardened HSS-E")).steal(HSSE).setAllToTheOutputOf(HSSE).setQuality(11.0F, 6144, 4),
										HardenedHSSS = registerNewMaterial(OreDictMaterial.createMaterial(20020, "hardenedhsss", "Hardened HSS-S")).steal(HSSS).setAllToTheOutputOf(HSSS).setQuality(15.0F, 3600, 4),
										
										NitridedIron = registerNewMaterial(OreDictMaterial.createMaterial(20021, "nitridediron", "Nitrided Iron")).steal(MT.Iron).setAllToTheOutputOf(MT.Iron).setQuality(8.0F,332,2),
										NitridedWroughtIron = registerNewMaterial(OreDictMaterial.createMaterial(20022, "nitridedwroughtiron", "Nitrided Wrought Iron")).steal(MT.WroughtIron).setAllToTheOutputOf(MT.WroughtIron).setQuality(8.0F,500,2),
										NitridedSteel = registerNewMaterial(OreDictMaterial.createMaterial(20023, "nitridedsteel", "Nitrided Steel")).steal(MT.Steel).setAllToTheOutputOf(MT.Steel).setQuality(8.0F,665,2),
										NitridedBlackSteel = registerNewMaterial(OreDictMaterial.createMaterial(20024, "nitridedblacksteel", "Nitrided Black Steel")).steal(MT.BlackSteel).setAllToTheOutputOf(MT.BlackSteel).setQuality(8.5F,998,2),
										NitridedRedSteel = registerNewMaterial(OreDictMaterial.createMaterial(20025, "nitridedredsteel", "Nitrided Red Steel")).steal(MT.RedSteel).setAllToTheOutputOf(MT.RedSteel).setQuality(9.0F,1164,2),
										NitridedBlueSteel = registerNewMaterial(OreDictMaterial.createMaterial(20026, "nitridedbluesteel", "Nitrided Blue Steel")).steal(MT.BlueSteel).setAllToTheOutputOf(MT.BlueSteel).setQuality(9.5F,1330,2),
										NitridedTitanium = registerNewMaterial(OreDictMaterial.createMaterial(20027, "nitridedtitanium", "Nitrided Titanium")).steal(MT.Titanium).setAllToTheOutputOf(MT.Titanium).setQuality(10.0F,1600,3),
										NitridedIridium = registerNewMaterial(OreDictMaterial.createMaterial(20028, "nitridediridium", "Nitrided Iridium")).steal(MT.Iridium).setAllToTheOutputOf(MT.Iridium).setQuality(8.0F, 3320, 3),
										NitridedOsmiridium = registerNewMaterial(OreDictMaterial.createMaterial(20029, "nitridedosmiridium", "Nitrided Osmiridium")).steal(MT.Osmiridium).setAllToTheOutputOf(MT.Osmiridium).setQuality(9.0F, 2080, 4),
										NitridedTungsten = registerNewMaterial(OreDictMaterial.createMaterial(20030, "nitridedtungsten", "Nitrided Tungsten")).steal(MT.Tungsten).setAllToTheOutputOf(MT.Tungsten).setQuality(9.0F, 3320, 3),
										NitridedTungstenSteel = registerNewMaterial(OreDictMaterial.createMaterial(20031, "nitridedtungstensteel", "Nitrided Tungsten Steel")).steal(MT.TungstenSteel).setAllToTheOutputOf(MT.TungstenSteel).setQuality(10.0F, 3320, 4),
										NitridedTungstenCarbide = registerNewMaterial(OreDictMaterial.createMaterial(20032, "nitridedtungstencarbide", "Nitrided Tungstencarbide")).steal(TungstenCarbide).setAllToTheOutputOf(TungstenCarbide).setQuality(16.0F, 1664, 4),
										NitridedVanadiumSteel = registerNewMaterial(OreDictMaterial.createMaterial(20033, "nitridedvanadiumsteel", "Nitrided Vanadium Steel")).steal(VanadiumSteel).setAllToTheOutputOf(VanadiumSteel).setQuality(5.0F, 2496, 3),
										NitridedHSSG = registerNewMaterial(OreDictMaterial.createMaterial(20034, "nitridedhssg", "Nitrided HSS-G")).steal(HSSG).setAllToTheOutputOf(HSSG).setQuality(12.0F, 5200, 3),
										NitridedHSSE = registerNewMaterial(OreDictMaterial.createMaterial(20035, "nitridedhsse", "Nitrided HSS-E")).steal(HSSE).setAllToTheOutputOf(HSSE).setQuality(12.0F, 6650, 4),
										NitridedHSSS = registerNewMaterial(OreDictMaterial.createMaterial(20036, "nitridedhsss", "Nitrided HSS-S")).steal(HSSS).setAllToTheOutputOf(HSSS).setQuality(16.0F, 3900, 4),
										
										PolycrystalIron = registerNewMaterial(OreDictMaterial.createMaterial(20037, "polycrystaliron", "Polycrystal Iron")).steal(MT.Iron).setAllToTheOutputOf(MT.Iron).setQuality(11.0F,384,3),
										PolycrystalWroughtIron = registerNewMaterial(OreDictMaterial.createMaterial(20038, "polycrystalwroughtiron", "Polycrystal Wrought Iron")).steal(MT.WroughtIron).setAllToTheOutputOf(MT.WroughtIron).setQuality(11.0F,576,3),
										PolycrystalSteel = registerNewMaterial(OreDictMaterial.createMaterial(20039, "polycrystalsteel", "Polycrystal Steel")).steal(MT.Steel).setAllToTheOutputOf(MT.Steel).setQuality(11.0F,768,3),
										PolycrystalBlackSteel = registerNewMaterial(OreDictMaterial.createMaterial(20040, "polycrystalblacksteel", "Polycrystal Black Steel")).steal(MT.BlackSteel).setAllToTheOutputOf(MT.BlackSteel).setQuality(11.5F,1152,3),
										PolycrystalRedSteel = registerNewMaterial(OreDictMaterial.createMaterial(20041, "polycrystalredsteel", "Polycrystal Red Steel")).steal(MT.RedSteel).setAllToTheOutputOf(MT.RedSteel).setQuality(12.0F,1344,3),
										PolycrystalBlueSteel = registerNewMaterial(OreDictMaterial.createMaterial(20042, "polycrystalbluesteel", "Polycrystal Blue Steel")).steal(MT.BlueSteel).setAllToTheOutputOf(MT.BlueSteel).setQuality(12.5F,1536,3),
										PolycrystalTitanium = registerNewMaterial(OreDictMaterial.createMaterial(20043, "polycrystaltitanium", "Polycrystal Titanium")).steal(MT.Titanium).setAllToTheOutputOf(MT.Titanium).setQuality(13.0F,2400,4),
										PolycrystalIridium = registerNewMaterial(OreDictMaterial.createMaterial(20044, "polycrystaliridium", "Polycrystal Iridium")).steal(MT.Iridium).setAllToTheOutputOf(MT.Iridium).setQuality(11.0F, 3840, 4),
										PolycrystalOsmiridium = registerNewMaterial(OreDictMaterial.createMaterial(20045, "polycrystalosmiridium", "Polycrystal Osmiridium")).steal(MT.Osmiridium).setAllToTheOutputOf(MT.Osmiridium).setQuality(12.0F, 2400, 5),
										PolycrystalTungsten = registerNewMaterial(OreDictMaterial.createMaterial(20046, "polycrystaltungsten", "Polycrystal Tungsten")).steal(MT.Tungsten).setAllToTheOutputOf(MT.Tungsten).setQuality(12.0F, 3840, 4),
										PolycrystalTungstenSteel = registerNewMaterial(OreDictMaterial.createMaterial(20047, "polycrystaltungstensteel", "Polycrystal Tungsten Steel")).steal(MT.TungstenSteel).setAllToTheOutputOf(MT.TungstenSteel).setQuality(13.0F, 3840, 5),
										PolycrystalTungstenCarbide = registerNewMaterial(OreDictMaterial.createMaterial(20048, "polycrystaltungstencarbide", "Polycrystal Tungstencarbide")).steal(TungstenCarbide).setAllToTheOutputOf(TungstenCarbide).setQuality(19.0F, 1920, 5),
										PolycrystalVanadiumSteel = registerNewMaterial(OreDictMaterial.createMaterial(20049, "polycrystalvanadiumsteel", "Polycrystal Vanadium Steel")).steal(VanadiumSteel).setAllToTheOutputOf(VanadiumSteel).setQuality(8.0F, 2880, 4),
										PolycrystalHSSG = registerNewMaterial(OreDictMaterial.createMaterial(20050, "polycrystalhssg", "Polycrystal HSS-G")).steal(HSSG).setAllToTheOutputOf(HSSG).setQuality(15.0F, 6000, 4),
										PolycrystalHSSE = registerNewMaterial(OreDictMaterial.createMaterial(20051, "polycrystalhsse", "Polycrystal HSS-E")).steal(HSSE).setAllToTheOutputOf(HSSE).setQuality(15.0F, 5120, 5),
										PolycrystalHSSS = registerNewMaterial(OreDictMaterial.createMaterial(20052, "polycrystalhsss", "Polycrystal HSS-S")).steal(HSSS).setAllToTheOutputOf(HSSS).setQuality(19.0F, 4500, 5);
	
	
	public static OreDictMaterial registerMaterial(OreDictMaterial material) {
		ALL_MATERIALS_REGISTERED_HERE.add(material);
		return material;
	}

	public static OreDictMaterial registerNewMaterial(OreDictMaterial material) {
		return registerMaterial(material).add(ALLOY, DECOMPOSABLE).add(G_INGOT_MACHINE).add(G_INGOT, SMITHABLE, MELTING).setTextures(SET_METALLIC).add(CENTRIFUGE);
	}

	public static OreDictMaterial registerHardendMaterial(OreDictMaterial material) {
		return registerMaterial(material).setAllToTheOutputOf(MT.Steel);
	}

	public static void preLoad() {
		Titanium.setQuality(7.0F, 1600, 3);
		Tungsten.setQuality(7.0F, 2560, 3);
		Iridium.setQuality(6.0F, 2560, 3);
		Osmiridium.setQuality(7.0F, 1600, 4);
		TungstenSteel.setQuality(8.0F, 2560, 4);
	}
}
