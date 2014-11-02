package org.magnum.mobilecloud.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.magnum.mobilecloud.video.client.SecretariaSvcApi;
import org.magnum.mobilecloud.video.repository.Denuncia;
import org.magnum.mobilecloud.video.repository.DenunciaHistory;
import org.magnum.mobilecloud.video.repository.Dispositivo;
import org.magnun.mobilecloud.notification.SNSMobilePush;
import org.magnun.mobilecloud.notification.SampleMessageGenerator.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.sns.AmazonSNSClient;

@RestController
public class SecretariaService {
	
	
	@Autowired
	AmazonDynamoDBClient client;
	
	@Autowired
	AmazonSNSClient snsClient;
	
	public static  int DENUNCIA_RECIBIDA_SPF = 11;
	
	
	@RequestMapping(value=SecretariaSvcApi.DENUNCIA_UPDATE_STATUS_PATH,method=RequestMethod.POST)
	public ResponseEntity updateDenunciaEstatus(@RequestBody DenunciaHistory d){
		
		 DynamoDBMapper mapper = new DynamoDBMapper(client);
		
		 //Set the new estatus
		 saveDenunciaHistory(mapper, d);
		 
		 //Update the denuncia
		 Denuncia denuncia = updateDenuncia(mapper, d.getIdDenuncia(), d.getFolio(), d.getIdEstatusDenuncia());
		 
		 //Push Notification
		 pushNotification( d.getIdDenuncia(),d.getFolio(),d.getMensaje(),d.getIdEstatusDenuncia(),denuncia.getToken(),mapper);
		 
		 return new ResponseEntity(HttpStatus.CREATED);
		
	}
	

	private void pushNotification(String idDenuncia, String folio,
			String mensaje, int idEstatusDenuncia, String token,DynamoDBMapper mapper) {

		//We need to know if is IOS, Android or whatever
		Platform p = getDevicePlatform(mapper, token);
		
		if(null==p)
			return;
		
		//Build a DenunciaNotification
		org.magnun.mobilecloud.notification.Denuncia d = 
				new org.magnun.mobilecloud.notification.Denuncia(idDenuncia, idEstatusDenuncia, mensaje);
		
		
		//Push the message
		SNSMobilePush sns = new SNSMobilePush(snsClient,d);
		
		sns.sendMessage(p, mensaje,token);
	}


	@RequestMapping(value=SecretariaSvcApi.DENUNCIA_LIST_HISTORY_PATH,method=RequestMethod.GET)
	public Collection<DenunciaHistory> getAllByFolio(@RequestParam(SecretariaSvcApi.FOLIO_PARAMETER) String folio)
	{
		return null;
		
	}
	
	@RequestMapping(value=SecretariaSvcApi.TEST, method=RequestMethod.GET)
	public void test()
	{
		
	}
	
	
	
	/*@RequestMapping(value=SecretariaSvcApi.DENUNCIA_LIST_HISTORY_PATH,method=RequestMethod.GET)
	public Collection<DenunciaHistory> getAllByIdDenuncia(@RequestParam(SecretariaSvcApi.DENUNCIA_ID_PARAMETER) String idDenuncia)
	{
		return null;
	}*/
	
	private void saveDenunciaHistory(DynamoDBMapper mapper, DenunciaHistory d)
	{
		mapper.save(d);
	}
	
	private Denuncia updateDenuncia(DynamoDBMapper mapper,String idDenuncia, String folio,int estatusDenuncia)
	{
		Denuncia d = mapper.load(Denuncia.class, idDenuncia);
		
		
		if(DENUNCIA_RECIBIDA_SPF==estatusDenuncia)
			d.setIdDenunciaSPF(folio);
		
		d.setIdEstadoDenuncia(estatusDenuncia);
		
		mapper.save(d);
		
		return d;
		
			
	}
	
	private Platform getDevicePlatform(DynamoDBMapper mapper,String token)
	{
		Dispositivo d = mapper.load(Dispositivo.class, token);
		if(null==d)
			return null;
		
		
		
		if(d.getOs()==1)
			return Platform.APNS_SANDBOX;
		if(d.getOs()==2)
			return Platform.GCM;
		
		//Just for testing 
		return Platform.APNS_SANDBOX;
			//return null;
		
	}

	
	
	
	private static String getFormatDate(String pattern, Date date) {
		return new SimpleDateFormat(pattern).format(date);
	}
	
	
	
}
