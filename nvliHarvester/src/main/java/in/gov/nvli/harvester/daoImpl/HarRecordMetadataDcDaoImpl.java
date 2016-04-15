/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gov.nvli.harvester.daoImpl;

import in.gov.nvli.harvester.beans.HarRecordMetadataDc;
import in.gov.nvli.harvester.dao.HarRecordMetadataDcDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author richa
 */
@Repository
@Transactional(readOnly = true)
public class HarRecordMetadataDcDaoImpl implements HarRecordMetadataDcDao{
  
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @Transactional
  public void save(HarRecordMetadataDc metadataDc) {
    Session session=null;
    try{
      session = sessionFactory.getCurrentSession();
      session.save(metadataDc);

    }catch(Exception e){
      e.printStackTrace();
    }
  }
  
  
  
}
