package com.kh.board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.board.service.BoardService;
import com.kh.board.vo.Board;

@Controller
@RequestMapping("/boards")
public class BoardController {
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//전체보기
	@GetMapping
	public String getAllBoards(Model model) {
		model.addAttribute("boards", boardService.getAllBoards());
		return "boardList";
	}
	
	//상세보기
	@GetMapping("/details/{boardId}")
	public String getBoardDetails(@PathVariable Long boardId, Model model) {
		Optional<Board> board = boardService.getBoardById(boardId);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "boardDetail";
	}
	
	//게시물 추가하는 컨트롤러 Get, Post
	@GetMapping("/new")
	public String displayBoardForm(Model model) {
		model.addAttribute("board", new Board());
		return "boardForm";
	}
	@PostMapping("/save")
	public String saveBoard(@ModelAttribute Board borad) {
		boardService.saveBoard(borad);
		return "redirect:/boards";
	}
	
	//게시물 수정하는 컨트롤러 Get
	@GetMapping("/update/{boardId}")
	public String getUpdateBoard(@PathVariable Long boardId, Model model) {
		Optional<Board> board = boardService.getBoardById(boardId);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "boardForm";
	}
	
	//게시물 삭제하는 컨트롤러
	@GetMapping("/delete/{boardId}")
	public String deleteBoard(@PathVariable Long boardId) {
		boardService.deleteBoard(boardId);
		return "redirect:/boards";
	}
	@GetMapping("/delete/all")
	public String deleteAllBoard() {
		boardService.deleteAllBoard();
		return "redirect:/boards";
	}
}
