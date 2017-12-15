package com.wsloan.fanLiWang.controller;

import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.Question;
import com.wsloan.fanLiWang.service.QuestionService;
import com.wsloan.fanLiWang.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    @RequestMapping("/addQuestion.do")
    @ResponseBody
    public JsonResult addQuestion(Question question, HttpSession session){
        BackgroundUser backgroundUser =(BackgroundUser) session.getAttribute("user");
        if(backgroundUser==null){
            return  new JsonResult(1,"","未登录，请重新登录");
        }
        Integer num = questionService.addQuestion(question);
        if(num==null){
            return new JsonResult(1,"","录入失败");
        }else{
            return new JsonResult(0,num,"录入成功");
        }
    }

    @RequestMapping("/getQuestion.do")
    @ResponseBody
    public JsonResult getQuestion(Integer questionID,HttpSession session){
        BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
        if(backgroundUser==null){
            return new JsonResult(1,"","未登录，请重新登录");
        }
        Question question = questionService.getQuestion(questionID);
        return  new JsonResult(0,question,"");
    }

    @RequestMapping("/getQuestionList.do")
    @ResponseBody
    public JsonResult getQuestionList(HttpSession session){
        BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
        if(backgroundUser==null){
            return  new JsonResult(1,"","未登录，请重新登录");
        }
        List<Question> list = questionService.getQuestionList();
        return new JsonResult(0,list,"");
    }

    @RequestMapping("/deleteQuestion.do")
    @ResponseBody
    public JsonResult deleteQuestion(HttpSession session,Integer questionID){
        BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
        if(backgroundUser==null){
            return  new JsonResult(1,"","未登录，请重新登录");
        }
        Integer num = questionService.deleteQuestion(questionID);
        if(num==null){
            return  new JsonResult(1,"","删除失败");
        }
        return new JsonResult(0,num,"删除成功");
    }

    @RequestMapping("/updateQuestion.do")
    @ResponseBody
    public JsonResult updateQuestion(HttpSession session,Question question){
        BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
        if(backgroundUser==null){
            return  new JsonResult(1,"","未登录，请重新登录");
        }
        Integer num = questionService.updateQuestion(question);
        if(num==null){
            return  new JsonResult(1,"","修改失败");
        }
        return new JsonResult(0,num,"修改成功");
    }

}
