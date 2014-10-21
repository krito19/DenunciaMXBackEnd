package org.magnum.mobilecloud.video.client;

import java.util.Collection;

import org.magnum.mobilecloud.video.repository.Denuncia;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface DenunciaSvcApi {
	
	//The path where we expect the VideoSvc to live
	public static final String DENUNCIA_SVC_PATH = "/denuncia";
	
	public static final String DENUNCIA_ID_SEARCH_PATH=DENUNCIA_SVC_PATH + "/search/findById";
	
	public static final String DENUNCIA_ID_SFP_SEARCH_PATH=DENUNCIA_SVC_PATH + "/search/findByIdSFP";
	
	public static final String ID_PARAMETER="id";
	
	public static final String ID_SPF_PARAMETER="idSPF";
	
	@GET(DENUNCIA_SVC_PATH)
	public Collection<Denuncia> getDenunciaList();
	
	@GET(DENUNCIA_ID_SEARCH_PATH)
	public Denuncia getDenunciaByIdInterno(@Query(ID_PARAMETER)  String idInterno );
	
	
	@POST(DENUNCIA_SVC_PATH)
	public void addDenuncia(@Body Denuncia d);
	
	
}
