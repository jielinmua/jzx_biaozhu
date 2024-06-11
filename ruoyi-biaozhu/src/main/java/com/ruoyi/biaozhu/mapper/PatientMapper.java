package com.ruoyi.biaozhu.mapper;

import com.ruoyi.biaozhu.domain.Patient;

import java.util.List;


/**
 * 患者Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
public interface PatientMapper 
{
    /**
     * 查询患者
     * 
     * @param id 患者主键
     * @return 患者
     */
    public Patient selectPatientById(Long id);

    /**
     * 查询患者列表
     * 
     * @param patient 患者
     * @return 患者集合
     */
    public List<Patient> selectPatientList(Patient patient);

    /**
     * 新增患者
     * 
     * @param patient 患者
     * @return 结果
     */
    public int insertPatient(Patient patient);

    /**
     * 修改患者
     * 
     * @param patient 患者
     * @return 结果
     */
    public int updatePatient(Patient patient);

    /**
     * 删除患者
     * 
     * @param id 患者主键
     * @return 结果
     */
    public int deletePatientById(Long id);

    /**
     * 批量删除患者
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePatientByIds(Long[] ids);
}
