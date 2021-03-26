package com.caicai.emipe.use;

import com.caicai.emipe.persistence.entity.ScoreFlow;
import com.caicai.emipe.persistence.repository.ScoreFlowRepository;
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
        Specification<ScoreFlow> sp = new Specification<ScoreFlow>() {
            private static final long serialVersionUID = -3393548923234220309L;

            @Override
            public Predicate toPredicate(Root<ScoreFlow> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("userId").as(String.class), null);
            }
        };
        List<ScoreFlow> result = scoreFlowRepository.findAll(sp);
        for (ScoreFlow flow : result) System.out.println(flow.toString() + "---------------");
    }

}
