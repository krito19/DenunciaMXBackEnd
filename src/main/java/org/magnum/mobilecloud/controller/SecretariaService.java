package org.magnum.mobilecloud.controller;

import java.util.Collection;

import org.magnum.mobilecloud.video.client.SecretariaSvcApi;
import org.magnum.mobilecloud.video.repository.DenunciaHistory;
import org.magnun.mobilecloud.notification.SNSMobilePush;
import org.magnun.mobilecloud.notification.SampleMessageGenerator.Platform;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import retrofit.http.Body;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.sns.AmazonSNSClient;

@RestController
public class SecretariaService {
	
	
	@Autowired
	AmazonDynamoDBClient client;
	
	@Autowired
	AmazonSNSClient snsClient;
	
	
	@RequestMapping(value=SecretariaSvcApi.DENUNCIA_UPDATE_STATUS_PATH,method=RequestMethod.POST)
	public ResponseEntity updateDenunciaEstatus(@RequestBody DenunciaHistory d){
		 DynamoDBMapper mapper = new DynamoDBMapper(client);
		 mapper.save(d);
		 return new ResponseEntity(HttpStatus.CREATED);
		
	}
	

	@RequestMapping(value=SecretariaSvcApi.DENUNCIA_LIST_HISTORY_PATH,method=RequestMethod.GET)
	public Collection<DenunciaHistory> getAllByFolio(@RequestParam(SecretariaSvcApi.FOLIO_PARAMETER) String folio)
	{
		return null;
		
	}
	
	@RequestMapping(value=SecretariaSvcApi.TEST, method=RequestMethod.GET)
	public void test()
	{
		SNSMobilePush push = new SNSMobilePush(snsClient);
		push.sendMessage(Platform.APNS_SANDBOX, "message");
	}
	
	
	
	/*@RequestMapping(value=SecretariaSvcApi.DENUNCIA_LIST_HISTORY_PATH,method=RequestMethod.GET)
	public Collection<DenunciaHistory> getAllByIdDenuncia(@RequestParam(SecretariaSvcApi.DENUNCIA_ID_PARAMETER) String idDenuncia)
	{
		return null;
	}*/
}
