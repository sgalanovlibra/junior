/**
 * На меня нельзя смотреть!!!!!!
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package ru.interview.fifth;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Mysterious {
    @After("execution(* ru.interview.fifth.Unaccessable.notAccessableMethod(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("Но можно использовать магию!");
    }
}
