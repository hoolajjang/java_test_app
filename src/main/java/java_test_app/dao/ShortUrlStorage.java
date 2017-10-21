package java_test_app.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ShortUrlStorage implements IShortUrlInfoDao {
	private static final int CHAR_LENGTH = 8; 
	//private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private Map<String, String> originUrlKeyMap = new HashMap<String, String>();
	private Map<String, String> shortUrlKeyMap = new HashMap<String, String>();
	
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
