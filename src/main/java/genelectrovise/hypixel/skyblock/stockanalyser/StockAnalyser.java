package genelectrovise.hypixel.skyblock.stockanalyser;

import genelectrovise.hypixel.skyblock.stockanalyser.display.WindowManager;
import genelectrovise.hypixel.skyblock.stockanalyser.logic.TickManager;
import genelectrovise.hypixel.skyblock.stockanalyser.network.Networker;
import vision.voltsofdoom.zapbyte.main.ZapByte;

public class StockAnalyser extends ZapByte {

	public static final String ID = "hypixelstockanalyser";
	public static WindowManager windowManager = new WindowManager();
	public static TickManager tickManager = new TickManager();
	public static Networker networker = new Networker();

	public static void main(String[] args) {
		StockAnalyser analyser = new StockAnalyser();

		analyser.run();
	}

	public StockAnalyser() {
		super(ID);
	}

	@Override
	public void collectZapbits() {
		addZapBit(ZapBits.GET_API_KEY_10);
	}

	@Override
	public void continueExecution() {
		windowManager.start();

		while (windowManager.isRunning()) {
			tickManager.tick();
		}
	}
}
