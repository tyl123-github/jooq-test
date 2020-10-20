/*
 * This file is generated by jOOQ.
 */
package com.test.entity.tables.daos;


import com.test.entity.tables.TRole;
import com.test.entity.tables.records.TRoleRecord;

import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TRoleDao extends DAOImpl<TRoleRecord, com.test.entity.tables.pojos.TRole, String> {

    /**
     * Create a new TRoleDao without any configuration
     */
    public TRoleDao() {
        super(TRole.T_ROLE, com.test.entity.tables.pojos.TRole.class);
    }

    /**
     * Create a new TRoleDao with an attached configuration
     */
    public TRoleDao(Configuration configuration) {
        super(TRole.T_ROLE, com.test.entity.tables.pojos.TRole.class, configuration);
    }

    @Override
    public String getId(com.test.entity.tables.pojos.TRole object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.test.entity.tables.pojos.TRole> fetchRangeOfId(String lowerInclusive, String upperInclusive) {
        return fetchRange(TRole.T_ROLE.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.test.entity.tables.pojos.TRole> fetchById(String... values) {
        return fetch(TRole.T_ROLE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.test.entity.tables.pojos.TRole fetchOneById(String value) {
        return fetchOne(TRole.T_ROLE.ID, value);
    }

    /**
     * Fetch records that have <code>role_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.test.entity.tables.pojos.TRole> fetchRangeOfRoleName(String lowerInclusive, String upperInclusive) {
        return fetchRange(TRole.T_ROLE.ROLE_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>role_name IN (values)</code>
     */
    public List<com.test.entity.tables.pojos.TRole> fetchByRoleName(String... values) {
        return fetch(TRole.T_ROLE.ROLE_NAME, values);
    }
}