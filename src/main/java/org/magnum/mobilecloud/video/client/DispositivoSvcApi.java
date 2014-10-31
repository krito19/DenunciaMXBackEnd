package org.magnum.mobilecloud.video.client;

import java.util.Collection;

import org.magnum.mobilecloud.video.repository.Dispositivo;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface DispositivoSvcApi {
	
	public static final String TOKEN_PARAMETER = "token";

	// The path where we expect the VideoSvc to live
	public static final String DISPOSITIVO_SVC_PATH = "/dispositivo";
	
	// The path to search videos by title
	public static final String DISPOSITIVO_TOKEN_SEARCH_PATH = DISPOSITIVO_SVC_PATH + "/search/findByOs";
	
	@GET(DISPOSITIVO_SVC_PATH)
	public Collection<Dispositivo> getDispositivoList();
	
	@POST(DISPOSITIVO_SVC_PATH)
	public Void addDispositivo(@Body Dispositivo disp);
	
	@GET(DISPOSITIVO_TOKEN_SEARCH_PATH)
	public Collection<Dispositivo> findByOs(@Query(TOKEN_PARAMETER) String token);

}
