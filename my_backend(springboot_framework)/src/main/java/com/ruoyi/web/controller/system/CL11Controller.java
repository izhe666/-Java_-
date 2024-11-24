package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;

import com.ruoyi.common.core.domain.industry224.CL11;
import com.ruoyi.system.service.CL11Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 控制层
 */
@RestController
public class CL11Controller
{
    @Autowired
    private CL11Service cl11Service;

    /**
     *  分页查询
     */
    @GetMapping("/getCL11s")
    public AjaxResult getCL11s(CL11 cl11, Integer pageNum,
                               Integer pageSize)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(
                cl11Service.selectCL11List(cl11, pageNum, pageSize));
        ajax.put("code", 0);
        ajax.put("msg", "查询成功");
        return ajax;
    }

    /**
     *  单个查询
     */
    @GetMapping("/getCL11/{id}")
    public AjaxResult getCL11(@PathVariable("id") Long id)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(
                cl11Service.selectCL11ById(id));
        ajax.put("code", 0);
        ajax.put("msg", "查询成功");
        return ajax;
    }

    /**
     *  添加
     */
    @PostMapping("/addCL11")
    public AjaxResult addCL11(@RequestBody CL11 cl11)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类

        cl11.setSdpjz();//插入前调用计算闪点平均值
        cl11.setRdpjz();//插入前调用计算闪点平均值

        AjaxResult ajax = AjaxResult.success(cl11Service.insertCL11(cl11));
        ajax.put("code", 0);
        ajax.put("msg", "插入成功");
        return ajax;
    }

    /**
     *  修改
     */
    @PutMapping("/editCL11")
    public AjaxResult editCL11(@RequestBody CL11 cl11)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(cl11Service.updateCL11(cl11));
        ajax.put("code", 0);
        ajax.put("msg", "修改成功");
        return ajax;
    }

    /**
     *  删除
     */
    @DeleteMapping("/deleteCL11/{id}")
    public AjaxResult deleteCL11(@PathVariable("id") Long id)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(cl11Service.deleteCL11ById(id));
        ajax.put("code", 0);
        ajax.put("msg", "删除成功");
        return ajax;
    }


}
