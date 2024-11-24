package com.ruoyi.system.service;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.industry224.CL10;

/**
 *   沥青溶解度试验检测记录  业务层
 */
public interface CL10Service
{
    /**
     * 根据条件分页查询  沥青溶解度试验检测记录 列表
     * 
     * @param cl10   沥青溶解度试验检测记录 信息
     * @return   沥青溶解度试验检测记录 信息集合信息
     */
    public PageInfo<CL10> selectCL10List(CL10 cl10, Integer pageNum,
                                         Integer pageSize);

    /**
     * 根据条件分页查询  沥青溶解度试验检测记录 列表 根据createdTime降序排序
     *
     * @param cl10   沥青溶解度试验检测记录 信息
     * @return   沥青溶解度试验检测记录 信息集合信息
     */
    public PageInfo<CL10> selectCL10ListOrderByCreatedTime(CL10 cl10, Integer pageNum,
                                         Integer pageSize);


    /**
     * 通过  沥青溶解度试验检测记录 ID查询  沥青溶解度试验检测记录 
     * 
     * @param id   沥青溶解度试验检测记录 ID
     * @return   沥青溶解度试验检测记录 对象信息
     */
    public CL10 selectCL10ById(Integer id);


    /**
     * 通过  沥青溶解度试验检测记录 记录编号查询  沥青溶解度试验检测记录
     *
     * @param jlbh   沥青溶解度试验检测记录 记录编号
     * @return   沥青溶解度试验检测记录 对象信息
     */
    public CL10 selectCL10ByJlbh(String jlbh);

    /**
     * 新增  沥青溶解度试验检测记录 信息
     * 
     * @param cl10   沥青溶解度试验检测记录 信息
     * @return 结果
     */
    public int insertCL10(CL10 cl10);
    /**
     * 修改  沥青溶解度试验检测记录 信息
     * 
     * @param cl10   沥青溶解度试验检测记录 信息
     * @return 结果
     */
    public int updateCL10(CL10 cl10);
    /**
     * 通过  沥青溶解度试验检测记录 ID删除  沥青溶解度试验检测记录 
     * 
     * @param id   沥青溶解度试验检测记录 ID
     * @return 结果
     */
    public int deleteCL10ById(Integer id);

    /**
     * 通过 沥青溶解度试验检测记录 ID删除  沥青溶解度试验检测记录
     *
     * @param jlbh  沥青溶解度试验检测记录 记录编号
     * @return 结果
     */
    public int deleteCL10ByJlbh(String jlbh);

    /**
     * 批量删除  沥青溶解度试验检测记录 信息
     * 
     * @param ids 需要删除的  沥青溶解度试验检测记录 ID
     * @return 结果
     */
    public int deleteCL10ByIds(Integer[] ids);
}
