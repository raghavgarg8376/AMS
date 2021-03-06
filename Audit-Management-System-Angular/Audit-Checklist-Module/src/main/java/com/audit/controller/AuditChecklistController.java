package com.audit.controller;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.audit.model.AuditType;
import com.audit.model.Question;
import com.audit.service.AuthorizationService;
import com.audit.service.QuestionService;


@RestController
@RequestMapping("/checklist")
@CrossOrigin(origins = "*")
public class AuditChecklistController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	AuthorizationService tokenService;
	Logger logger = LoggerFactory.getLogger("Checklist-Controller-Logger");
	
	// Endpoint for retrieving the questions from the DB 
	@RequestMapping(value = "/AuditCheckListQuestions", method = {RequestMethod.GET, RequestMethod.POST} )
	public List<Question> auditCheckListQuestions(@RequestHeader("Authorization") String jwt,  @RequestBody AuditType auditType) 
	{
		List<Question> questions = new ArrayList<Question>();
		
		logger.info("from header JWT :: " + jwt);
		
		// checking if the jwt is valid or invalid
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) 
		{	
			questions = questionService.getQuestionsByAuditType(auditType);
		}
		return questions;
	}
	
	// Endpoint to check if the microservice is active
	@GetMapping("/health-check")
	public String healthCheck() 
	{
		return "Audit-Checklist Microservice is Active";
	}
	@PostMapping("/saveResponses")
	public ResponseEntity<?> saveResponses(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody List<Question> questionsResponse){
		List<Question> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		if(tokenService.validateJwt(token)) {
			questionsList = questionService.saveResponses(questionsResponse);
			responseEntity = new ResponseEntity<List<Question>>(questionsList,HttpStatus.OK);
			logger.debug("Start",responseEntity);
			logger.info("End");

			return responseEntity;
		}
		else {

			responseEntity= new ResponseEntity<String>("Token Expired",HttpStatus.FORBIDDEN);
			return responseEntity;
		}
	}
}