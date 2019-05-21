package org.restapi.com.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.swing.plaf.metal.MetalPopupMenuSeparatorUI;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.restapi.com.messenger.model.Message;
import org.restapi.com.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService ms = new MessageService();

	@GET	
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size){
		if(year > 0)
		{
			return ms.getAllMessagesForYear(year);
		}
		else if(start >= 0 &&  size >0)
		{
			return ms.getAllMessagesPaginated(start, size);
		}
		
		return ms.getAllMessages();
		
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id)
	{
		return ms.getMessage(id);
	}
	
	@POST
	public Response addMessage(Message message,@Context UriInfo uriInfo)
	{
		Message newMessage = ms.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();		
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id,Message message)
	{
		message.setId(id);
		return ms.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id)
	{
		ms.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		
		return new CommentResource();
	}

}