package ua.kh.baklanov.context;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private static Map<String, Object> context=new HashMap<>();

    public static void put(String name, Object object){
        context.put(name,object);
    }

    public static Object get(String key){
        return context.get(key);
    }
}
