package com.test.service;


import com.test.entity.Tables;
import com.test.entity.tables.pojos.Member;
import com.test.entity.tables.records.MemberRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private DSLContext dslContext;

    public Integer insert() {
        return dslContext.insertInto(Tables.MEMBER,
                Tables.MEMBER.LEAVEAMOUNT, Tables.MEMBER.MOBILEPHONE, Tables.MEMBER.PWD, Tables.MEMBER.REGNAME, Tables.MEMBER.REGTIME, Tables.MEMBER.TYPE)
                .values(0.1, "17610789726", "123456", "tyl", LocalDateTime.now(), (byte) 1).returning(Tables.MEMBER.ID).fetchOne().getId();

    }

    public Integer insertTest() {
        MemberRecord memberRecord = new MemberRecord();
        memberRecord.setType((byte) 1);
        memberRecord.setMobilephone("17610789727");
        memberRecord.setPwd("123456");
        memberRecord.setRegname("admin");
        memberRecord.setLeaveamount(0.2);
        memberRecord.setRegtime(LocalDateTime.now());
        return dslContext.insertInto(Tables.MEMBER)
                .set(memberRecord)
                .returning(Tables.MEMBER.ID)
                .fetchOne()
                .getId();
    }

    public Integer insertApi() {
        MemberRecord memberRecord = dslContext.newRecord(Tables.MEMBER);
        memberRecord.setType((byte) 1);
        memberRecord.setMobilephone("17610789727");
        memberRecord.setPwd("123456");
        memberRecord.setRegname("admin");
        memberRecord.setLeaveamount(0.2);
        memberRecord.setRegtime(LocalDateTime.now());
        memberRecord.insert();
        return memberRecord.getId();
    }

    public List<Member> query() {
        Result<Record> fetch = dslContext.select().from(Tables.MEMBER).fetch();
        return fetch.into(Member.class);
    }

    public Member getById(){
        Record record = dslContext.select().from(Tables.MEMBER).where(Tables.MEMBER.ID.eq(1)).fetchOne();
        Integer id = record.getValue(Tables.MEMBER.ID);
        String username = record.getValue(Tables.MEMBER.REGNAME);
        String mobile = record.getValue(Tables.MEMBER.MOBILEPHONE);
        String pwd = record.getValue(Tables.MEMBER.PWD);
        LocalDateTime createTime = record.getValue(Tables.MEMBER.REGTIME);
        Double leaveAmount = record.getValue(Tables.MEMBER.LEAVEAMOUNT);
        Member into = record.into(Member.class);
        return into;
    }
}
