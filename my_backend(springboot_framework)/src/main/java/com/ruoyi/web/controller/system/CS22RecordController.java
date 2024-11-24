package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;

import com.ruoyi.common.core.domain.industry224.CS22Record;
import com.ruoyi.system.service.CS22RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 控制层
 */
@RestController
public class CS22RecordController
{
    @Autowired
    private CS22RecordService cs22RecordService;

    /**
     *  分页查询
     */
    @GetMapping("/getCS22Records")
    public AjaxResult getCS22Records(CS22Record cs22Record, Integer pageNum,
                                     Integer pageSize)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(
                cs22RecordService.selectCS22RecordList(cs22Record, pageNum, pageSize));
        ajax.put("code", 0);
        ajax.put("msg", "查询成功");
        return ajax;
    }

    /**
     *  单个查询
     */
    @GetMapping("/getCS22Record/{id}")
    public AjaxResult getCS22Record(@PathVariable("id") Long id)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(
                cs22RecordService.selectCS22RecordById(id));
        ajax.put("code", 0);
        ajax.put("msg", "查询成功");
        return ajax;
    }

    /**
     *  添加
     */
    @PostMapping("/addCS22Record")
    public AjaxResult addCS22Record(@RequestBody CS22Record cs22Record)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(cs22RecordService.insertCS22Record(cs22Record));
        ajax.put("code", 0);
        ajax.put("msg", "插入成功");
        return ajax;
    }

    /**
     *  修改
     */
    @PutMapping("/editCS22Record")
    public AjaxResult editCS22Record(@RequestBody CS22Record cs22Record)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(cs22RecordService.updateCS22Record(cs22Record));
        ajax.put("code", 0);
        ajax.put("msg", "修改成功");
        return ajax;
    }

    /**
     *  删除
     */
    @DeleteMapping("/deleteCS22Record/{id}")
    public AjaxResult deleteCS22Record(@PathVariable("id") Long id)
    {   // AjaxResult 诺依包装返回指定数据格式给前端的处理类
        AjaxResult ajax = AjaxResult.success(cs22RecordService.deleteCS22RecordById(id));
        ajax.put("code", 0);
        ajax.put("msg", "删除成功");
        return ajax;
    }


}
