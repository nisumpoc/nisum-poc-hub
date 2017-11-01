package com.nisum.demo.SunJeseyDemo;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.nisum.demo.SunJeseyDemo.bo.ProductBO;
import com.nisum.demo.SunJeseyDemo.exception.ProductException;

@Component
@Path("product/")
public class ProductResouce {
	
	// the logger
	Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	@Autowired
	ProductService productService;
	@Context
	UriInfo uriInfo;

	@Path("getALlProducts")
	@GET
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response getAllProducts() {
		try {
			return Response.status(Status.OK).entity(productService.getAllProducts()).build();
		} catch (ProductException pe) {
			return Response.status(Status.BAD_REQUEST).entity(pe.getMessage()).build();
		}
	}

	@Path("getALlProductsByCategory")
	@GET
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response getAllProductsByCategory(@DefaultValue("a") @QueryParam("category") Character category) {
		try {
			return Response.status(Status.OK).entity(productService.getAllProductsByCategory(category)).build();
		} catch (ProductException pe) {
			return Response.status(Status.BAD_REQUEST).entity(pe.getMessage()).build();
		}
	}

	@Path("saveProduct")
	@POST
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response saveProductByID(ProductBO productBO) {
		try {
			return Response.status(Status.OK).entity(productService.saveProduct(productBO)).build();
		} catch (ProductException pe) {
			return Response.status(Status.BAD_REQUEST).entity(pe.getMessage()).build();
		}
	}

	@Path("updateProduct")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response updateProduct(ProductBO productBO) {
		try {
			return Response.status(Status.OK).entity(productService.saveProduct(productBO)).build();
		} catch (ProductException pe) {
			return Response.status(Status.BAD_REQUEST).entity(pe.getMessage()).build();
		}
	}

	@Path("getProduct/{produtID}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response getProductByID(@PathParam("produtID") Long produtID) {
		try {
			return Response.status(Status.OK).entity(productService.getProductById(produtID)).build();
		} catch (ProductException pe) {
			return Response.status(Status.BAD_REQUEST).entity(pe.getMessage()).build();
		}
	}

	@Path("delete/{produtID}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response deleteProductByID(@PathParam("produtID") Long produtID) {
		try {
			productService.deleteProduct(produtID);
			return Response.status(Status.OK).build();
		} catch (ProductException pe) {
			return Response.status(Status.BAD_REQUEST).entity(pe.getMessage()).build();
		}
	}

	@GET
	@Path("uriinfo")
	public Response getAllUriInfo() {
		MultivaluedMap<String, String> values = uriInfo.getQueryParameters();
		
		for (String key : values.keySet()) {
			for (String value : values.get(key)) {
				System.out.println(value);
			}
		}
		return Response.status(Status.OK).build();
	}

}
