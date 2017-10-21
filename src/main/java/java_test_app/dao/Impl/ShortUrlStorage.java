package java_test_app.dao.Impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java_test_app.dao.IShortUrlInfoDao;

@Component
public class ShortUrlStorage implements IShortUrlInfoDao {
	private static final int CHAR_LENGTH = 8; 
	private Map<String, String> originUrlKeyMap = new HashMap<String, String>();
	private Map<String, String> shortUrlKeyMap = new HashMap<String, String>();
	
	public Map<String, String> getList() {
		return shortUrlKeyMap;
	}
	
	public String getShortUrl(String originUrl) {
		if (originUrlKeyMap.containsKey(originUrl)) {
			return originUrlKeyMap.get(originUrl);
		}
		else {
			String shortUrl = generateKey();
			originUrlKeyMap.put(originUrl, shortUrl);
			shortUrlKeyMap.put(shortUrl, originUrl);
			return shortUrl;
		}
	}
	
	public String getOriginUrl(String shortUrl) {
		return shortUrlKeyMap.get(shortUrl);
	}
	
	private String generateKey() {
		String key = RandomStringUtils.randomAlphanumeric(CHAR_LENGTH);
		
		if (shortUrlKeyMap.containsKey(key))
			return generateKey();
		else
			return key;
	}
}
