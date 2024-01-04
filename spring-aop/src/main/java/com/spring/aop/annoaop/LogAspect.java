package com.spring.aop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 通知类型：
 * 每一个横切关注点上要做的事情都需要写一个方法来实现，这样的方法就叫通知方法。
 * @Before 前置通知:在被代理的目标方法前执行
 * @AfterReturning 返回通知:在被代理的目标方法成功结束后执行(寿终正寝)
 * @AfterThrowing 异常通知:在被代理的目标方法异常结束后执行(死于非命)
 * @After 后置通知:在被代理的目标方法最终结束后执行(盖棺定论)
 * @Around 环绕通知:使用try...catch...finally结构围绕整个被代理的目标方法，包括上面四种通知对应的所有位置
 */

@Aspect // 切面类
@Component // ioc容器
public class LogAspect {


     // 设置切入点和通知类型
     // 前置 @Before(value="切入点表达式 配置切入点")
     //  @Before(value = "execution(* com.spring.aop.annoaop.CalculatorImpl.*(..))")
     @Before(value = "pointcut()")
     public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->前置通知，方法名:"+methodName+"，参数:"+args);
     }


     //  @After(value = "execution(* com.spring.aop.annoaop.CalculatorImpl.*(..))")
     @After(value = "pointcut()")
     public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名:"+methodName);
     }

    @AfterReturning(value = "execution(* com.spring.aop.annoaop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
      System.out.println("Logger-->返回通知，方法名:"+methodName+"，结果:"+result);
    }

    @AfterThrowing(value = "execution(* com.spring.aop.annoaop.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名:"+methodName+"，异常:"+ex);
    }

    @Around(value = "execution(* com.spring.aop.annoaop.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知-->目标对象方法执行之前"); //目标对象(连接点)方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->目标对象方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时");
        } finally {
            System.out.println("环绕通知-->目标对象方法执行完毕");
        }
        return result;
    }

    // 重用切入点表达式
    @Pointcut(value = "execution(* com.spring.aop.annoaop.CalculatorImpl.*(..))")
    public void pointcut() {}
}
