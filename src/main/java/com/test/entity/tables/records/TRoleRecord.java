/*
 * This file is generated by jOOQ.
 */
package com.test.entity.tables.records;


import com.test.entity.tables.TRole;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class TRoleRecord extends UpdatableRecordImpl<TRoleRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -1547231864;

    /**
     * Setter for <code>test.t_role.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>test.t_role.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>test.t_role.role_name</code>.
     */
    public void setRoleName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>test.t_role.role_name</code>.
     */
    public String getRoleName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return TRole.T_ROLE.ID;
    }

    @Override
    public Field<String> field2() {
        return TRole.T_ROLE.ROLE_NAME;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getRoleName();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getRoleName();
    }

    @Override
    public TRoleRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public TRoleRecord value2(String value) {
        setRoleName(value);
        return this;
    }

    @Override
    public TRoleRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TRoleRecord
     */
    public TRoleRecord() {
        super(TRole.T_ROLE);
    }

    /**
     * Create a detached, initialised TRoleRecord
     */
    public TRoleRecord(String id, String roleName) {
        super(TRole.T_ROLE);

        set(0, id);
        set(1, roleName);
    }
}
