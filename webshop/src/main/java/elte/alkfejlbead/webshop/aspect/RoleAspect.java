package elte.alkfejlbead.webshop.aspect;

import elte.alkfejlbead.webshop.annotation.Role;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.model.api.response.Token;
import elte.alkfejlbead.webshop.repository.UserRepository;
import elte.alkfejlbead.webshop.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Aspect
@Component
public class RoleAspect {

    UserRepository userRepository;

    @Autowired
    public RoleAspect(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Around("within (elte.alkfejlbead.webshop.controller..*) && @annotation(elte.alkfejlbead.webshop.annotation.Role) && args(request,..)")
    public Object checkToken(ProceedingJoinPoint call, HttpServletRequest request) throws Throwable {
        MethodSignature signature = (MethodSignature) call.getSignature();
        Method method = signature.getMethod();

        Role role = method.getAnnotation(Role.class);

        List<User.Role> roles = Arrays.asList(role.value());
        User.Role strongest = roles.stream().max(Comparator.comparing(User.Role::ordinal)).orElse(null);
        String token = request.getHeader(Token.TOKEN);

        User user = userRepository.findByToken(token);

        int userRoleNum;

        if (user == null) {
            userRoleNum = 0;
        } else {
            userRoleNum = userRepository.findByToken(token).getRole().ordinal();
        }

        if (strongest != null && userRoleNum < strongest.ordinal()) {
           throw new Exception("You have no rights to execute that command!");
        }

        return call.proceed();
    }
}
