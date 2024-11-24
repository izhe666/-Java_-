package com.ruoyi.system.service.impl;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.industry224.CL10;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.system.mapper.CL10Mapper;
import com.ruoyi.system.service.CL10Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 土壤数据 业务层处理
 *
 */
@Service
public class CL10ServiceImpl implements CL10Service {
    private static final Logger log = LoggerFactory.getLogger(CL10ServiceImpl.class);

    @Autowired
    private CL10Mapper cl10Mapper;

    /**
     * 根据条件分页查询土壤数据列表
     * 
     * @param cl10 土壤数据信息
     * @return 土壤数据信息集合信息
     */
    @Override
    public PageInfo<CL10> selectCL10List(CL10 cl10, Integer pageNum,
                                         Integer pageSize){
        // 使用分页插件pagehelper 进行分页
        PageUtils.startPage();
        return new PageInfo<>(cl10Mapper.selectCL10List(cl10));
    }

    public PageInfo<CL10> selectCL10ListOrderByCreatedTime(CL10 cl10, Integer pageNum,
                                         Integer pageSize){
        // 使用分页插件pagehelper 进行分页
        PageUtils.startPage();
        return new PageInfo<>(cl10Mapper.selectCL10ListOrderByCreatedTime(cl10));
    }
    
    /**
     * 通过土壤数据ID查询土壤数据
     * 
     * @param id 土壤数据ID
     * @return 土壤数据对象信息
     */
    @Override
    public CL10 selectCL10ById(Integer id) {
        return cl10Mapper.selectCL10ById(id);
    }

    /**
     * 通过记录编号查询
     *
     * @param jlbh 记录编号
     * @return 土壤数据对象信息
     */
    @Override
    public CL10 selectCL10ByJlbh(String jlbh) {
        return cl10Mapper.selectCL10ByJlbh(jlbh);
    }
    
    /**
     * 新增保存土壤数据信息
     * 
     * @param cl10 土壤数据信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCL10(CL10 cl10){
        // 新增土壤数据信息
        int rows = cl10Mapper.insertCL10(cl10);



        return rows;
    }
    
    /**
     * 修改保存土壤数据信息
     * 
     * @param cl10 土壤数据信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCL10(CL10 cl10) {
        return cl10Mapper.updateCL10(cl10);
    }
    
    /**
     * 通过土壤数据ID删除土壤数据
     * 
     * @param id 土壤数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCL10ById(Integer id){
        return cl10Mapper.deleteCL10ById(id);
    }

    /**
     * 通过 沥青溶解度试验检测记录 ID删除  沥青溶解度试验检测记录
     *
     * @param jlbh  沥青溶解度试验检测记录 记录编号
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCL10ByJlbh(String jlbh) {
        return cl10Mapper.deleteCL10ByJlbh(jlbh);
    }

    /**
     * 批量删除土壤数据信息
     * 
     * @param ids 需要删除的土壤数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCL10ByIds(Integer[] ids) {
        return cl10Mapper.deleteCL10ByIds(ids);
    }
    
}
