package java_test_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping
	public String index() throws Exception{
		return "index/index";
	}
}
