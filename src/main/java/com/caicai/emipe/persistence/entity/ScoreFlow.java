package com.caicai.emipe.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author caicai
 * @create 2021/3/15
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tab_score_flow")
public class ScoreFlow implements Serializable {

    private static final long serialVersionUID = 5987126976988665417L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid-id")
    @GenericGenerator(
            name = "uuid-id",
            strategy = "com.caicai.emipe.util.GeneratorUtil")
    @Column(name="id")
    private String id;

    @Column(name="gmt_create")
    private Date createTime = new Date();

    @Column(name="is_show")
    private boolean isShow;

    @Column(name="gmt_modified")
    private Date modifiedTime = new Date();

    @Column(name="is_lock")
    private boolean isLock;

    @Column(name="user_id")
    private String userId;

    @Column(name="obj_id")
    private String objId;

    @Column(name="percent")
    private int percent;

    @Column(name="score")
    private long score;

    @Column(name="type")
    private String name;

    @Column(name="op_user")
    private String opUser;
}
