package org.magnum.mobilecloud.video.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshalling;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;




@DynamoDBTable(tableName = "Denuncia")
public class Denuncia {

	
	String id;
	String idDenunciaSPF;
	String token;
	boolean isAnonima;
	String mail;
	String titulo;
	int idDependencia;
	int idEstadoDenuncia;
	String fechaRegistro;

	Evidencia evidencia;

	@DynamoDBAttribute
	@DynamoDBMarshalling(marshallerClass = EvidenciaMarshaller.class)
	public Evidencia getEvidencia() {
		return evidencia;
	}

	public void setEvidencia(Evidencia evidencia) {
		this.evidencia = evidencia;
	}

	Ubicacion ubicacion;
	
	public Denuncia(){}
	
	public Denuncia( String id, String idDenunciaSPF,String token,
					 boolean isAnonima,      String mail,      	String titulo,
				 	 int idDependencia,      int idEstadoDenuncia,String fechaRegistro,
				 	 Evidencia evidencia,
				 	 Ubicacion ubicacion){
		super();
		this.id=id;
		this.idDenunciaSPF = idDenunciaSPF;
		this.token=token;
		this.isAnonima=isAnonima;
		this.mail=mail;
		this.titulo=titulo;
	 	this.idDependencia=idDependencia;
	 	this.idEstadoDenuncia=idEstadoDenuncia;
	 	this.fechaRegistro=fechaRegistro;
	 	this.evidencia=evidencia;
	 	this.ubicacion=ubicacion;
		
	}

	
	@DynamoDBHashKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute
	public String getIdDenunciaSPF() {
		return idDenunciaSPF;
	}

	public void setIdDenunciaSPF(String idDenunciaSPF) {
		this.idDenunciaSPF = idDenunciaSPF;
	}

	@DynamoDBAttribute
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@DynamoDBAttribute
	public boolean isAnonima() {
		return isAnonima;
	}

	public void setAnonima(boolean isAnonima) {
		this.isAnonima = isAnonima;
	}

	@DynamoDBAttribute
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@DynamoDBAttribute
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@DynamoDBAttribute
	public int getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(int idDependencia) {
		this.idDependencia = idDependencia;
	}

	@DynamoDBAttribute
	public int getIdEstadoDenuncia() {
		return idEstadoDenuncia;
	}

	@DynamoDBAttribute
	public void setIdEstadoDenuncia(int idEstadoDenuncia) {
		this.idEstadoDenuncia = idEstadoDenuncia;
	}

	@DynamoDBAttribute
	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	

	@DynamoDBAttribute
    @DynamoDBMarshalling(marshallerClass = UbicacionMarshaller.class)
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	
}
