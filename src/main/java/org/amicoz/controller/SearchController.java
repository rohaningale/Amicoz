package org.amicoz.controller;

import java.util.ArrayList;
import java.util.List;

import org.amicoz.dao.UserDAO;
import org.amicoz.ui.model.SearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;


@Controller
@SessionAttributes(names={"s_emailid","s_userid","s_fullname","s_groupid","s_imgsrc"})
public class SearchController {

	@Autowired
	UserDAO userDao;
	
	
	@RequestMapping(value="/search",method = RequestMethod.POST) 
	public @ResponseBody String handleSearchRequest_POST(ModelMap modelMap) {
		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}
		return "1";
	}
	
	@RequestMapping(value="/search",method = RequestMethod.GET) 
	public String handleSearchRequest_GET(@RequestParam String searchQuery, ModelMap modelMap) {
		
		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}

		// System.out.println("Settings "+modelMap.get("s_emailid"));
		/*
		 * 
		 * This should call the GeneralSettingsImpl.showSettings
		 * 
		 */
		// modelMap.put("s_fullname", value)
		modelMap.addAttribute("s_imgsrc", userDao.getProfilePicURL(Integer.parseInt(modelMap.get("s_userid").toString())));
		
		
		System.out.println("in search");
		
		/* Call the search service and pass the query */
		/* this service would call the database dao handler for search 
		 * and will search the database for first and last name 
		 * and will return the result */
		List<SearchResults> searchList = userDao.search(searchQuery.toUpperCase());
		
		if(searchList.size() > 0){
			/*for(int i= 0; i<searchList.size(); i++) {
				System.out.println(" "+i+" [ "+ searchList.get(i) +"  ]");
			}*/
			
			Gson g = new Gson();
			String groupListJSON = g.toJson(searchList);
			modelMap.addAttribute("searches",groupListJSON);
			return "search";
		}
		
		return "search";
	}
	
}
