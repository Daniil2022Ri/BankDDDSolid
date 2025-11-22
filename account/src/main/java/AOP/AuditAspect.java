package AOP;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import service.AuditService;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class AuditAspect {

}
