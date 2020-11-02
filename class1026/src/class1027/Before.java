package class1027;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//这里有没有后面的("before") 都可以
@Component
@Aspect
public class Before {
    @org.aspectj.lang.annotation.Before("execution(* class1027.*.*(..))")
//    @AfterReturning(pointcut="execution(* class1027.*.*(..))",returning="obj")
//    @AfterThrowing(pointcut="execution(* class1027.*.*(..))", throwing="e")
//    @After(value="execution(* class1027.*.*(..))")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("注解前置程序"+joinPoint.getKind());
    }
}
