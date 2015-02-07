package com.zhch.java8.lambda;

public interface DefaultMethodIF {
    // 接口方法可以有默认实现了, 跟虚类差不太多了, 接口还可以同时实现多个
    default void cry(){
        System.out.println("I am crying.");
    }
}
