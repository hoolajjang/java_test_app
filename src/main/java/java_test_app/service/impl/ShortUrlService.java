package java_test_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java_test_app.dao.IShortUrlInfoDao;
import java_test_app.service.IShortUrlService;

@Service
public class ShortUrlService implements IShortUrlService {
	
	@Autowired
	private IShortUrlInfoDao shortUrlData;
	
	@Override
	public String getShortUrl(String originUrl) {
		return shortUrlData.getShortUrl(originUrl);
	}
	
}
