package org.restapi.com.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.restapi.com.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errMessage = new ErrorMessage(ex.getMessage(), 500, "http://restapi.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errMessage).build();
	}

}
