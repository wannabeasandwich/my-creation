package cn.tedu.csmall.sso.controller;

import cn.tedu.csmall.commons.pojo.admin.dto.AdminAddDTO;
import cn.tedu.csmall.commons.pojo.admin.dto.AdminLoginDTO;
import cn.tedu.csmall.commons.pojo.admin.vo.AdminListItemVO;
import cn.tedu.csmall.commons.restful.JsonResult;
import cn.tedu.csmall.sso.security.LoginPrincipal;
import cn.tedu.csmall.sso.service.IAdminService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员控制器
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@Api(tags = "1. 管理员管理模块")
@RestController
@RequestMapping("/admins")
public class AdminController {
    
    @Autowired
    private IAdminService adminService;

    public AdminController() {
        log.debug("创建控制器对象：AdminController");
    }

    // http://localhost:9081/admins/add-new
    @ApiOperation("添加管理员")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    @PreAuthorize("hasAuthority('/ams/admin/update')")
    public JsonResult addNew(@RequestBody AdminAddDTO adminAddDTO) {
        log.debug("接收到的请求参数：{}", adminAddDTO);
        adminService.addNew(adminAddDTO);
        return JsonResult.ok();
    }

    // http://localhost:9081/admins
    @ApiOperation("查询管理员列表")
    @ApiOperationSupport(order = 401)
    @GetMapping("")
    @PreAuthorize("hasAuthority('/ams/admin/read')")
    public JsonResult list(@AuthenticationPrincipal LoginPrincipal loginPrincipal) {

        log.debug("接收到查询管理员列表的请求");

        Long id = loginPrincipal.getId();
        log.debug("从认证信息中获取当前登录的管理员id:{}",id);
        String username = loginPrincipal.getUsername();
        log.debug("从认证信息中获取当前登录的管理员username:{}",username);

        List<AdminListItemVO> admins = adminService.list();
        return JsonResult.ok("OK",admins);
    }

    // @RequestBody 将前端传递给后端的JSON字符串的数据进行接收
    @ApiOperation("管理员登录")
    @ApiOperationSupport(order = 402)
    @PostMapping("/login")
    public JsonResult login(@RequestBody AdminLoginDTO adminLoginDTO){
        log.debug("接受到的请求参数：{}",adminLoginDTO);

        // 需要调用service组件处理登录
        String jwt = adminService.login(adminLoginDTO);

        return JsonResult.ok(jwt);
    }

}
