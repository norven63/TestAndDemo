package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonDemo {
    static class Test {
        String a;
        String b;

        @Override
        public String toString() {
            return "Test [a=" + a + ", b=" + b + "]";
        }
    }

    static class A {
        private int i = 1;
        private Type type = Type.TypeB;

        @Override
        public String toString() {
            return "A [i=" + i + ", type=" + type + "]";
        }
    }

    enum Type {
        TypeA, TypeB;
    }

    public static void main(String[] args) {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();

        List<Test> testList = gson.fromJson("[{\"a\":\"abc1\",\"b\":\"111\"},{\"a\":\"abc2\",\"b\":\"222\"}]",
                new TypeToken<ArrayList<Test>>() {
                }.getType());

        for (Test item : testList) {
            System.out.println("test item: " + item.toString());
        }

        HashMap<String, String> testMap = gson.fromJson("{\"a\":\"abc\",\"b\":\"123\"}",
                new TypeToken<HashMap<String, String>>() {
                }.getType());//注意，这里的申明需要使用HashMap，而非Map

        System.out.println("testMap:" + testMap);

        //关于枚举的映射
        Gson sGson = new Gson();
        String aJsonStr = sGson.toJson(new A());
        System.out.println("A to json: " + aJsonStr);
        A a = sGson.fromJson(aJsonStr, A.class);
        System.out.println("A from json: " + a.toString());
    }
}
