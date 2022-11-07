package com.its.members.repository;

import com.its.members.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public MemberDTO save(MemberDTO memberDTO) {
        sql.insert("Member.save",memberDTO);
        return memberDTO;
    }

    public void saveFileName(MemberDTO memberDTO){
        sql.insert("Member.saveFileName",memberDTO);
    }
    public String emailDuplicateCheck(String memberEmail) {
        return sql.selectOne("Member.emailDuplicateCheck",memberEmail);
    }
}
