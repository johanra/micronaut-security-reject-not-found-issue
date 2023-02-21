package com.company;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_AUTHENTICATED) 
@Controller("/api/document/")
public class DocumentController {
	
	public DocumentController() {
	}
		 
	 @Get(uri = "download")
	 @Secured(SecurityRule.IS_AUTHENTICATED) 
	 public String download() {
		 return "document";
	 }
	
}
