package org.magnum.mobilecloud.video.repository;



public class Pregunta
{
	
	public Pregunta(){}
	public static Pregunta createPregunta(int idPregunta, String respuesta)
	{
		return new Pregunta(idPregunta,respuesta);
	}
	
	public Pregunta(int idPregunta, String respuesta)
	{
		this.idPregunta=idPregunta;
		this.respuesta= respuesta;
	}
	int idPregunta;
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	String respuesta;
}