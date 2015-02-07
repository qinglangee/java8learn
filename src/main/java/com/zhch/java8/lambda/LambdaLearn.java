package com.zhch.java8.lambda;

/**
 * learned from http://www.importnew.com/14899.html
 * @author lifeix
 *
 */
public class LambdaLearn {


    /**
     * lambda 方式实现线程
     */
    public void lambdaThread(){
        new Thread(()->System.out.println("use lambda version")).start();
    }
    
	/**
	 * 用旧的实现接口的方式实现线程
	 */
	public void interfaceThread() {
		new Thread(new Runnable(){
            public void run() {
                System.out.println("use interface version");
            }
		}).start();
	}
	
	/**
	 * 函数式接口(功能必接口)
	 */
	public void functionInterface(){
	    // 单句的实现
	    FunctionInterface f1 = (name)->System.out.println(name);
	    f1.printArgs("haha");
	    
	    // 单句的可以不加括号
	    FunctionInterface f11 = name -> System.out.println(name);
	    f11.printArgs("haha ge pi");
	    
	    // 多句的实现
	    FunctionInterface f2 = (name)->{
	        String grace = "hello " + name + "!!";
	        System.out.println(grace);
	    };
	    f2.printArgs("lisi");
	    
	    // 静态方法引用
	    FunctionInterface f3 = LambdaLearn::printSubstring;
	    f3.printArgs("long name");
	    
	    // 动态方法引用
	    LambdaLearn learn = new LambdaLearn();
	    FunctionInterface f4 = learn::printDouble;
	    f4.printArgs("long name");
	}
	
	// 被引用的静态方法
	public static void printSubstring(String name){
	    if(name.length() > 3){
	        System.out.println(name.substring(0,3));
	    }
	}
	
	// 被引用的实例方法
	public void printDouble(String name){
	    System.out.println(name + name);
	}
	
	public static void main(String[] args) {
		LambdaLearn t = new LambdaLearn();
//		t.lambdaThread();
//		t.interfaceThread();
		t.functionInterface();
	}
}
