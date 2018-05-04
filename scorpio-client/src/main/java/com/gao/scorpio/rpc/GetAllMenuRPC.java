package com.gao.scorpio.rpc;

import com.gao.scorpio.dto.BaseMenuDTO;

import java.util.List;

/**
 * @description 获取所有目录的远程rpc接口
 * @author: gaobh
 * @date: 2018/4/12 9:33
 * @version: v1.0
 */
public interface GetAllMenuRPC {
    /**
     * 获取目录list
     * @return
     */
    List<BaseMenuDTO> getAllMenu();
}
