package com.amicoz.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestDAOController {

	@Autowired
	private TestDAO testDAO;
	
	@RequestMapping(value="/testDAO", method=RequestMethod.GET)
	public @ResponseBody String testDAO() {
		testDAO.showData();
		
		return ""+Integer.MAX_VALUE;
	}

	
}
