package com.chuwa.hw4.controller;

import com.chuwa.hw4.entity.OmsCompanyAddress;
import com.chuwa.hw4.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/11/23$
 */
@RestController
public class OmsCompanyAddressController {
    @Autowired
    OmsCompanyAddressService omsCompanyAddressService;

    @PostMapping(value = "oms-company-addresses")
    public String saveOmsCompanyAddress(@RequestBody OmsCompanyAddress omsCompanyAddress){
        omsCompanyAddressService.saveOmsCompanyAddress(omsCompanyAddress);
        return "save successfully";
    }

    @GetMapping(value = "oms-company-addresses/{id}")
    public OmsCompanyAddress getOmsCompanyAddressById(@PathVariable Long id){
        return omsCompanyAddressService.getOmsCompanyAddressById(id);
    }

    @GetMapping(value = "oms-company-addresses/all")
    public List<OmsCompanyAddress> getAll(){
        return omsCompanyAddressService.getAll();
    }

    @GetMapping(value = "oms-company-addresses/top3")
    public List<OmsCompanyAddress> getTop3(){
        return omsCompanyAddressService.findTop3ByIdAsc();
    }

    @PutMapping(value = "oms-company-addresses/phones")
    public String updateAllPhonesToDefault(){
        omsCompanyAddressService.updateAllByPhonesToDefault();
        return "successfully";
    }

}
