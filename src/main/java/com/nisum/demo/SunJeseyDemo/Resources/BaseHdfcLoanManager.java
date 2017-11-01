package com.nisum.demo.SunJeseyDemo.Resources;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
@Component
abstract public class BaseHdfcLoanManager {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/check-eligibility")
	public String checkLoanEligibility(@QueryParam("adharno") String adharNo,
			@QueryParam("pan") String pan,
			@QueryParam("loan-type") String loanType,
			@QueryParam("principle") double principle) {
		String status = null;

		if (loanType.equals("home") && principle > 1000000) {
			if (check(pan) == true) {
				status = "eligible";
			}
		}
		if (status == null) {
			status = "not-eligible";
		}

		return status;
	}
	
	

	abstract boolean check(String pan);
}

