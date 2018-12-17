package hibernate.Factories;

import hibernate.Implementations.CriteriaDaoImpl;
import hibernate.Implementations.HQLDaoImpl;
import hibernate.Implementations.InsertOperationImpl;
import hibernate.Implementations.UpdateOperationImpl;
import hibernate.Interfaces.CRUDDao;

public class FactoryCRUD {
    public CRUDDao getTypeOperation(Integer i) {
        if (i == 0) {
            return new HQLDaoImpl(new UpdateOperationImpl(new HQLDaoImpl()), new InsertOperationImpl(new HQLDaoImpl()));
        }
        else return new CriteriaDaoImpl(new UpdateOperationImpl(new CriteriaDaoImpl()), new InsertOperationImpl(new CriteriaDaoImpl()));
    }
}
