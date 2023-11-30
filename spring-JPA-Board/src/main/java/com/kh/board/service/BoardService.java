package com.kh.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.board.repository.BoardRepository;
import com.kh.board.vo.Board;

@Service
public class BoardService {
	private final BoardRepository boardRepository;
	
	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	//전체보기
	public List<Board> getAllBoards(){
		return boardRepository.findAll();
	}
	
	//상세보기
	public Optional<Board> getBoardById(Long boardId){
		return boardRepository.findById(boardId);
	}
	
	//게시물 추가, 수정
	public Board saveBoard(Board board) {
		return boardRepository.save(board);
	}

	//게시물 선택 삭제
	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);
	}
	
	//게시물 전체 삭제
	public void deleteAllBoard() {
		boardRepository.deleteAll();
	}
	
	//특정 검색어로 검색
	public List<Board> findBoardByTitle(String keyword){
		return boardRepository.findTitle(keyword);
	}
}
