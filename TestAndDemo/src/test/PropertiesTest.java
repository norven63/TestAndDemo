package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("src/test.properties");
			BufferedReader bf = new BufferedReader(new InputStreamReader(is, "utf-8"));
			Properties prop = new Properties();
			prop.load(bf);

			for (Object key : prop.keySet()) {
				System.out.println(key +"="+prop.get(key));
			}
			System.out.println(prop.getProperty("中文") + "+++++++++++++++");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
