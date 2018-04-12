package com.gao.scorpio.service.rpc;

import com.gao.scorpio.dto.BaseMenuDTO;
import com.gao.scorpio.entity.BaseMenu;
import com.gao.scorpio.rpc.GetAllMenuRPC;
import com.gao.scorpio.service.BaseMenuService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: gaobh
 * @date: 2018/4/12 9:38
 * @version: v1.0
 */
@Component
public class GetAllMenuRPCImpl implements GetAllMenuRPC {

    @Resource
    private BaseMenuService baseMenuService;

    /**
     * 获取目录list
     *
     * @return
     */
    @Override
    public List<BaseMenuDTO> getAllMenu() {
        List<BaseMenu> menuList = baseMenuService.findAll();
        List<BaseMenuDTO> menuDTOList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(menuList)) {
            for (BaseMenu menu : menuList) {
                if (null != menu){
                    BaseMenuDTO dto = new BaseMenuDTO();
                    BeanUtils.copyProperties(menu,dto);
                    menuDTOList.add(dto);
                }
            }
        }
        return menuDTOList;
    }
}
