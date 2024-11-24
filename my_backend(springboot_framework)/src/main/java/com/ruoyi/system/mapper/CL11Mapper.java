package com.ruoyi.system.mapper;



import com.ruoyi.common.core.domain.industry224.CL11;

import java.util.List;

/**
 * 沥青闪点与燃点试验检测记录表表 数据层
 *
 * ctrl+R 替换
 */
public interface CL11Mapper
{
    /**
     * 根据条件分页查询沥青闪点与燃点试验检测记录表列表
     *
     * @param cl11 沥青闪点与燃点试验检测记录表信息
     * @return 沥青闪点与燃点试验检测记录表信息集合信息
     */
    public List<CL11> selectCL11List(CL11 cl11);

    /**
     * 通过沥青闪点与燃点试验检测记录表ID查询沥青闪点与燃点试验检测记录表
     *
     * @param id 沥青闪点与燃点试验检测记录表ID
     * @return 沥青闪点与燃点试验检测记录表对象信息
     */
    public CL11 selectCL11ById(Long id);

    /**
     * 新增沥青闪点与燃点试验检测记录表信息
     *
     * @param cl11 沥青闪点与燃点试验检测记录表信息
     * @return 结果
     */
    public int insertCL11(CL11 cl11);

    /**
     * 修改沥青闪点与燃点试验检测记录表信息
     *
     * @param cl11 沥青闪点与燃点试验检测记录表信息
     * @return 结果
     */
    public int updateCL11(CL11 cl11);

    /**
     * 通过沥青闪点与燃点试验检测记录表ID删除沥青闪点与燃点试验检测记录表
     *
     * @param id 沥青闪点与燃点试验检测记录表ID
     * @return 结果
     */
    public int deleteCL11ById(Long id);

    /**
     * 批量删除沥青闪点与燃点试验检测记录表信息
     *
     * @param ids 需要删除的沥青闪点与燃点试验检测记录表ID
     * @return 结果
     */
    public int deleteCL11ByIds(Long[] ids);

}
