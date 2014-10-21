package org.magnum.mobilecloud.video.repository;

public class Foto
{
	public Foto(){}
	public Foto (String nombre,String key)
	{
		this.nombre=nombre;
		this.key=key;
	}
	
	String nombre;
	String key;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	

}