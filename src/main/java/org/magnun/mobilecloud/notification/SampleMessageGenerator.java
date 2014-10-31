package org.magnun.mobilecloud.notification;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SampleMessageGenerator {
	
	/*
	 * This message is delivered if a platform specific message is not specified
	 * for the end point. It must be set. It is received by the device as the
	 * value of the key "default".
	 */
	public static final String defaultMessage = "This is the default message";

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static enum Platform {
		// Apple Push Notification Service
		APNS,
		// Sandbox version of Apple Push Notification Service
		APNS_SANDBOX,
		// Amazon Device Messaging
		ADM,
		// Google Cloud Messaging
		GCM,
		// Baidu CloudMessaging Service
		BAIDU,
		// Windows Notification Service
		WNS,
		// Microsoft Push Notificaion Service
		MPNS;
	}

	public static String jsonify(Object message) {
		try {
			return objectMapper.writeValueAsString(message);
		} catch (Exception e) {
			e.printStackTrace();
			throw (RuntimeException) e;
		}
	}

	private static Map<String, String> getData() {
		Map<String, String> payload = new HashMap<String, String>();
		payload.put("message", "Hello World!");
		return payload;
	}

	public static String getSampleAppleMessage() {
		Map<String, Object> appleMessageMap = new HashMap<String, Object>();
		Map<String, Object> appMessageMap = new HashMap<String, Object>();
		appMessageMap.put("alert", "Carolina me avisas si te llego por favor gracias.");
		appMessageMap.put("badge", 9);
		appMessageMap.put("sound", "default");
		appleMessageMap.put("aps", appMessageMap);
		return jsonify(appleMessageMap);
	}

	public static String getSampleKindleMessage() {
		Map<String, Object> kindleMessageMap = new HashMap<String, Object>();
		kindleMessageMap.put("data", getData());
		kindleMessageMap.put("consolidationKey", "Welcome");
		kindleMessageMap.put("expiresAfter", 1000);
		return jsonify(kindleMessageMap);
	}

	public static String getSampleAndroidMessage() {
		Map<String, Object> androidMessageMap = new HashMap<String, Object>();
		androidMessageMap.put("collapse_key", "Welcome");
		androidMessageMap.put("data", getData());
		androidMessageMap.put("delay_while_idle", true);
		androidMessageMap.put("time_to_live", 125);
		androidMessageMap.put("dry_run", false);
		return jsonify(androidMessageMap);
	}

	public static String getSampleBaiduMessage() {
		Map<String, Object> baiduMessageMap = new HashMap<String, Object>();
		baiduMessageMap.put("title", "New Notification Received from SNS");
		baiduMessageMap.put("description", "Hello World!");
		return jsonify(baiduMessageMap);
	}

	public static String getSampleWNSMessage() {
		Map<String, Object> wnsMessageMap = new HashMap<String, Object>();
		wnsMessageMap.put("version", "1");
		wnsMessageMap.put("value", "23");
		return "<badge version=\"" + wnsMessageMap.get("version")
				+ "\" value=\"" + wnsMessageMap.get("value") + "\"/>";
	}

	public static String getSampleMPNSMessage() {
		Map<String, String> mpnsMessageMap = new HashMap<String, String>();
		mpnsMessageMap.put("count", "23");
		mpnsMessageMap.put("payload", "This is a tile notification");
		return "<?xml version=\"1.0\" encoding=\"utf-8\"?><wp:Notification xmlns:wp=\"WPNotification\"><wp:Tile><wp:Count>"
				+ mpnsMessageMap.get("count")
				+ "</wp:Count><wp:Title>"
				+ mpnsMessageMap.get("payload")
				+ "</wp:Title></wp:Tile></wp:Notification>";
	}

}
