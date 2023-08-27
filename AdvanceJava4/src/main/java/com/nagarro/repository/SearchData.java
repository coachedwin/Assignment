package com.nagarro.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.TshirtModel;


@Repository
@Transactional
public class SearchData {
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("rawtypes")
	public List<TshirtModel> Search(String color,String size,String gender,int pref) {
		Session session=sessionFactory.getCurrentSession();
		Query q;
		if(pref==1) {
			q = session.createQuery("from TshirtModel as t where t.color=:color AND t.size=:size AND t.gender=:gender order by t.price").setParameter("color",color).setParameter("size",size).setParameter("gender",gender);
		}
		else if(pref==2) {
			q = session.createQuery("from TshirtModel as t where t.color=:color AND t.size=:size AND t.gender=:gender order by t.rating desc").setParameter("color",color).setParameter("size",size).setParameter("gender",gender);
		}
		else {
		q = session.createQuery("from TshirtModel as t where t.color=:color AND t.size=:size AND t.gender=:gender order by t.price,t.rating desc").setParameter("color",color).setParameter("size",size).setParameter("gender",gender);
		}
		@SuppressWarnings("unchecked")
		List<TshirtModel> tshirt=q.list();
        
        return tshirt;
	}
}
