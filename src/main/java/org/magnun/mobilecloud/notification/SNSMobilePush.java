package org.magnun.mobilecloud.notification;

import java.util.HashMap;
import java.util.Map;

import org.magnun.mobilecloud.notification.SampleMessageGenerator.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;


public class SNSMobilePush {
	
	AmazonSNSClient client;
	String tokenDevice;
	String idDenuncia;
	String folio;
	int estatusDenuncia;
	
	
	private static final String APN_SANDBOX_APP_NAME="";
	
	
	// This should be in pem format with \n at the end of each line.
	private static final String APN_SANDBOX_CERTIFICATE ="";
	
	private static final String APN_SANDBOX_PRIVATEKEY = "";
			
	
	private static final String GCM_API_KEY="";
	private static final String GCM_APP_NAME="";
	
	
	
	private AmazonSNSClientWrapper snsClientWrapper;
	
	public static final Map<Platform, Map<String, MessageAttributeValue>> attributesMap = new HashMap<Platform, Map<String, MessageAttributeValue>>();
	static {
		attributesMap.put(Platform.GCM, null);
		attributesMap.put(Platform.APNS, null);
		attributesMap.put(Platform.APNS_SANDBOX, null);
		
	}
	
	public SNSMobilePush(AmazonSNSClient client)
	{
		this.client=client;
		client.setEndpoint("https://sns.us-west-2.amazonaws.com");
		this.snsClientWrapper= new AmazonSNSClientWrapper(client);
		
	}
	
	public void sendMessage(Platform platform,String message,String token)
	{
		try {
			this.tokenDevice=token;
		
			if(platform==Platform.APNS_SANDBOX)
				demoAppleSandboxAppNotification();
			
			else if(platform==Platform.GCM)
				demoAndroidAppNotification();
			
		}catch (AmazonServiceException ase) {
						System.out
						.println("Caught an AmazonServiceException, which means your request made it "
								+ "to Amazon SNS, but was rejected with an error response for some reason.");
				System.out.println("Error Message:    " + ase.getMessage());
				System.out.println("HTTP Status Code: " + ase.getStatusCode());
				System.out.println("AWS Error Code:   " + ase.getErrorCode());
				System.out.println("Error Type:       " + ase.getErrorType());
				System.out.println("Request ID:       " + ase.getRequestId());
			} catch (AmazonClientException ace) {
				System.out
						.println("Caught an AmazonClientException, which means the client encountered "
								+ "a serious internal problem while trying to communicate with SNS, such as not "
								+ "being able to access the network.");
				System.out.println("Error Message: " + ace.getMessage());
			}
		
	}
	
	public void demoAndroidAppNotification() {
		// TODO: Please fill in following values for your application. You can
		// also change the notification payload as per your preferences using
		// the method
		// com.amazonaws.sns.samples.tools.SampleMessageGenerator.getSampleAndroidMessage()
		String serverAPIKey = GCM_API_KEY;
		String applicationName = GCM_APP_NAME;
		String registrationId = tokenDevice;
		snsClientWrapper.demoNotification(Platform.GCM, "", serverAPIKey,
				registrationId, applicationName, attributesMap);
	}

	public void demoAppleAppNotification() {
		// TODO: Please fill in following values for your application. You can
		// also change the notification payload as per your preferences using
		// the method
		// com.amazonaws.sns.samples.tools.SampleMessageGenerator.getSampleAppleMessage()
		String certificate = ""; // This should be in pem format with \n at the
									// end of each line.
		String privateKey = ""; // This should be in pem format with \n at the
								// end of each line.
		String applicationName = "";
		String deviceToken = tokenDevice; // This is 64 hex characters.
		snsClientWrapper.demoNotification(Platform.APNS, certificate,
				privateKey, deviceToken, applicationName, attributesMap);
	}

	public void demoAppleSandboxAppNotification() {
		// TODO: Please fill in following values for your application. You can
		// also change the notification payload as per your preferences using
		// the method
		// com.amazonaws.sns.samples.tools.SampleMessageGenerator.getSampleAppleMessage()
		String certificate = APN_SANDBOX_CERTIFICATE; // This should be in pem format with \n at the
									// end of each line.
		String privateKey = APN_SANDBOX_PRIVATEKEY; 
		
		// This should be in pem format with \n at the end of each line.
		String applicationName = APN_SANDBOX_APP_NAME;
		String deviceToken = tokenDevice; // This is 64 hex characters.
		snsClientWrapper.demoNotification(Platform.APNS_SANDBOX, certificate,
				privateKey, deviceToken, applicationName, attributesMap);
	}
}
