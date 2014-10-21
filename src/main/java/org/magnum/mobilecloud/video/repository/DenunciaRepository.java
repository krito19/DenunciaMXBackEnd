package org.magnum.mobilecloud.video.repository;

import org.magnum.mobilecloud.video.client.DenunciaSvcApi;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableScan
@RepositoryRestResource(path = DenunciaSvcApi.DENUNCIA_SVC_PATH)
public interface DenunciaRepository extends CrudRepository<Denuncia, String> {
	

		
	public Denuncia findById(
			@Param(DenunciaSvcApi.ID_PARAMETER) String id);
	
}
