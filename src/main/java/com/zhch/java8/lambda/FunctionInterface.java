package com.zhch.java8.lambda;

// 注解 @FunctionalInterface 可以不用写, 但写了可以保证接口不会被添加另外的接口
@FunctionalInterface
public interface FunctionInterface {
    public void printArgs(String arg);
}
