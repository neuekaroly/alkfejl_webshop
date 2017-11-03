package elte.alkfejlbead.webshop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import elte.alkfejlbead.webshop.entity.User;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Role {
    User.Role[] value() default {User.Role.GUEST};
}