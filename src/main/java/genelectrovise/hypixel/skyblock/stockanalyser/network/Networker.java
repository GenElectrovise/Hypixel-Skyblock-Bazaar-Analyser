package genelectrovise.hypixel.skyblock.stockanalyser.network;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import net.hypixel.api.HypixelAPI;
import net.hypixel.api.reply.skyblock.BazaarReply;
import net.hypixel.api.reply.skyblock.BazaarReply.Product;

public class Networker {

	private final HypixelAPI api = new HypixelAPI(KeyRing.apiKey);

	public INetworkingStatus status = INetworkingStatus.IDLE;
	
	public Map<String, Product> latestProducts = new HashMap<String, BazaarReply.Product>();

	public void updateProducts() {
		
		setStatus(INetworkingStatus.QUERYING);
		
		try {
			
			CompletableFuture<BazaarReply> requestedReply = api.getBazaar();
			setStatus(INetworkingStatus.WAITING);
			BazaarReply completedReply = requestedReply.get();
			latestProducts = completedReply.getProducts();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setStatus(INetworkingStatus status) {
		this.status = status;
	}

}
