package com.gao.scorpio.controller.logs;

import com.gao.scorpio.entity.Logs;
import com.gao.scorpio.entity.LogsExample;
import com.gao.scorpio.json.JsonResp;
import com.gao.scorpio.service.LogsService;
import com.gao.scorpio.tools.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @description 日志controller
 * @author: gaobh
 * @date: 2016/12/22
 * @version: v1.0
 */
@Controller
public class LogsInfoController {

    @Resource
    private LogsService logsService;

    /**
     * 日志提交
     *
     * @param codeText
     * @param request
     * @param logs
     * @return
     */
    @RequestMapping(value = "/issue")
    @ResponseBody
    public Object issue(@RequestParam(value = "codeText", required = false) String codeText, HttpServletRequest request,
                        Logs logs) {
        HttpSession session = request.getSession();
        String validateCode = session.getAttribute("validateCode").toString();
        if (!(codeText.equalsIgnoreCase(validateCode))) {
            return new JsonResp(JsonResp.Result_Fail, null, "验证码输入错误", null);
        }
        if (logs.getLogId() != null && logs.getLogId() != "") {
            Logs logsUpdate = new Logs();
            logsUpdate.setLogId(logs.getLogId());
            logsUpdate.setLogTitle(logs.getLogTitle());
            logsUpdate.setLogSummary(logs.getLogSummary());
            logsUpdate.setLogContent(logs.getLogContent());
            logsUpdate.setLogUpdate(new Date());
            logsService.updateByPrimaryKeySelective(logsUpdate);
        } else {
            logs.setLogId(DateUtil.format(new Date(), "yyMMddHHmm"));
            logs.setLogCreated(new Date());
            logs.setLogUpdate(new Date());
            logsService.insert(logs);
        }
        return new JsonResp(JsonResp.Result_Success, null, null, null);
    }

    /**
     * 删除日志
     *
     * @param logId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(@RequestParam(value = "logId", required = false) String logId) {
        logsService.deleteByPrimaryKey(logId);
        return new JsonResp(JsonResp.Result_Success, null, null, null);
    }

    /**
     * 搜索日志
     *
     * @param logs
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public Object search(Logs logs) {

        LogsExample logsExample = new LogsExample();
        logsExample.or().andLogTitleLike("%" + logs.getLogTitle() + "%");
        List<Logs> example = logsService.selectByExample(logsExample);

        return example;
    }
}
