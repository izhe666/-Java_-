package com.ruoyi.system.service;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.industry224.CL11;


/**
 * 沥青闪点与燃点试验检测记录 业务层
 */
public interface CL11Service
{
    /**
     * 根据条件分页查询沥青闪点与燃点试验检测记录列表
     * 
     * @param cl11 沥青闪点与燃点试验检测记录信息
     * @return 沥青闪点与燃点试验检测记录信息集合信息
     */
    public PageInfo<CL11> selectCL11List(CL11 cl11, Integer pageNum,
                                         Integer pageSize);
    /**
     * 通过沥青闪点与燃点试验检测记录ID查询沥青闪点与燃点试验检测记录
     * 
     * @param id 沥青闪点与燃点试验检测记录ID
     * @return 沥青闪点与燃点试验检测记录对象信息
     */
    public CL11 selectCL11ById(Long id);
    /**
     * 新增沥青闪点与燃点试验检测记录信息
     * 
     * @param cl11 沥青闪点与燃点试验检测记录信息
     * @return 结果
     */
    public int insertCL11(CL11 cl11);
    /**
     * 修改沥青闪点与燃点试验检测记录信息
     * 
     * @param cl11 沥青闪点与燃点试验检测记录信息
     * @return 结果
     */
    public int updateCL11(CL11 cl11);
    /**
     * 通过沥青闪点与燃点试验检测记录ID删除沥青闪点与燃点试验检测记录
     * 
     * @param id 沥青闪点与燃点试验检测记录ID
     * @return 结果
     */
    public int deleteCL11ById(Long id);
    /**
     * 批量删除沥青闪点与燃点试验检测记录信息
     * 
     * @param ids 需要删除的沥青闪点与燃点试验检测记录ID
     * @return 结果
     */
    public int deleteCL11ByIds(Long[] ids);
}
