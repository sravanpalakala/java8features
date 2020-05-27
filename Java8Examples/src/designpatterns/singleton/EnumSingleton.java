package designpatterns.singleton;

public enum  EnumSingleton {
      INSTANCE;
    
    public static int  doSomething(){
        //do something
    	System.out.println("object"+EnumSingleton.INSTANCE.hashCode());
    	return EnumSingleton.INSTANCE.hashCode();
    }
    
    public static void main(String args[]) {
    int a= 	EnumSingleton.doSomething();
    int b= 	EnumSingleton.doSomething();	
    	if (a == b) {
    		System.out.println("is a singleton");
    	}else {
    		System.out.println("is not a singleton");
    	}
    }
    
}
