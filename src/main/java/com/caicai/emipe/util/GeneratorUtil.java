package com.caicai.emipe.util;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author caicai
 * @create 2021/3/15
 */
public class GeneratorUtil extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws MappingException {
        return UUID.randomUUID().toString();
    }
}
