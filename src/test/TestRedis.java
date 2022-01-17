package test;

import redis.clients.jedis.Jedis;

public class TestRedis {
	static String host = "obelix.epd.gov.hk";
	static int port = 6379;

	public static void main(String[] args) {
		Jedis jedis = new Jedis(host, port);

		jedis.set("test", "1234");
		System.out.println(jedis.get("test"));

		jedis.set("test", "12345");
		System.out.println(jedis.get("test"));

		System.out.println("|" + jedis.get("abcdefghijk") + "|");

		jedis.close();
	}
}
