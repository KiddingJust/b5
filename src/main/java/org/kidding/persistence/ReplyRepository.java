package org.kidding.persistence;

import java.util.List;

import org.kidding.domain.FreeBoard;
import org.kidding.domain.FreeReply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReplyRepository extends CrudRepository<FreeReply, Long> {
	
	//?1은 첫번째 파라미터 타입으로 넣는 것?
	@Query("select r from FreeReply r where r.board = ?1 order by r.rno asc")
	public List<FreeReply> getListByBoard(FreeBoard board); 
	
	
	
}
