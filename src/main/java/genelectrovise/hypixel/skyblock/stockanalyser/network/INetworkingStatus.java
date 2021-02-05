package genelectrovise.hypixel.skyblock.stockanalyser.network;

public interface INetworkingStatus {
	String name();

	public static final INetworkingStatus IDLE = new INetworkingStatus() {
		@Override
		public String name() {
			return "IDLE";
		}
	};
	public static final INetworkingStatus WAITING = new INetworkingStatus() {
		@Override
		public String name() {
			return "WAITING";
		}
	};
	public static final INetworkingStatus QUERYING = new INetworkingStatus() {
		@Override
		public String name() {
			return "QUERYING";
		}
	};
}
