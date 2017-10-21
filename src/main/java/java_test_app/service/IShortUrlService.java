package java_test_app.service;

import java.util.Map;

public interface IShortUrlService {
	public String getShortUrl(String url);
	//public void getshortUrlList();
	//public String getOriginUrl(String surl);
	public Map<String, String> getList();
}
