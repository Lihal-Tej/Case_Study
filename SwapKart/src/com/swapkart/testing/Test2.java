package com.swapkart.testing;

import java.util.HashMap;

import com.google.gson.Gson;

public class Test2 {
	
	public static void main(String[] args) {
		
		new Test2().doParse();
	}

	/**
	 * 
	 */
	private void doParse() {
		
		HashMap<String, HashMap<String,String>> specs = new HashMap<>();
		
		HashMap<String , String> general = new HashMap<>();
		general.put("In The Box", "\r\n" + 
				"Handset, Travel Adapter, Data Cable, Stereo Headset, Ejection Pin, Case, USB Connector, User Manual");
		general.put("Model Number", "SM-G965FDINS45");
		general.put("Model Name","Galaxy S9 Plus");
		general.put("Color ","Polaris Blue");
		general.put("Browse Type ", "Smart Phones");
		general.put("Sim-Type", "Dual");
		general.put("Hybrid Sim Slot ", "Yes");
		general.put("Touch Screen ", "Yes");
		general.put("OTG Compatable", "Yes");
		
		specs.put("General", general);
		
		HashMap<String , String> displayFeatures = new HashMap<>();
		
		displayFeatures.put("Display Size","6.2 inch");
		displayFeatures.put("Resolution", "2960 x 1460 Pixels");
		displayFeatures.put("Resolution Type", "Quad HD+");
		displayFeatures.put("GPU", "ARM MP18");
		displayFeatures.put("Display Type ","Super AMOLED");
		displayFeatures.putIfAbsent("displayColors", "16m");
		
		specs.put("Display Features", displayFeatures);
		
		
		HashMap<String , String>  osProcessFeatures = new HashMap<>();
		osProcessFeatures.put("Operating System", "Android 8.0 Oreo");
		osProcessFeatures.put("Processor Type", "EXYNOS 9810");
		osProcessFeatures.put("Process Core","Octa Core");
		osProcessFeatures.put("Primary Clock Speed", "2.7GHZ");
		osProcessFeatures.put("Secondary Clock Speed ", "1.7 GHZ");
		
		specs.put("Os Process Features", osProcessFeatures);
		
		HashMap<String , String> memoryStorageFeatures = new HashMap<>();
		
		memoryStorageFeatures.put("Internal Storage", "64Gb");
		memoryStorageFeatures.put("RAM", "6GB");
		memoryStorageFeatures.put("Expandable Storage", "400GB");
		memoryStorageFeatures.put("Supported Memory Card Type  ", "Micro SD");
		memoryStorageFeatures.put("Memory Card Slot Type", "Hybrid Slot");
		
		specs.put("Memory Storage Features", memoryStorageFeatures);
		
		HashMap<String , String> cameraFeatures = new HashMap<>();
		
		cameraFeatures.put("Primary Camera Avialable", "Yes");
		cameraFeatures.put("Primary Camera", "12MP + 12MP");
		cameraFeatures.put("Optical Zoom", "Yess");
		cameraFeatures.putIfAbsent("Secondary Camera Available", "Yes");
		cameraFeatures.put("Secondary Camera", "8MP");
		cameraFeatures.put("Full HD Recording", "Yess");
		cameraFeatures.put("Video Recording", "Yess");
		cameraFeatures.put("Camera Recording", "Yess");
		
		specs.put("Camera Features", cameraFeatures);
		HashMap<String , String> connectivityFeatures = new HashMap<>();
		
		connectivityFeatures.put("Network Type", "4G,3G,2G");
		connectivityFeatures.put("3G", "Yess");
		connectivityFeatures.put("Blueetooth Supported", "Yess");
		connectivityFeatures.put("Blueetooth Version", "5");
		connectivityFeatures.put("Wifi", "Yess");
		connectivityFeatures.put("NFC", "Yess");
		
		specs.put("Conectivity Features", connectivityFeatures);
		
		HashMap<String , String> otherDetails = new HashMap<>();
		
		otherDetails.put("SmartPhone","Yess");
		otherDetails.put("Sim Size","Nano Size");
		otherDetails.put("Removal Battery","No");
		otherDetails.put("Graphics PPI","529 PPI");
		
		specs.put("Other Details", otherDetails);
		
		HashMap<String , String> multiMediaFeatures= new HashMap<>();
		
		multiMediaFeatures.put("Audio Formats", "\r\n" + 
				"MP3, M4A, 3GA, AAC, OGG, OGA, WAV, WMA, AMR, AWB, FLAC, MID, MIDI, XMF, MXMF, IMY, RTTTL, RTX, OTA, DFF, DSF, APE");
		multiMediaFeatures.put("Video Formats", "\r\n" + 
				"MP4, M4V, 3GP, 3G2, WMV, ASF, AVI, FLV, MKV, WEBM");
		
		specs.put("MultiMedia Features", multiMediaFeatures);
		
		HashMap<String , String> batteryPowerFeatures= new HashMap<>();
		
		batteryPowerFeatures.put("Battery", "3500 mAh");
		specs.put("Battery Power Features",batteryPowerFeatures);
		
		HashMap<String , String> dimensions= new HashMap<>();
		
		dimensions.put("Width", "73.88 mm");
		dimensions.put("Height", "158.1 mm");
		
		dimensions.put("Depth", "8.5 mm");
		dimensions.put("Weight", "189 g");
		
		specs.put("Dimensions", dimensions);
		
		HashMap<String, String> warranty = new HashMap<>();
		 warranty.put("Warranty Summary", "Brand Warranty of 1 Year Available");
		 
		specs.put("Warranty", warranty);
		
		
		Gson gson = new Gson();
		String result = gson.toJson(specs);
		
		System.out.println(result);
		
		
		
		
		
		
		
		
		
		
		
	}

}
