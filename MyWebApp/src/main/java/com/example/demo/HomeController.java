package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("home")
@Controller
public class HomeController {

	@RequestMapping("/getData/{body}")
	@ResponseBody
	public String home(@PathVariable("body") String body) {
		System.out.println("Hi Yes it worked");
		return "You sent us: "+body;
	}
	
	@PostMapping(path="/processLineSep")
	@ResponseBody
	public String processLineSep(@RequestBody String body) {
		
		body = body.replaceAll("\\r\\n", "@");
		String[] a = body.split("@");

		String newString = new String();
		newString = "\""+a[0]+"\",";
		for(int i = 1;i<a.length-1;i++) {
			newString = newString+"\""+a[i]+"\",";
		}
		newString = newString+"\""+a[a.length-1]+"\"";		
		return newString;
	}
	
	@PostMapping(path="/processSpaceSep")
	@ResponseBody
	public String processSpaceSep(@RequestBody String body) {
		
		body = body.replaceAll(" ", "@");
		String[] a = body.split("@");

		String newString = new String();
		newString = "\""+a[0]+"\",";
		for(int i = 1;i<a.length-1;i++) {
			newString = newString+"\""+a[i]+"\",";
		}
		newString = newString+"\""+a[a.length-1]+"\"";		
		return newString;
	}
}
