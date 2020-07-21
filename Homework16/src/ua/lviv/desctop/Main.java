package ua.lviv.desctop;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {

		Class an = Animal.class;

		String simpleName = an.getSimpleName();
		System.out.println("Name of class = " + simpleName);
		System.out.println();
		// min 1
		int modifiers = an.getModifiers();
		String modifierText = Modifier.toString(modifiers);
		System.out.println("Class modifier = " + modifierText);
		System.out.println("Class modifier is static = " + Modifier.isStatic(modifiers));
		System.out.println("Class modifier is abstract = " + Modifier.isAbstract(modifiers));
		System.out.println("Class modifier is final = " + Modifier.isFinal(modifiers));
		System.out.println("Class modifier is interface = " + Modifier.isInterface(modifiers));
		System.out.println("Class modifier is private = " + Modifier.isPrivate(modifiers));
		System.out.println();
		Package package1 = an.getPackage();
		System.out.println("Class package = " + package1);
	
		Class superclass = an.getSuperclass();
		System.out.println("Class superclass = " + superclass);
	
		Class[] interfaces = an.getInterfaces();
		System.out.println("Class interfaces = " + Arrays.toString(interfaces));
		System.out.println();
		Constructor[] constructors = an.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println("Class constructors are = " + constructor);

		}

		Constructor<Animal> const1 = constructors[1];
		Class<?>[] parameterTypes = const1.getParameterTypes();
		for (Class<?> class1 : parameterTypes) {
			System.out.println("Parameter types for constructor = " + class1);
		}
		System.out.println();
		Field[] declaredFields = an.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println("Class fields are = " + field);
		}
		System.out.println();
		Method[] methods = an.getMethods();
		for (Method method : methods) {
			System.out.println("Class methods = " + method);
		}

		System.out.println();
		Constructor<Animal> constructor = an.getConstructor(String.class, int.class, String.class);
		Animal newInstance = constructor.newInstance("Murka", 18, "cat");
		System.out.println("Old value of field age = "+newInstance);

		// max 2
		Field f = an.getDeclaredField("age");
		f.setAccessible(true);
		f.setInt(newInstance, 25);

		System.out.println("New value of field age = "+newInstance);
		System.out.println();
		// max 3
		System.out.println();
		newInstance.myMethod("Murka");
		newInstance.myMethod("Jack", "dog", 18);

	}

}
