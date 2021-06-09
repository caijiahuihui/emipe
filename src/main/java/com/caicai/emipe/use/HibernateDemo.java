package com.caicai.emipe.use;

import com.caicai.emipe.persistence.main.entity.ScoreFlow;
import com.caicai.emipe.persistence.main.repository.ScoreFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author caicai
 * @create 2021/3/22
 */
@Service
public class HibernateDemo {

    // 实体类管理工厂
    @Autowired
    private EntityManagerFactory factory;

    @Autowired
    private ScoreFlowRepository scoreFlowRepository;

    public void test() {
        // 创建实体管理类
        EntityManager manager = factory.createEntityManager();
        // 获取事务对象
        EntityTransaction entityTransaction = manager.getTransaction();
        // 事务开启
        entityTransaction.begin();
        ScoreFlow flow = new ScoreFlow();
        flow.setScore(1000L);
        flow.setOpUser("hahahaha");
        // 保存操作
        manager.persist(flow);
        // 提交事务
        entityTransaction.commit();
        // 释放资源
        manager.close();
        factory.close();
    }


    public void testSpecification() {
        /**
         * CriteriaQuery接口:
         * 代表一个specific的顶层查询对象，它包含着查询的各个部分，比如：select 、from、where、group by、order by等注意：CriteriaQuery对象只对实体类型或嵌入式类型的Criteria查询起作用
         *
         */
        // predicate 谓词，里面有很很多条件
        // root 组成表达式
        Specification<ScoreFlow> sp = new Specification<ScoreFlow>() {
            private static final long serialVersionUID = -3393548923234220309L;

            @Override
            public Predicate toPredicate(Root<ScoreFlow> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1 = cb.equal(root.get("userId").as(String.class), "1234");
                return p1;
            }
        };
        List<ScoreFlow> result = scoreFlowRepository.findAll(sp);
        for (ScoreFlow flow : result) System.out.println(flow.toString() + "---------------");
    }

}
