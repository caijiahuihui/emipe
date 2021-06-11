package com.caicai.emipe.aop;

import com.caicai.emipe.exception.ControllerException;
import com.caicai.emipe.persistence.main.entity.SysLog;
import com.caicai.emipe.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author caicai
 * @create 2021/6/9
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 切入点
     *
     * @Pointcut
     */
    @Pointcut("@annotation(com.caicai.emipe.aop.Log)")
    public void pointcut() {
    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object obj = null;
        String exception = null;
        try {
            obj = point.proceed();
        } catch (Exception e) {
            if (e instanceof ControllerException) {
                ControllerException controllerException = (ControllerException) e;
                exception = controllerException.getCode() + "," + controllerException.getMessage();
            }
            throw e;
        } finally {
            saveSysLog(point, exception);
        }
        return obj;
    }

    /**
     * 操作记录储存到库
     *
     * @param point
     * @param exception
     */
    private void saveSysLog(ProceedingJoinPoint point, String exception) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        // 获取类名
        String clazzName = point.getTarget().getClass().getName();
        // 获取方法名
        String methodName = signature.getName();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String userName = (String) request.getAttribute("userName");
        // 获取请求参数名
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] params = discoverer.getParameterNames(signature.getMethod());
        // 获取请求参数值
        Object[] args = point.getArgs();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < params.length; i++) {
            strList.add(params[i] + ": " + args[i].toString());
        }
        sysLogService.save(new SysLog(userName, clazzName, methodName, strList.toString(), exception));
    }

}
