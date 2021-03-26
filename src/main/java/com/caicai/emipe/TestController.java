package com.caicai.emipe;

import com.caicai.emipe.service.ScoreFlowService;
import com.caicai.emipe.use.HibernateDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author caicai
 * @create 2021/3/9
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private HibernateDemo hibernateDemo;

    @Autowired
    private ScoreFlowService scoreFlowService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "caicai") String name) {
        return String.format("登录成功： %s", name);
    }

    @PostMapping("/benchSave")
    public String benchSave(@ModelAttribute("list") List<Long> list) {
        String aa = scoreFlowService.batchSave(list);
        log.error("-------benchSave事务已提交----------");
        return aa;
    }

    @PostMapping("/simpleSave")
    public String simpleSave(@ModelAttribute("list") List<Long> list) {
        String aa = scoreFlowService.simpleSave(list);
        log.error("-------simpleSave事务已提交----------");
        return null;
    }

    @GetMapping("test")
    public void test() {
        hibernateDemo.testSpecification();
    }
}