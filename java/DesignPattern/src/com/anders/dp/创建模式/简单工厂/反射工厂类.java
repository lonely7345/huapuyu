package com.anders.dp.创建模式.简单工厂;

public class 反射工厂类 {
	public static ICar getInstance(汽车品牌 carBrand) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// 使用反射创建汽车，这种方式仍然是简单工厂模式
		return (ICar) Class.forName("simpleFactory." + carBrand).newInstance();
	}
}