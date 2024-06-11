package com.ruoyi.biaozhu.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ruoyi.biaozhu.domain.Patient;
import com.ruoyi.biaozhu.mapper.PatientMapper;
import com.ruoyi.biaozhu.service.IPatientService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 患者Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
@Service
public class PatientServiceImpl implements IPatientService
{
    @Autowired
    private PatientMapper patientMapper;

    /**
     * 查询患者
     * 
     * @param id 患者主键
     * @return 患者
     */
    @Override
    public Patient selectPatientById(Long id)
    {
        return patientMapper.selectPatientById(id);
    }

    /**
     * 查询患者列表
     * 
     * @param patient 患者
     * @return 患者
     */
    @Override
    public List<Patient> selectPatientList(Patient patient)
    {
        return patientMapper.selectPatientList(patient);
    }

    /**
     * 新增患者
     * 
     * @param patient 患者
     * @return 结果
     */
    @Override
    public int insertPatient(Patient patient)
    {
        if (StringUtils.isEmpty(patient.getPatientId())){
            patient.setPatientId(getNo());
        }

        patient.setCreateTime(DateUtils.getNowDate());
        return patientMapper.insertPatient(patient);
    }
    public String getNo() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10);
        }
        return newDate + result;
    }
    /**
     * 修改患者
     * 
     * @param patient 患者
     * @return 结果
     */
    @Override
    public int updatePatient(Patient patient)
    {
        patient.setUpdateTime(DateUtils.getNowDate());
        return patientMapper.updatePatient(patient);
    }

    /**
     * 批量删除患者
     * 
     * @param ids 需要删除的患者主键
     * @return 结果
     */
    @Override
    public int deletePatientByIds(Long[] ids)
    {
        return patientMapper.deletePatientByIds(ids);
    }

    /**
     * 删除患者信息
     * 
     * @param id 患者主键
     * @return 结果
     */
    @Override
    public int deletePatientById(Long id)
    {
        return patientMapper.deletePatientById(id);
    }
}
