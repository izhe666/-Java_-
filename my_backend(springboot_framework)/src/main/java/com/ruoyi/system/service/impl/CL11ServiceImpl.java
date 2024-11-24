package com.ruoyi.system.service.impl;
import com.github.pagehelper.PageInfo;

import com.ruoyi.common.core.domain.industry224.CL11;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.system.mapper.CL11Mapper;
import com.ruoyi.system.service.CL11Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 沥青闪点与燃点试验检测记录 业务层处理
 *
 */
@Service
public class CL11ServiceImpl implements CL11Service {
    private static final Logger log = LoggerFactory.getLogger(CL11ServiceImpl.class);

    @Autowired
    private CL11Mapper cl11Mapper;

    /**
     * 根据条件分页查询沥青闪点与燃点试验检测记录列表
     * 
     * @param cl11 沥青闪点与燃点试验检测记录信息
     * @return 沥青闪点与燃点试验检测记录信息集合信息
     */
    @Override
    public PageInfo<CL11> selectCL11List(CL11 cl11, Integer pageNum,
                                         Integer pageSize){
        // 使用分页插件pagehelper 进行分页
        PageUtils.startPage();
        return new PageInfo<>(cl11Mapper.selectCL11List(cl11));
    }
    
    /**
     * 通过沥青闪点与燃点试验检测记录ID查询沥青闪点与燃点试验检测记录
     * 
     * @param id 沥青闪点与燃点试验检测记录ID
     * @return 沥青闪点与燃点试验检测记录对象信息
     */
    @Override
    public CL11 selectCL11ById(Long id) {
        return cl11Mapper.selectCL11ById(id);
    }
    
    /**
     * 新增保存沥青闪点与燃点试验检测记录信息
     * 
     * @param cl11 沥青闪点与燃点试验检测记录信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCL11(CL11 cl11){
        // 新增沥青闪点与燃点试验检测记录信息
        int rows = cl11Mapper.insertCL11(cl11);
        return rows;
    }
    
    /**
     * 修改保存沥青闪点与燃点试验检测记录信息
     * 
     * @param cl11 沥青闪点与燃点试验检测记录信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCL11(CL11 cl11) {
        return cl11Mapper.updateCL11(cl11);
    }
    
    /**
     * 通过沥青闪点与燃点试验检测记录ID删除沥青闪点与燃点试验检测记录
     * 
     * @param id 沥青闪点与燃点试验检测记录ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCL11ById(Long id){
        return cl11Mapper.deleteCL11ById(id);
    }

    /**
     * 批量删除沥青闪点与燃点试验检测记录信息
     * 
     * @param ids 需要删除的沥青闪点与燃点试验检测记录ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCL11ByIds(Long[] ids) {
        return cl11Mapper.deleteCL11ByIds(ids);
    }
    
}
