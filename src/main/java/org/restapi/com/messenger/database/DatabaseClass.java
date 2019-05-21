package org.restapi.com.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.restapi.com.messenger.model.Message;
import org.restapi.com.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();

	public static Map<Long,Message> getMessages()
	{
		return messages;
		
	}

	public static Map<String,Profile> getprofile()
	{
		return profiles;
		
	}
}
