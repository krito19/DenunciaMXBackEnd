package org.magnum.mobilecloud.video.repository;

import java.util.Collection;

import org.magnum.mobilecloud.video.client.DispositivoSvcApi;
import org.magnum.mobilecloud.video.client.UsuarioSvcApi;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableScan
@RepositoryRestResource(path = UsuarioSvcApi.USUARIO_SVC_PATH)
public interface UsuarioRepository extends CrudRepository <Usuario, String>{
	
	public Collection<Usuario> findByToken(
			// The @Param annotation tells Spring Data Rest which HTTP request
			// parameter it should use to fill in the "title" variable used to
			// search for Videos
			@Param(UsuarioSvcApi.TOKEN_PARAMETER) String token);

}
