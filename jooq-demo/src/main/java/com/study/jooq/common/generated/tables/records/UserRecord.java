/**
 * This class is generated by jOOQ
 */
package com.study.jooq.common.generated.tables.records;


import com.study.jooq.common.generated.tables.User;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record7<Integer, String, Byte, Byte, String, String, Timestamp> {

    private static final long serialVersionUID = -2012891303;

    /**
     * Setter for <code>study.user.uid</code>. ??id
     */
    public void setUid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>study.user.uid</code>. ??id
     */
    public Integer getUid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>study.user.name</code>. ??
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>study.user.name</code>. ??
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>study.user.sex</code>. ??
     */
    public void setSex(Byte value) {
        set(2, value);
    }

    /**
     * Getter for <code>study.user.sex</code>. ??
     */
    public Byte getSex() {
        return (Byte) get(2);
    }

    /**
     * Setter for <code>study.user.age</code>. ??
     */
    public void setAge(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>study.user.age</code>. ??
     */
    public Byte getAge() {
        return (Byte) get(3);
    }

    /**
     * Setter for <code>study.user.mobile</code>. ????
     */
    public void setMobile(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>study.user.mobile</code>. ????
     */
    public String getMobile() {
        return (String) get(4);
    }

    /**
     * Setter for <code>study.user.password</code>. ??
     */
    public void setPassword(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>study.user.password</code>. ??
     */
    public String getPassword() {
        return (String) get(5);
    }

    /**
     * Setter for <code>study.user.register_time</code>. ????
     */
    public void setRegisterTime(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>study.user.register_time</code>. ????
     */
    public Timestamp getRegisterTime() {
        return (Timestamp) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, Byte, Byte, String, String, Timestamp> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, Byte, Byte, String, String, Timestamp> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return User.USER.UID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return User.USER.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field3() {
        return User.USER.SEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return User.USER.AGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return User.USER.MOBILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return User.USER.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return User.USER.REGISTER_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value3() {
        return getSex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getAge();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getMobile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getRegisterTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value1(Integer value) {
        setUid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value3(Byte value) {
        setSex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value4(Byte value) {
        setAge(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value5(String value) {
        setMobile(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value6(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value7(Timestamp value) {
        setRegisterTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord values(Integer value1, String value2, Byte value3, Byte value4, String value5, String value6, Timestamp value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer uid, String name, Byte sex, Byte age, String mobile, String password, Timestamp registerTime) {
        super(User.USER);

        set(0, uid);
        set(1, name);
        set(2, sex);
        set(3, age);
        set(4, mobile);
        set(5, password);
        set(6, registerTime);
    }
}
