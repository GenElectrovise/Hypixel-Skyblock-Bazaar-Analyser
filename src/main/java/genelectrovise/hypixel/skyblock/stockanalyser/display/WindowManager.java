package genelectrovise.hypixel.skyblock.stockanalyser.display;

import genelectrovise.hypixel.skyblock.stockanalyser.StockAnalyser;

public class WindowManager {
	private final Window window;
	private boolean running = false;

	public WindowManager() {
		this.window = new Window();
	}

	public void start() {

		if (isRunning()) {
			throw new IllegalStateException("Cannot run window twice!");
		}

		setRunning(true);
		
		window.doWindow();
		StockAnalyser.networker.updateProducts();
		fromSystem();
	}

	public boolean isRunning() {
		return running;
	}

	public Window getWindow() {
		return window;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void fromSystem() {
		System.out.println(StockAnalyser.networker.latestProducts);
	}
}
