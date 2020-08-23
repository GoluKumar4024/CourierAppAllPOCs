package com.courier.testingAxios;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://192.168.43.174:19000")
public class RESTController {
   
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,path="/user",consumes="application/JSON")
	public User postUser(@RequestBody User user) {
		System.out.println(user.toString());
		return user;
	}	
	
}
