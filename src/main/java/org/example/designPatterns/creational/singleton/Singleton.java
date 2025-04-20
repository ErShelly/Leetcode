package org.example.designPatterns.creational.singleton;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//    Note: Singleton obj is not created until we need it and call the getInstance() method.
//    This is called lazy instantiation. The main problem with the above method is that it is not thread-safe.
public class Singleton {
    private static Singleton instance;

    private Singleton(){
        System.out.println("Singleton is initiated 1");
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

//Eager Instantiation
//JVM executes a static initializer when the class is loaded and hence this is guaranteed to be thread-safe.
class SingletonEagerInstantiation{
    private static SingletonEagerInstantiation instance = new SingletonEagerInstantiation();
    private SingletonEagerInstantiation(){

    }

    public static SingletonEagerInstantiation getInstance(){
        return instance;
    }
}

//Thraed safe but costly
//The main disadvantage of this method is that using synchronized
// every time while creating the singleton object is expensive and may decrease the performance of your program.
class SingletonThreadSafe{
    private static SingletonThreadSafe instance;
    private SingletonThreadSafe(){
        System.out.println("SingletonThreadSafe initialise 1");
    }

    public static synchronized SingletonThreadSafe getInstance(){
        if(instance == null)
            instance = new SingletonThreadSafe();

        return instance;
    }
}

//only acquire the lock on the getInstance() once when the instance is null.
class SingletonDoubleCheck{
    private static SingletonDoubleCheck instance;
    private SingletonDoubleCheck(){
        //Preventing from Reflection API
        if(instance != null){
            throw new RuntimeException("Use getInstance() method");
        }
    }

    public static SingletonDoubleCheck getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new SingletonDoubleCheck();
                }
            }
        }

        return instance;
    }
}

class Driver{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
       Singleton.getInstance();
       Singleton.getInstance();
       Singleton.getInstance();

       Singleton instance1 = Singleton.getInstance();

       //Breaking Singleton class with Reflection API
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        Singleton instance2 = constructor.newInstance();

        System.out.println(instance1 == instance2);
    }
}
