package com.wsloan.fanLiWang.service;

import com.wsloan.fanLiWang.dao.CountMessageDao;
import com.wsloan.fanLiWang.dao.NoticeDao;
import com.wsloan.fanLiWang.entity.CountMessage;
import com.wsloan.fanLiWang.entity.Notice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CountMessageServiceImpl implements CountMessageService {
	@Resource
	private CountMessageDao countMessageDao;
	public List<CountMessage> getCountMessage(String submissionTimeStart, String submissionTimeEnd) {
		List<CountMessage> list = countMessageDao.getCountMessage(submissionTimeStart,submissionTimeEnd);
		return list;
	}

	public List<Map> getZuoRiShuJu(String date_start,String date_end) {
		String d = date_end;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");/*** 加一天*/
		try {
			if(d!=null&& d.length()> 0){
				Date dd = df.parse(d);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dd);
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				String ss = df.format(calendar.getTime());
				date_end=ss;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Map> list = new ArrayList<Map>();
		Map map = countMessageDao.getZuoRiReceipt(date_start,date_end);
		list.add(map);
		map = countMessageDao.getRegistPeople(date_start,date_end);
		list.add(map);
		map = countMessageDao.getInvestMoney(date_start,date_end);
		list.add(map);
		map = countMessageDao.getZuoRiBangKa(date_start,date_end);
		list.add(map);
		map=countMessageDao.getRegistPeopleSum();
		list.add(map);
		map = countMessageDao.getBangKaSum();
		list.add(map);
		map=countMessageDao.getReceiptSum();
		list.add(map);
		map=countMessageDao.getInvestMoneySum();
		list.add(map);
		return list;
	}

	public List<Map> getTotalShuJu() {
		List<Map> list = new ArrayList<Map>();
		Map map = countMessageDao.getRegistPeopleSum();
		list.add(map);
		map = countMessageDao.getBangKaSum();
		list.add(map);
		map=countMessageDao.getReceiptSum();
		list.add(map);
		map=countMessageDao.getInvestMoneySum();
		list.add(map);
		return list;
	}

/*
* 昨日时间
* 		Calendar cal   =   Calendar.getInstance();
		cal.add(Calendar.DATE,   -1);
		String yesterday = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
* */
}
