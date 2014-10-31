package org.magnum.mobilecloud.video.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "Dispositivo")
public class Dispositivo {
	private String token;
	private int os;
	
	public Dispositivo() {
	}

	public Dispositivo(String token, int os) {
		super();
		this.token = token;
		this.os = os;
		
	}

	
	@DynamoDBHashKey
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@DynamoDBAttribute
	public int getOs() {
		return os;
	}

	public void setOs(int os) {
		this.os = os;
	}

}
