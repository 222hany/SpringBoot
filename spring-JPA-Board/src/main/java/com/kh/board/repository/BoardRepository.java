package com.kh.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.board.vo.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	//따로 작성하지 않아도 JpaRepository 안에 내장되어있음.
}