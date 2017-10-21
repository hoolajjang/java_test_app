package java_test_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java_test_app.service.IShortUrlService;
import java_test_app.types.JsonResult;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	
	@Autowired
	private IShortUrlService shortUrlService;
	
	@RequestMapping(value="/getShortUrl", method=RequestMethod.GET)
	public JsonResult GetShortUrl(@RequestParam("url") String url) {
		
		// URL validate check 처리
		
		
		return JsonResult.success(shortUrlService.getShortUrl(url));
	}
}
