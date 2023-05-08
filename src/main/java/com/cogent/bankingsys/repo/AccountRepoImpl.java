package com.cogent.bankingsys.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cogent.bankingsys.entity.CustomersAccount;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public abstract class AccountRepoImpl implements AccountRepo {

	@PersistenceContext
	private EntityManager entityManager;

//	@Override
//	public List<CustomersAccount> findByCustomerId(int id) {
//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<CustomersAccount> criteriaQuery = criteriaBuilder.createQuery(CustomersAccount.class);
//
//		Root<CustomersAccount> root = criteriaQuery.from(CustomersAccount.class);
//		criteriaQuery.select(root);
//		criteriaQuery.where(criteriaBuilder.equal(root.get("customer_id"), id));
//		TypedQuery<CustomersAccount> query = entityManager.createQuery(criteriaQuery);
//		return query.getResultList();
//
//
//	}

}
