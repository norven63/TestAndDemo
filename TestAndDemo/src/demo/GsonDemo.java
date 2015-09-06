package demo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sun.javafx.collections.MappingChange.Map;

public class GsonDemo {
	class Test {
	String a;
	String b;

	@Override
	public String toString() {
		return "Test [a=" + a + ", b=" + b + "]";
	}
	}

	public static void main(String[] args) {
	List<Object> list = new ArrayList<Object>();
	list.add("2");
	list.add("2");
	list.add("4");

	List<String> list2 = new ArrayList<String>();
	list2.add("a");
	list2.add("b");
	list.add(list2);

	GsonBuilder gsonBuilder = new GsonBuilder();
	Gson gson = gsonBuilder.create();

	String jsonString = gson.toJson(list2);

	// Test result = gson.fromJson("{\"a\":\"abc\",\"b\":\"123\"}", Test.class);
	Map<String, String> result = gson.fromJson("{\"a\":\"abc\",\"b\":\"123\"}",
		new TypeToken<Map<String, String>>() {
		}.getType());

	System.out.println(result);
	}
}
