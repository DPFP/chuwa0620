package com.demo.rewardprogram.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.rewardprogram.entity.TransactionData;

@Repository
@Transactional
public interface TransactionDataRepository extends JpaRepository<TransactionData, Long> {

	@Query("SELECT trans FROM TransactionData trans  WHERE  trans.purchaseDate >= DATEADD(MONTH, -3, CURRENT_DATE) ")
	List<TransactionData> findAllInLastThreeMonth();

}
