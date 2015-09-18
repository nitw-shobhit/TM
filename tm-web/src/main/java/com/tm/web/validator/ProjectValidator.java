package com.tm.web.validator;

//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//
//import com.tm.util.validations.Validate;

@Aspect
public class ProjectValidator {
	
//	@Before("execution(public String com.tm.web.controller.ProjectController.addProject(..)) && @annotation(validateAnnotation) ")
//	public void validateProject(JoinPoint join, Validate validateAnnotation) {
//		String [] validationTypes = validateAnnotation.types();
//		if() {
//			documentId = UUID.randomUUID().toString();
//			if(join.getArgs().length > 0) {
//				auditObj = new AuditBean((String) join.getArgs()[0]);
//				auditObj.getAudit().setSession(new Session());
//				Event event = new Event(auditAnnotation.event(), "Initiate - "+ auditAnnotation.value());
//				auditObj.getAudit().getSession().getEvents().getEvent().add(event);
//				ElasticSearchUtils.create(JsonUtils.toJson(auditObj), INDEX, TYPE, documentId);
//			}
//		} else {
//			createNewEvent("Initiate - "+ auditAnnotation.value(), auditAnnotation.event());
//		}
//	}
//
//	@AfterThrowing(
//		pointcut = "execution(public String com.bps.mng.controller.*Controller.*(..)) && @annotation(auditAnnotation) ",
//		throwing= "exception")
//	public void exceptionAudit(JoinPoint join, Throwable exception, Validate auditAnnotation) {
////		createNewEvent("Something bad happened @ "+ join.getSignature().getName() + " - " + exception.getMessage(), auditAnnotation.event());
//	}
//
//	void exceptionAudit(JoinPoint join, Throwable exception) {
//		
//	}
}
