package com.wsloan.fanLiWang.service;

import com.wsloan.fanLiWang.entity.ObjectList;
import com.wsloan.fanLiWang.entity.Question;

import java.util.List;

public interface QuestionService {
	/**
	 * 录入常见问题
	 * */

	Integer addQuestion(Question question);

	/**
	 * 获取常见问题详情
	 */
	Question getQuestion(Integer questionID);

	/**
	 * 常见问题列表
	 * */
	List<Question> getQuestionList();

	/**
	 * 删除常见问题
	 * */
	Integer deleteQuestion(Integer questionID);

	/**
	 * 修改问题
	 * */
	Integer updateQuestion(Question question);

}
