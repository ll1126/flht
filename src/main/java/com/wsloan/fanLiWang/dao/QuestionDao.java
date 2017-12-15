package com.wsloan.fanLiWang.dao;

import com.wsloan.fanLiWang.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionDao {
	/**
	 * 录入常见问题
	 * */
	Integer addQuestion(Question question);

	/**
	 * 常见问题详情
	 * */
	Question getQuestion(@Param("questionID") Integer questionID);

	/**
	 * 常见问题列表
	 * */
	List<Question> getQuestionList();

	/**
	 * 删除常见问题
	 * */
	Integer deleteQuestion(@Param("questionID") Integer questionID);

	Integer updateQuestion(Question question);
}
