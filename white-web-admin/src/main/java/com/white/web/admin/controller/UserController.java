package com.white.web.admin.controller;

import com.white.common.dto.BaseResultDTO;
import com.white.common.dto.PaginationResultDTO;
import com.white.common.dto.dataTables.DataTableDTO;
import com.white.common.utils.MapperUtils;
import com.white.web.admin.dto.UserDTO;
import com.white.web.admin.dto.UserQueryDTO;
import com.white.web.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/3
 */
@Slf4j
@Controller
@RequestMapping(value = "/system/user")
public class UserController {
    private static final String USER_INDEX_PAGE = "views/system/userManage";
    private static final String USER_MODAL_VIEW = "views/system/userEditModal";

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView(USER_INDEX_PAGE);
    }

    @GetMapping(value = "initModalView")
    public String initModalView(Model model) {
        model.addAttribute("modalTitle","新增用户");
        return USER_MODAL_VIEW;
    }

    @RequestMapping(value = "page", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public DataTableDTO<UserDTO> page(HttpServletRequest request, UserQueryDTO userQueryDTO) throws Exception {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int pageSize = strLength == null ? 0 : Integer.parseInt(strLength);
        int pageNum = (start/ pageSize) + 1;

        String json = userService.page(pageNum, pageSize, MapperUtils.obj2json(userQueryDTO));
        PaginationResultDTO paginationResultDTO = null;
        try {
            paginationResultDTO = MapperUtils.json2pojo(json, PaginationResultDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataTableDTO<>(paginationResultDTO);
    }

    @PostMapping(value = "deleteForBatch")
    @ResponseBody
    public BaseResultDTO deleteForBatch(String[] ids) {
        // TODO 用户【批量删除】
        log.info(ids.toString());
        return BaseResultDTO.success();
    }
}
