package com.cg.onlinepizza.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;

public class CoupanRepositoryImpl implements ICoupanRepository {


	EntityManagerFactory fact = Persistence.createEntityManagerFactory("demo1");
	EntityManager em= fact.createEntityManager();

	@Override
	public Coupan addCoupans(Coupan coupan) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(coupan);
		em.getTransaction().commit();
		return coupan;
	}

	@Override
	public Coupan editCoupans(Coupan coupan) {
		em.getTransaction().begin();
		em.find(Coupan.class, coupan.getCoupanId());
		em.merge(coupan);
		em.getTransaction().commit();
		return coupan;
	}


	@Override
	public Coupan deleteCoupans(int coupanId) throws CoupanIdNotFoundException {
		Coupan coupan=em.find(Coupan.class,coupanId);
		em.getTransaction().begin();
		em.remove(coupan);
		em.getTransaction().commit();
		Coupan coupan1=em.find(Coupan.class,coupanId);

		return coupan1;

	}

	@Override
	public List<Coupan> viewCoupans() {
		Query query = em.createQuery("select c from Coupan c");
		List<Coupan> resultList2 = query.getResultList();
		return resultList2;
	}


	/*
	 * @Override public Coupan editCoupans(Coupan coupan) throws
	 * InvalidCoupanOperationException {
	 * 
	 * Coupan updateC =em.find(Coupan.class,coupan.getCoupanId());
	 * em.getTransaction().begin(); updateC.setCoupanDescription("Food Damaka");
	 * em.getTransaction().commit(); return updateC;
	 */

	/*
	 * public EntityBuilder with(Component component1, Component component2,
	 * Component component3, Component component4) { edit.add(component1);
	 * edit.add(component2); edit.add(component3); edit.add(component4); return
	 * this;
	 */
}
// TODO Auto-generated method stub
/*
 * { Coupan couponObj = () reb).findById(coupan.getCoupanId()).orElse(null);
 * if(couponObj!=null) { return reb.save(coupan); } else { throw new
 * CoupanIdNotFoundException(" No Coupan available to update"); } }
 */


/*
 * @Override public Coupan deleteCoupans(int coupanId) throws
 * CoupanIdNotFoundException { //throws CoupanIdNotFoundException {
 * 
 * // TODO Auto-generated method stub
 * 
 * em.getTransaction().begin(); em.remove(coupanId);
 * em.getTransaction().commit(); return null; }
 */


/*@Override
	public List<Coupan> viewCoupans() {
		// TODO Auto-generated method stub
		return sess.createQuery( "select c.id from Coupan c", Coupan.class).getResultList(); 
	}*/









