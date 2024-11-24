package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;

import com.ruoyi.common.core.domain.industry224.CL10;
import com.ruoyi.system.service.CL10Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 控制层
 */
@RestController
public class CL10Controller
{
    @Autowired
    private CL10Service cl10Service;

    /**
     *  分页查询
     */
    @GetMapping("/getCL10s")
    public AjaxResult getCL10s(CL10 cl10, Integer pageNum,
                               Integer pageSize)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(
                cl10Service.selectCL10List(cl10, pageNum, pageSize));
        ajax.put("code", 0);
        ajax.put("msg", "查询成功");
        return ajax;
    }

    @GetMapping("/getCL10sOrderByCreatedTime")
    public AjaxResult getCL10sOrderByCreatedTime(CL10 cl10, Integer pageNum,
                               Integer pageSize)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(
                cl10Service.selectCL10ListOrderByCreatedTime(cl10, pageNum, pageSize));
        ajax.put("code", 0);
        ajax.put("msg", "查询成功");
        return ajax;
    }


    /**
     *  单个查询
     */
    @GetMapping("/getCL10/{id}")
    public AjaxResult getCL10(@PathVariable("id") Integer id)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(
                cl10Service.selectCL10ById(id));
        ajax.put("code", 0);
        ajax.put("msg", "查询成功");
        return ajax;
    }

    @GetMapping("/getCL10ByJlbh/{jlbh}")
    public AjaxResult getCL10(@PathVariable("jlbh") String jlbh)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(
                cl10Service.selectCL10ByJlbh(jlbh));
        ajax.put("code", 0);
        ajax.put("msg", "查询成功");
        return ajax;
    }

    /**
     *  添加
     */
    @PostMapping("/addCL10")
    public AjaxResult addCL10(@RequestBody CL10 cl10)
    {
        cl10.setCreatedTime(new Date());
        cl10.setLastUpdatedTime(new Date());

        System.out.println("\n\n\n\n\n\n----------------------------------");
        System.out.println(cl10.getSyjcrq() + "\n" + cl10.getScrq());
        System.out.println("----------------------------------\n\n\n\n\n\n");

        //于此处计算蓝色单元格内容
        cl10.setSb1((1-((cl10.m4-cl10.m1+cl10.m5-cl10.m2)/(cl10.m3-cl10.m2)))*100);
        cl10.setSb2((1-((cl10.a4-cl10.a1+cl10.a5-cl10.a2)/(cl10.a3-cl10.a2)))*100);
        cl10.setSb((cl10.getSb1()+cl10.getSb2())/2);

        // AjaxResult 若依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(cl10Service.insertCL10(cl10));
        ajax.put("code", 0);
        ajax.put("msg", "插入成功");
        return ajax;
    }

    /**
     *  修改
     */
    @PutMapping("/editCL10")
    public AjaxResult editCL10(@RequestBody CL10 cl10)
    {

        cl10.setLastUpdatedTime(new Date());
        cl10.setSb1((1-((cl10.m4-cl10.m1+cl10.m5-cl10.m2)/(cl10.m3-cl10.m2)))*100);
        cl10.setSb2((1-((cl10.a4-cl10.a1+cl10.a5-cl10.a2)/(cl10.a3-cl10.a2)))*100);
        cl10.setSb((cl10.getSb1()+cl10.getSb2())/2);

        // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(cl10Service.updateCL10(cl10));
        ajax.put("code", 0);
        ajax.put("msg", "修改成功");
        return ajax;
    }

    /**
     *  删除
     */
    //根据ID删除
    @DeleteMapping("/deleteCL10ById/{id}")
    public AjaxResult deleteCL10(@PathVariable("id") Integer id)
    {
        // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(cl10Service.deleteCL10ById(id));
        ajax.put("code", 0);
        ajax.put("msg", "删除成功");
        return ajax;
    }

    @DeleteMapping("/deleteCL10ByIds/{ids}")
    public AjaxResult deleteCL10s(@PathVariable("ids") Integer[] ids)
    {
        System.out.println("\n\n\n\n\n\n---------------------------------");
        System.out.println(ids);
        System.out.println("---------------------------------------\n\n\n\n\n\n");
        // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(cl10Service.deleteCL10ByIds(ids));
        ajax.put("code", 0);
        ajax.put("msg", "删除成功");
        return ajax;
    }

    //根据记录编号删除
    @DeleteMapping("/deleteCL10ByJlbh/{jlbh}")
    public AjaxResult deleteCL10(@PathVariable("jlbh") String jlbh)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(cl10Service.deleteCL10ByJlbh(jlbh));
        ajax.put("code", 0);
        ajax.put("msg", "删除成功");
        return ajax;
    }
}
