package org.magnum.mobilecloud.video.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="DenunciaHistory")
public class DenunciaHistory {
	
	String idHistoria;
	String idDenuncia;
	
	String folio;
	String fecha;
	String mensaje;
	int idEstatusDenuncia;
	
	public DenunciaHistory() {
		// TODO Auto-generated constructor stub
	}
	
	public DenunciaHistory(String idHistoria,
	String idDenuncia,
	
	String folio,
	String fecha,
	String mensaje,
	int idEstatusDenuncia)
	{
		super();
		this.idHistoria=idHistoria;
		this.idDenuncia=idDenuncia;
		this.folio=folio;
		this.fecha=fecha;
		this.mensaje=mensaje;
		this.idEstatusDenuncia=idEstatusDenuncia;
	}
	
	@DynamoDBHashKey
	public String getIdHistoria() {
		return idHistoria;
	}
	public void setIdHistoria(String idHistoria) {
		this.idHistoria = idHistoria;
	}
	
	@DynamoDBIndexHashKey
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	
	@DynamoDBIndexHashKey
	public String getIdDenuncia() {
		return idDenuncia;
	}
	public void setIdDenuncia(String idDenuncia) {
		this.idDenuncia = idDenuncia;
	}
	
	@DynamoDBAttribute
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@DynamoDBAttribute
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@DynamoDBAttribute
	public int getIdEstatusDenuncia() {
		return idEstatusDenuncia;
	}
	public void setIdEstatusDenuncia(int idEstatusDenuncia) {
		this.idEstatusDenuncia = idEstatusDenuncia;
	}
	
	

}
