package com.kh.board.vo;

import jakarta.persistence.*; //하나하나 임포트 하지않고 *로 전체 임포트
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "Board")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_add_sequence")
	@SequenceGenerator(name = "board_add_sequence", sequenceName = "board_add_sequence", allocationSize = 1)
	@Column(name = "board_id")
	private Long boardId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "author")
	private String author;
}