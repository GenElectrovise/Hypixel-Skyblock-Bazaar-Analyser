package genelectrovise.hypixel.skyblock.stockanalyser;

import genelectrovise.hypixel.skyblock.stockanalyser.display.WindowManager;
import genelectrovise.hypixel.skyblock.stockanalyser.network.KeyRing;
import vision.voltsofdoom.zapbyte.main.ZapBit;

public class ZapBits {
	public static final ZapBit GET_API_KEY_10 = new ZapBit(10, () -> {
		KeyRing.fetchApiKey();
	});
	public static final ZapBit CREATE_WINDOW_20 = new ZapBit(20, () -> {
		StockAnalyser.windowManager = new WindowManager();
		StockAnalyser.windowManager.start();
	});
}
