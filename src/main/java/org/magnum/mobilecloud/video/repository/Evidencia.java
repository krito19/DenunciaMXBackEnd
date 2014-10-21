package org.magnum.mobilecloud.video.repository;

import java.util.Collection;



public class Evidencia {
	
	
	public Evidencia(){}
	public Evidencia (Collection<Foto> fotos, Collection<Audio> audios, Collection<VideoEvidencia> videos)
	{
		this.fotos=fotos;
		this.audios = audios;
		this.videos = videos;
	}
	

	Collection<Foto> fotos;
	public Collection<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(Collection<Foto> fotos) {
		this.fotos = fotos;
	}
	public Collection<Audio> getAudios() {
		return audios;
	}
	public void setAudios(Collection<Audio> audios) {
		this.audios = audios;
	}

	Collection<Audio> audios;
	
	
	Collection<VideoEvidencia> videos;
	public Collection<VideoEvidencia> getVideos() {
		return videos;
	}
	public void setVideos(Collection<VideoEvidencia> videos) {
		this.videos = videos;
	}
}

