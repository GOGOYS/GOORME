package com.callor.memo.persistance;

import java.util.List;

import com.callor.memo.model.FollowVO;

public interface FollowDao {
	
	public List<FollowVO> selectAll();
	public FollowVO findById(Long seq);
	public int insert(FollowVO followVO);
	public int update(FollowVO followVO);
	public int delete(Long seq);
}
