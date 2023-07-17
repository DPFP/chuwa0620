package com.chuwa.hw4.repository;

import com.chuwa.hw4.entity.OmsCompanyAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/11/23$
 */
@Repository
public interface OmsCompanyAddressJpaRepository extends JpaRepository<OmsCompanyAddress, Long> {
    public OmsCompanyAddress getOmsCompanyAddressById(Long id);

    @Query("SELECT u FROM OmsCompanyAddress u order by u.id limit 3")
    List<OmsCompanyAddress> findTop3ByIdAsc();

    @Modifying
    @Query("UPDATE OmsCompanyAddress set phone = '666-6666-8888'")
    void updateAllByPhonesToDefault();

}
