package com.gao.scorpio.service;

import com.gao.scorpio.DateUtil;
import com.gao.scorpio.entity.FileResult;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Created by 高保红 on 2017/2/21.
 */
@Service
public class FileUploadService {
//    private final static Logger logger = LoggerFactory.getLogger(FileUploadService.class);
    private static final Random r1 = new Random(System.currentTimeMillis() + 1);
    private static final Random r2 = new Random(System.currentTimeMillis() + 2);
    private static final Random r3 = new Random(System.currentTimeMillis() + 3);

    public static FileResult picSubmit(HttpServletRequest request, String cate, MultipartFile oriFile, Integer id) {

//        logger.error("----------fileResult start-----------");
        String orginName = oriFile.getOriginalFilename();
        int len = orginName.lastIndexOf(".");
        String suffix = orginName.substring(len, orginName.length());
        String avatar = "files/picture/" + DateUtil.format(new Date(), "yyyyMMdd/") + cate + "/";
//        logger.error("----------avatar-----------" + avatar);
        String realPath = request.getSession().getServletContext().getRealPath("/");
//        logger.error("----------realPath-----------" + realPath);
        String fileName = getRandomFileName() + suffix;
        try {
            String avatar1 = "files/picture/" + DateUtil.format(new Date(), "yyyyMMdd/") + cate;
            File file = new File(FilenameUtils.concat(realPath, avatar1));
//            logger.error("----------file-----------" + file.getAbsolutePath());
            //判断文件是否存在
            if (!file.exists() && !file.isDirectory()) {
//                logger.error("----------no exist-----------");
                System.out.println(realPath + "目录不存在，需要创建");
                file.mkdirs();
//                logger.error("----------hava exist-----------");
            }
            //检出目标文件是否重复
            File folder = new File(FilenameUtils.concat(realPath, avatar));
//            logger.error("----------folder-----------" + folder.getAbsolutePath());
//            logger.error("----------fileName-----------" + fileName);
            File destFile = null;
            destFile = new File(folder, fileName);
//            logger.error("----------destFile-----------" + destFile.getAbsolutePath());
            if (destFile.exists()) {
//                logger.error("----------destFile----exists-------" + destFile.getAbsolutePath());
                destFile.delete();
                destFile = new File(folder, fileName);
            }
            oriFile.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileResult fileResult = new FileResult();
        fileResult.setId(id);
        fileResult.setOrginName(orginName);
        fileResult.setFileName(fileName);
        fileResult.setAvatarUrl(avatar + fileName);
        return fileResult;

    }

    private static String getRandomFileName() {
        int len = 5;
        int range = (int) Math.pow(10, len) - 1;
        return StringUtils.leftPad(String.valueOf(r1.nextInt(range) + 1), len, "0")
                + "-" + StringUtils.leftPad(String.valueOf(r2.nextInt(range) + 1), len, "0")
                + "-" + StringUtils.leftPad(String.valueOf(r3.nextInt(range) + 1), len, "0");
    }
}
