package com.nisum.demo.SunJeseyDemo.Resources;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;
@Component
@Path("/hdfc-loan-manager/v1.1")
public class AdvancedHdfcLoanManager extends BaseHdfcLoanManager {
	@Override
	boolean check(String pan) {
		if (pan.startsWith("ANP") && pan.endsWith("B")) {
			return true;
		}
		return false;
	}
}
