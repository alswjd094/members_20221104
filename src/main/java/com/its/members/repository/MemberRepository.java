package com.its.members.repository;

import com.its.members.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public MemberDTO save(MemberDTO memberDTO) {
        sql.insert("Member.save",memberDTO);
        return memberDTO;
    }

    public void saveFileName(MemberDTO memberDTO){
        sql.insert("Member.saveFile",memberDTO);
    }
    public String emailDuplicateCheck(String memberEmail) {
        return sql.selectOne("Member.emailDuplicateCheck",memberEmail);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login",memberDTO);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById",id);
    }

    public void delete(Long id) {
        sql.delete("Member.delete",id);
    }

}
