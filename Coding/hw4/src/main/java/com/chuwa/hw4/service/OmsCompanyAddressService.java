package com.chuwa.hw4.service;

import com.chuwa.hw4.entity.OmsCompanyAddress;
import com.chuwa.hw4.repository.OmsCompanyAddressJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/11/23$
 */
@Service
public class OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressJpaRepository omsCompanyAddressJpaRepository;

    public void saveOmsCompanyAddress(OmsCompanyAddress omsCompanyAddress) {
        omsCompanyAddressJpaRepository.save(omsCompanyAddress);
    }

    public OmsCompanyAddress getOmsCompanyAddressById(Long id) {
        OmsCompanyAddress omsCompanyAddress;
        try {
            omsCompanyAddress = omsCompanyAddressJpaRepository.getOmsCompanyAddressById(id);
            // 处理 omsCompanyAddress 对象
        } catch (Exception e) {
            // 处理异常，例如输出日志或返回错误信息
            e.printStackTrace();
            // 或者抛出自定义的异常
            return null;
        }
        return omsCompanyAddress;

    }

    public List<OmsCompanyAddress> getAll() {
        return omsCompanyAddressJpaRepository.findAll();
    }

    public List<OmsCompanyAddress> findTop3ByIdAsc() {
        return omsCompanyAddressJpaRepository.findTop3ByIdAsc();
    }

    @Transactional
    public void updateAllByPhonesToDefault() {
        omsCompanyAddressJpaRepository.updateAllByPhonesToDefault();
    }

    @Transactional
    public void deleteByAddressName(Long id){
        System.out.println(1);
        omsCompanyAddressJpaRepository.deleteById(id);
    }
}
