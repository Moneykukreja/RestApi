package org.restapi.com.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restapi.com.messenger.model.Comment;
import org.restapi.com.messenger.model.Message;
import org.restapi.com.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CommentResource {
	
	private CommentService cs = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId)
	{
		return cs.getAllComments(messageId);
		
	}
	
	@GET
	@Path("/commentId")
	public Comment getComment(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId)
	{
		return cs.getComment(messageId, commentId);
		
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId,Comment comment)
	{
		return cs.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateMessage(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId,Comment comment)
	{
		comment.setId(commentId);
		return cs.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteMessage(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId)
	{
		cs.removeComment(messageId, commentId);
	}
}
