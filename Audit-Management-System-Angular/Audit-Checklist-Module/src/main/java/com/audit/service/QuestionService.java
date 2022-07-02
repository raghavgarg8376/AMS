package com.audit.service;

import java.util.List;

import com.audit.model.AuditType;
import com.audit.model.Question;

public interface QuestionService {
	public List<Question> getQuestionsByAuditType(AuditType auditType);
	public List<Question> saveResponses(List<Question> questionsResponse);
}
