package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o, objects);
    }

    public static  Object newProxyInstance(Class<CgUser> targetInstanceClazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CglibProxy());
        return  enhancer.create();
    }

    public static void main(String[] args) {
        CgUser target = (CgUser)CglibProxy.newProxyInstance(CgUser.class);
        target.method();
    }

}
