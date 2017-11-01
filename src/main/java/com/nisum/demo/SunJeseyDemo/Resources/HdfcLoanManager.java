package com.nisum.demo.SunJeseyDemo.Resources;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Path("hdfc-loan-manager")
@Component
public class HdfcLoanManager extends BaseHdfcLoanManager {
	@Override
	boolean check(String pan) {
		if (pan.startsWith("ANP")) {
			return true;
		}
		return false;
	}

}
