package org.magnum.mobilecloud.video.client;

import java.util.Collection;

import org.magnum.mobilecloud.video.repository.DenunciaHistory;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;



public interface SecretariaSvcApi {
	
		//The path where we expect the SecretariaSvc to live
		public static final String SECRETARIA_SVC_PATH = "/secretaria";
		
		//Internal device guid Denuncia
		public static final String DENUNCIA_ID_PARAMETER= "idDenuncia";
		
		//Id for the Office Goverment
		public static final String FOLIO_PARAMETER= "folio";
		
		public static final String DENUNCIA_LIST_HISTORY_PATH=SECRETARIA_SVC_PATH+"/denuncia/findBy";
		
		public static final String DENUNCIA_UPDATE_STATUS_PATH=SECRETARIA_SVC_PATH+"/denuncia";
		
		public static final String TEST = SECRETARIA_SVC_PATH+"/test";
		
		
		@POST(DENUNCIA_UPDATE_STATUS_PATH)
		public void updateDenunciaEstatus(@Body DenunciaHistory d);
		
		
		@GET(DENUNCIA_LIST_HISTORY_PATH)
		public Collection<DenunciaHistory> getAllByFolio(@Query(FOLIO_PARAMETER) String folio);
		
		@GET(DENUNCIA_LIST_HISTORY_PATH)
		public Collection<DenunciaHistory> getAllByIdDenuncia(@Query(DENUNCIA_ID_PARAMETER) String idDenuncia);
		
		
		

}
