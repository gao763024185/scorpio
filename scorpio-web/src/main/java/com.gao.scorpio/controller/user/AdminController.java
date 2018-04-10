package com.gao.scorpio.controller.user;

import com.gao.scorpio.entity.FileResult;
import com.gao.scorpio.entity.Logs;
import com.gao.scorpio.entity.BaseMenu;
import com.gao.scorpio.entity.BaseUser;
import com.gao.scorpio.json.JsonResp;
import com.gao.scorpio.service.LogsService;
import com.gao.scorpio.service.BaseMenuService;
import com.gao.scorpio.service.UserInfoService;
import com.gao.scorpio.service.FileUploadService;
import com.gao.scorpio.tools.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 后台controller
 * @author: gaobh
 * @date: 2016/12/16
 * @version: v1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
//    private final static Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Resource
    private UserInfoService userInfoService;

    @Resource
    private LogsService logsService;
    @Resource
    private BaseMenuService baseMenuService;
    String view_base = "/admin/";

    /**
     * 后台登录页
     *
     * @param model
     * @param uid
     * @return
     */
    @RequestMapping("/")
    public String loginPage(ModelMap model, @CookieValue(value = "uid", required = false) String uid) {
        if (uid == null) {
            return view_base + "login";
        } else {
            String returnUrl = "crainnogao_ad";
            int flag = 1;
            return crainnogao_ad(model, null, 1, flag, returnUrl, uid, null);
        }


    }

    /**
     * 登陆验证
     *
     * @param user
     * @param codeText
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginVal", method = RequestMethod.POST)
    @ResponseBody
    public Object loginVal(BaseUser user, @RequestParam(value = "codeText", required = false) String codeText,
                           HttpServletResponse response, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String validateCode = session.getAttribute("validateCode").toString();
        if (validateCode == null || validateCode == "") {
            return new JsonResp(JsonResp.Result_Fail, null, "验证码信息过期,请重新刷新输入", null);
        }
        if (!(codeText.equalsIgnoreCase(validateCode))) {
            return new JsonResp(JsonResp.Result_Fail, null, "验证码输入错误", null);
        }
        BaseUser baseUser = userInfoService.loginValid(user);
        if (baseUser == null) {
            return new JsonResp(JsonResp.Result_Fail, null, "用户名或密码输入错误", null);
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", String.valueOf(baseUser.getUid()));
        map.put("userName", baseUser.getUserName());
        //写入cookie
//        UserAgent userAgent = new UserAgent();
//        userAgent.setUid(String.valueOf(baseUser.getUid()));
//        userAgent.setUserName(baseUser.getUserName());
//        userAgent.setPassword(baseUser.getPassword());
        // Cookie

        Cookie cookieUid = new Cookie("uid", String.valueOf(baseUser.getUid()));
        cookieUid.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUid);

        Cookie cookieUserName = new Cookie("userName", baseUser.getUserName());
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);

        Cookie cookiePsw = new Cookie("password", baseUser.getPassword());
        cookiePsw.setMaxAge(24 * 60 * 60);
        response.addCookie(cookiePsw);

        return new JsonResp(JsonResp.Result_Success, null, null, map);
    }

    /**
     * 后台主界面
     *
     * @param model
     * @param logs1
     * @param pageNum
     * @param flag
     * @param returnUrl
     * @param uid
     * @param item
     * @return
     */
    @RequestMapping("/crainnogao_ad")
    public String crainnogao_ad(ModelMap model, Logs logs1, @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                @RequestParam(value = "flag", required = false) Integer flag,
                                @RequestParam(value = "returnUrl", required = false) String returnUrl,
                                @CookieValue(value = "uid", required = false) String uid,
                                @RequestParam(value = "item", required = false) String item) {

        if (uid == null) {
            return view_base + "login";
        }
        //编辑dairy
        if (logs1 != null) {
            Logs logDairy = logsService.getById(logs1.getLogId());
            model.addAttribute("logDairy", logDairy);
        }
        if (pageNum == null) {
            pageNum = 1;
        }
        int pageSize = 10;
        //用户信息显示
        List<BaseUser> user = userInfoService.findAll();
        model.addAttribute("list", user);
        model.addAttribute("userAvatar", user.get(0).getAvatar());
        //logs信息显示
        List<Logs> logs = logsService.findAll();
        Pager<Logs> logsPager = new Pager<Logs>(pageNum, pageSize, logs);
        model.addAttribute("listlogs", logsPager);
        model.addAttribute("item", item);
        model.addAttribute("pageNum", pageNum);
        //菜单列表
        List<BaseMenu> list = baseMenuService.findAll();
        model.addAttribute("listMenu", list);
        //筛选
        if (flag != null && flag == 1) {
            return "redirect:" + returnUrl;
        } else {
            return view_base + "crainnogao_ad";
        }
    }

    /**
     * 用户信息编辑
     *
     * @param modelMap
     * @param id
     * @return
     */
    @RequestMapping("/userEdit")
    public String userEdit(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {

        modelMap.addAttribute("id", id);
        BaseUser user = userInfoService.selectByPrimaryKey(id);
        modelMap.addAttribute("user", user);
        return view_base + "userinfoedit";
    }

    /**
     * 日志编辑
     *
     * @param id
     * @return
     */
    @RequestMapping("/dairyEdit")
    public String dairyEdit(@RequestParam(value = "id", required = false) Integer id) {

        return view_base + "dairyedit";
    }

    /**
     * 用户信息提交
     *
     * @param user
     * @param request
     * @param avatar
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/userinfoSubmit", method = RequestMethod.POST)
    @ResponseBody
    public String userinfoSubmit(@ModelAttribute BaseUser user, HttpServletRequest request,
                                 @RequestParam(value = "avatarSub", required = false) MultipartFile avatar
    ) throws IOException {
//        logger.error("----------userinfoSubmit start-----------");
        String cate = "avatar-user";
        FileResult fileResult = null;
        BaseUser baseUser = new BaseUser();

        if (avatar.getOriginalFilename() != null && avatar.getOriginalFilename() != "") {
//            logger.error("----------userinfoSubmit if-----------");
            fileResult = FileUploadService.picSubmit(request, cate, avatar, user.getUid());
            baseUser.setUid(user.getUid());
            baseUser.setUserName(user.getUserName());
            baseUser.setAvatar(fileResult.getAvatarUrl());
        } else {
            baseUser.setUid(user.getUid());
            baseUser.setUserName(user.getUserName());
        }
        userInfoService.updateByPrimaryKeySelective(baseUser);
        return null;
    }

}
