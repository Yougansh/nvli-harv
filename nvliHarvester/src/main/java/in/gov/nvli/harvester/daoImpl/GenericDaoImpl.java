package in.gov.nvli.harvester.daoImpl;

import in.gov.nvli.harvester.custom.annotation.TransactionalReadOrWrite;
import in.gov.nvli.harvester.custom.annotation.TransactionalReadOnly;
import in.gov.nvli.harvester.dao.GenericDao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Generic DAO interface definition
 *
 * @param <T> The class of the pojo being persisted.
 * @param <ID> the class of the pojo's id property
 * @author vootla
 * @version 1
 * @since 1
 */
@TransactionalReadOnly
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

    /**
     * The class of the pojo being persisted.
     */
    protected Class<T> persistentClass;
    @Autowired
    public SessionFactory sessionFactory;

    /**
     * Get the current session from the seesionFactory.
     *
     * @return Session{@link Session}
     */
    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Constructor: Checking for the right type since we are using cglib proxy
     * if catch block's code modified it will throw ClassCastException due to
     * Parameterized Type Conversion of proxy.
     *
     */
    public GenericDaoImpl(Class<T> entityClass) {
        this.persistentClass = entityClass;
    }

    /**
     * Get the Persistent class
     *
     * @return
     */
    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    /**
     * Create New entity
     *
     * @param entity
     * @return boolean
     * @throws DataIntegrityViolationException
     */
    @Override
    @TransactionalReadOrWrite
    public boolean createNew(T entity) throws DataIntegrityViolationException {
        return (currentSession().save(entity)) != null;
        //return isCreated;
    }

    /**
     * @see in.gov.nvli.dao.generic.IGenericDAO#get(java.io.Serializable)
     */
    @Override
    public T get(ID id) {
        return (T) currentSession().get(persistentClass, id);
    }

    /**
     * @return @see in.gov.nvli.dao.generic.IGenericDAO#merge()
     */
    @Override
    @TransactionalReadOrWrite
    public T merge(T entity) {
        return (T) currentSession().merge(entity);
    }

    /**
     * @see in.gov.nvli.dao.generic.IGenericDAO#list()
     */
    @Override
    public List<T> list() {
        return currentSession().createCriteria(persistentClass).list();
    }

    /**
     * @see in.gov.nvli.dao.generic.IGenericDAO#saveOrUpdate(java.lang.Object)
     *
     */
    @Override
    @TransactionalReadOrWrite
    public void saveOrUpdate(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    /**
     * @see in.gov.nvli.dao.generic.IGenericDAO#delete(java.lang.Object)
     */
    @Override
    @TransactionalReadOrWrite
    public void delete(T entity) {
        currentSession().delete(entity);
    }

    /**
     * @see in.gov.nvli.dao.generic.IGenericDAO#exist(java.io.Serializable)
     */
    @Override
    public boolean exist(ID idd) {
        return currentSession().get(persistentClass, idd) != null;
    }

    /**
     * @see in.gov.nvli.dao.generic.GenericDAOImpl#update(java.lang.String,
     * java.lang.Object[])
     * @param queryName
     * @param obj
     */
    @Override
    @TransactionalReadOrWrite
    public void update(String queryName, Object... obj) {
        currentSession().update(queryName, obj);

    }

    /**
     * Flush
     */
    @Override
    public void flush() {
        currentSession().flush();
    }

    @Override
    @TransactionalReadOrWrite
    public boolean saveList(List<T> list) {
        for (T temp : list) {
            if (!createNew(temp)) {
                return false;
            }
        }
        return true;
    }

    @Override
    @TransactionalReadOrWrite
    public void saveOrUpdateList(List<T> list) {
        for (T temp : list) {
            saveOrUpdate(temp);
        }
    }
}
