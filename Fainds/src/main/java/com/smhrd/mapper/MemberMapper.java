package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	// 시간 조회
		public String date();
}
