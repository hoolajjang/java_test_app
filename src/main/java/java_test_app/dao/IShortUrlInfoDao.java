package java_test_app.dao;

import java.util.Map;

public interface IShortUrlInfoDao {
	public String getShortUrl(String originUrl);
	public String getOriginUrl(String shortUrl);
	public Map<String, String> getList();
}
