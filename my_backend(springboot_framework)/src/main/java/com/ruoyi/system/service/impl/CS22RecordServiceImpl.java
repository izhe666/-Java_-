package com.ruoyi.system.service.impl;
import com.github.pagehelper.PageInfo;

import com.ruoyi.common.core.domain.industry224.CS22Record;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.system.mapper.CS22RecordMapper;
import com.ruoyi.system.service.CS22RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 砼试表CS22 业务层处理
 *
 */
@Service
public class CS22RecordServiceImpl implements CS22RecordService {
    private static final Logger log = LoggerFactory.getLogger(CS22RecordServiceImpl.class);

    @Autowired
    private CS22RecordMapper cs22RecordMapper;

    /**
     * 根据条件分页查询砼试表CS22列表
     * 
     * @param cs22Record 砼试表CS22信息
     * @return 砼试表CS22信息集合信息
     */
    @Override
    public PageInfo<CS22Record> selectCS22RecordList(CS22Record cs22Record, Integer pageNum,
                                                     Integer pageSize){
        // 使用分页插件pagehelper 进行分页
        PageUtils.startPage();
        return new PageInfo<>(cs22RecordMapper.selectCS22RecordList(cs22Record));
    }
    
    /**
     * 通过砼试表CS22ID查询砼试表CS22
     * 
     * @param id 砼试表CS22ID
     * @return 砼试表CS22对象信息
     */
    @Override
    public CS22Record selectCS22RecordById(Long id) {
        return cs22RecordMapper.selectCS22RecordById(id);
    }
    
    /**
     * 新增保存砼试表CS22信息
     * 
     * @param cs22Record 砼试表CS22信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCS22Record(CS22Record cs22Record){
        // 新增砼试表CS22信息
        System.out.println(cs22Record);
        int rows = cs22RecordMapper.insertCS22Record(cs22Record);
        return rows;
    }
    
    /**
     * 修改保存砼试表CS22信息
     * 
     * @param cs22Record 砼试表CS22信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCS22Record(CS22Record cs22Record) {
        return cs22RecordMapper.updateCS22Record(cs22Record);
    }
    
    /**
     * 通过砼试表CS22ID删除砼试表CS22
     * 
     * @param id 砼试表CS22ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCS22RecordById(Long id){
        return cs22RecordMapper.deleteCS22RecordById(id);
    }

    /**
     * 批量删除砼试表CS22信息
     * 
     * @param ids 需要删除的砼试表CS22ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCS22RecordByIds(Long[] ids) {
        return cs22RecordMapper.deleteCS22RecordByIds(ids);
    }
    
}
