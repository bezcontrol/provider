package ua.kh.baklanov.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Context is a class with map that contains all specific dao classes and factories that application need
 * @see MyClassLoader
 * @author      Aleksei Baklanov
 */
public final class Context {
    private static Map<String, Object> contextMap = new HashMap<>();

    private Context(){}

    public static void put(String name, Object object){
        contextMap.put(name,object);
    }

    public static Object get(String key){
        return contextMap.get(key);
    }


}
