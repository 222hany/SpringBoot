package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.vo.STMEMBER;



public interface StmemberRepository  extends JpaRepository <STMEMBER,Long>{

}