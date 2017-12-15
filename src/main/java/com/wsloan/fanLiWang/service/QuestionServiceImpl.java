package com.wsloan.fanLiWang.service;

import com.wsloan.fanLiWang.dao.ObjectListDao;
import com.wsloan.fanLiWang.dao.QuestionDao;
import com.wsloan.fanLiWang.entity.ObjectList;
import com.wsloan.fanLiWang.entity.Question;
import com.wsloan.fanLiWang.entity.RebateScheme;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Resource 
	private QuestionDao questionDao;
	/**
	 * 录入常见问题信息
	 * */
	public Integer addQuestion(Question question) {
		Integer num = questionDao.addQuestion(question);
		return num;
	}

	public Question getQuestion(Integer questionID) {
		Question question = questionDao.getQuestion(questionID);
		return question;
	}

	public List<Question> getQuestionList() {
		List<Question> list = questionDao.getQuestionList();
		return list;
	}

	public Integer deleteQuestion(Integer questionID) {
		Integer num = questionDao.deleteQuestion(questionID);
		return num;
	}

	public Integer updateQuestion(Question question) {
		Integer num = questionDao.updateQuestion(question);
		return num;
	}
}
