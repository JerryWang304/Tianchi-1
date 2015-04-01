package util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ReflectUtil {
		public static void main(String[] args) throws Exception {
			FeatureRecord u = new FeatureRecord();
		
			getProperty(u);
		}

		@SuppressWarnings("unchecked")
		private static Object invokeMethod(Object owner, String methodName,
				Object[] args) throws Exception {
			Class ownerClass = owner.getClass();
			methodName = methodName.substring(0, 1).toUpperCase()
					+ methodName.substring(1);
			Method method = null;
			try {
				method = ownerClass.getMethod("get" + methodName);
			} catch (SecurityException e) {
			} catch (NoSuchMethodException e) {
				return " can't find 'get" + methodName + "' method";
			}
			return method.invoke(owner);
		}
		
		
		public static Map<String,Object> getProperty(Object entityName){
			HashMap<String,Object> map=new HashMap<String,Object>();
			Class c = entityName.getClass();
			Field field[] = c.getDeclaredFields();
			for (Field f : field) {
				Object v=null;
				try {
					v = invokeMethod(entityName, f.getName(), null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put(f.getName(),v);
			}
			return map;
		}
		
		
		@SuppressWarnings("unchecked")
		public static void printProperty(Object entityName) throws Exception {
			Class c = entityName.getClass();
			Field field[] = c.getDeclaredFields();
			for (Field f : field) {
				Object v = invokeMethod(entityName, f.getName(), null);
				System.out.println(f.getName() + "\t" + v + "\t" + f.getType());
			}
		}
}
