package java_test_app.dao;

public interface IShortUrlInfoDao {
	public String getShortUrl(String originUrl);
	public String getOriginUrl(String shortUrl);
}
