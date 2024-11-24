package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.industry224.CS22Record;

import java.util.List;

/**
 * 砼试表CS22表 数据层
 *
 * ctrl+R 替换
 */
public interface CS22RecordMapper
{
    /**
     * 根据条件分页查询砼试表CS22列表
     *
     * @param cs22Record 砼试表CS22信息
     * @return 砼试表CS22信息集合信息
     */
    public List<CS22Record> selectCS22RecordList(CS22Record cs22Record);

    /**
     * 通过砼试表CS22ID查询砼试表CS22
     *
     * @param id 砼试表CS22ID
     * @return 砼试表CS22对象信息
     */
    public CS22Record selectCS22RecordById(Long id);

    /**
     * 新增砼试表CS22信息
     *
     * @param cs22Record 砼试表CS22信息
     * @return 结果
     */
    public int insertCS22Record(CS22Record cs22Record);

    /**
     * 修改砼试表CS22信息
     *
     * @param cs22Record 砼试表CS22信息
     * @return 结果
     */
    public int updateCS22Record(CS22Record cs22Record);

    /**
     * 通过砼试表CS22ID删除砼试表CS22
     *
     * @param id 砼试表CS22ID
     * @return 结果
     */
    public int deleteCS22RecordById(Long id);

    /**
     * 批量删除砼试表CS22信息
     *
     * @param ids 需要删除的砼试表CS22ID
     * @return 结果
     */
    public int deleteCS22RecordByIds(Long[] ids);

}
