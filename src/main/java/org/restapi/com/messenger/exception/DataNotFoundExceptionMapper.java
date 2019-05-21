package org.restapi.com.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.restapi.com.messenger.model.ErrorMessage;

public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {	
		ErrorMessage  errormessage = new ErrorMessage(ex.getMessage(), 404, "http://restapi.com");
		return Response.status(Status.NOT_FOUND).entity(errormessage).build();
	}

}
