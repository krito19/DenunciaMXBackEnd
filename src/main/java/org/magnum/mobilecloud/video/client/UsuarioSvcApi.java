package org.magnum.mobilecloud.video.client;

import java.util.Collection;

import org.magnum.mobilecloud.video.repository.Usuario;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface UsuarioSvcApi {

	public static final String TOKEN_PARAMETER = "tokenUs";
	
	public static final String USUARIO_SVC_PATH = "/usuario";
	
	public static final String USUARIO_TOKEN_SEARCH_PATH = USUARIO_SVC_PATH + "/search/findByToken";

	@GET(USUARIO_SVC_PATH)
	public Collection<Usuario> getUsuarioList();
	
	@POST(USUARIO_SVC_PATH)
	public Void addUsers(@Body Usuario user);
	
	@GET(USUARIO_TOKEN_SEARCH_PATH)
	public Collection<Usuario> findByToken(@Query(TOKEN_PARAMETER) String token);
}
