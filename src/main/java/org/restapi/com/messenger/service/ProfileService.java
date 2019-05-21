package org.restapi.com.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restapi.com.messenger.database.DatabaseClass;
import org.restapi.com.messenger.model.Message;
import org.restapi.com.messenger.model.Profile;

public class ProfileService {

private static Map<String,Profile> profiles = DatabaseClass.getprofile();
	
	public ProfileService()
	{
		profiles.put("Money", new Profile(1,"Hello","Kukreja","Money"));
		
	}
	
	public  List<Profile> getAllProfiles()
	{
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName)
	{
		return  profiles.get(profileName);		
	}
	
	public Profile addProfile(Profile profile)
	{
		 profile.setId(profiles.size()+1);
		 profiles.put(profile.getProfileName(),profile);
		 return profile;		
	}
	public Profile updateProfile(Profile profile)
	{
		if(profiles.size() <= 0)
		{
			return null;
		}		 
		profiles.put(profile.getProfileName(),profile);
		 return profile;		
	}
	
	public Profile removeMessage(String  profileName)
	{
		return profiles.remove(profileName);
	}
}
