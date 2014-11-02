package org.magnun.mobilecloud.notification;

public class Denuncia {
	
	
	public Denuncia(){}
	
	public Denuncia(String id,int idStatus,String mensaje )
	{
		this.id=id;
		this.id_status=idStatus;
		this.mensaje=mensaje;
		
	}
	
	String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	int id_status;
	
	String mensaje;
	

}
