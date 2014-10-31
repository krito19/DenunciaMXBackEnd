package org.magnum.mobilecloud.video.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Usuario")
public class Usuario {
	
	private String token = "token";
	private String nombre = "nombre";
	private String correo = "correo";
	private String direccion = "direccion";
	
	public Usuario(){
	}
	
	public Usuario(String token, String nombre, String correo, String direccion){
		super();
		this.token = token;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
	}

	@DynamoDBHashKey
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@DynamoDBAttribute
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@DynamoDBAttribute
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@DynamoDBAttribute
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
