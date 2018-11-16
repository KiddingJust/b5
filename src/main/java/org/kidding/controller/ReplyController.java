package org.kidding.controller;

import java.util.List;

import org.kidding.domain.FreeBoard;
import org.kidding.domain.FreeReply;
import org.kidding.persistence.ReplyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/replies/*")
@Log
@AllArgsConstructor
public class ReplyController {

	private ReplyRepository repository;
	
	@GetMapping("/{bno}")
	public ResponseEntity<List<FreeReply>> getList(@PathVariable("bno") Long bno){
		
		// /replies/299로 접속하면 repository를 호출하지 않아도 select 쿼리문을 날려서 299번 정보를 찾아옴 
		log.info("" + bno);
		
		FreeBoard board = new FreeBoard();
		board.setBno(bno);
		
		List<FreeReply> list = repository.getListByBoard(board);
		
		list.forEach(reply -> {
			log.info("" + reply);
		});
		
		return new ResponseEntity<List<FreeReply>>(list, HttpStatus.OK);
	}
}
