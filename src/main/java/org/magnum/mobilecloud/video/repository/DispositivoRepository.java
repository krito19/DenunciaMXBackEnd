package org.magnum.mobilecloud.video.repository;

import java.util.Collection;

import org.magnum.mobilecloud.video.client.DispositivoSvcApi;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@EnableScan
@RepositoryRestResource(path = DispositivoSvcApi.DISPOSITIVO_SVC_PATH)
public interface DispositivoRepository extends CrudRepository<Dispositivo, String>{
	
	public Collection<Dispositivo> findByOs(
			// The @Param annotation tells Spring Data Rest which HTTP request
			// parameter it should use to fill in the "title" variable used to
			// search for Videos
			@Param(DispositivoSvcApi.TOKEN_PARAMETER) String token);
	
}
