package com.ruoyi.biaozhu.service;

import com.ruoyi.biaozhu.domain.Patient;

import java.util.List;

/**
 * 患者Service接口
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
public interface IPatientService 
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
    public Patient insertPatient(Patient patient);

    /**
     * 修改患者
     * 
     * @param patient 患者
     * @return 结果
     */
    public int updatePatient(Patient patient);

    /**
     * 批量删除患者
     * 
     * @param ids 需要删除的患者主键集合
     * @return 结果
     */
    public int deletePatientByIds(Long[] ids);

    /**
     * 删除患者信息
     * 
     * @param id 患者主键
     * @return 结果
     */
    public int deletePatientById(Long id);
}
