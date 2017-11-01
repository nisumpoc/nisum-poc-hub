package com.nisum.demo.SunJeseyDemo.resourceconfig;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.nisum.demo.SunJeseyDemo.ProductResouce;
import com.nisum.demo.SunJeseyDemo.Resources.BaseHdfcLoanManager;
import com.nisum.demo.SunJeseyDemo.Resources.HdfcLoanManager;
@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
	packages("com.nisum.demo.SunJeseyDemo.Resources");
		register(ProductResouce.class);
		
	}
}
