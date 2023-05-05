package com.cogent.bankingsys.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cogent.bankingsys.entity.BeneficiaryAccount;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public abstract class BeneficiaryImpl implements BeneficiaryRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BeneficiaryAccount> findByCustomerId(int id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BeneficiaryAccount> criteriaQuery = criteriaBuilder.createQuery(BeneficiaryAccount.class);

		Root<BeneficiaryAccount> root = criteriaQuery.from(BeneficiaryAccount.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("customer_id"), id));
		TypedQuery<BeneficiaryAccount> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();

	}
}
