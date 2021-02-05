package genelectrovise.hypixel.skyblock.stockanalyser.network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import genelectrovise.hypixel.skyblock.stockanalyser.StockAnalyser;
import vision.voltsofdoom.zapbyte.main.ZapByteReference;

public class KeyRing {

	public static UUID apiKey;

	public static void fetchApiKey() {

		try {

			// Get file
			File apiKeyFile = new File(ZapByteReference.getConfig() + "keyring.json");

			// Make sure it exists
			if (!apiKeyFile.exists()) {
				FileWriter writer = new FileWriter(apiKeyFile);
				writer.write("{'apiKey':'none'}");
				writer.flush();
				writer.close();
				StockAnalyser.LOGGER.info("Written NEW keyring.json");
			}

			// Read the contents
			FileReader fileReader = new FileReader(apiKeyFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Stream<String> lines = bufferedReader.lines();

			// Contents -> String
			List<String> contentsList = new ArrayList<String>();
			lines.forEach((line) -> {
				contentsList.add(line);
			});
			fileReader.close();
			bufferedReader.close();

			String contents = "";
			for (String string : contentsList) {
				contents = contents + string;
			}

			StockAnalyser.LOGGER.info("Found keyring: " + contents);

			// Parse to get value
			Gson gson = new Gson();
			JsonObject object = gson.fromJson(contents, JsonObject.class);
			String key = object.get("apiKey").getAsString();

			if (key.equals("none")) {
				throw new IllegalStateException(
						"No key set! (apiKey:none) Go to mc.hypixel.net, run /api, then paste that into "
								+ ZapByteReference.getConfig() + "keyring.json in the apiKey field.");
			}

			// Return
			apiKey = UUID.fromString(key);
			StockAnalyser.LOGGER.info("Derived apiKey UUID {" + apiKey + "} from string {" + key + "}");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
