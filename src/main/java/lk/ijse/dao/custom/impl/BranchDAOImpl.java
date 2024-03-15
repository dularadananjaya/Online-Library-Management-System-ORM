package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.BranchDAO;
import lk.ijse.entity.Branches;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BranchDAOImpl implements BranchDAO {
    @Override
    public boolean save(Branches dto) throws SQLException {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Branches dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Branches search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Branches> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNextID() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        Query<String> query = session.createQuery("SELECT id FROM Branches ORDER BY id DESC LIMIT 1", String.class);
        query.setMaxResults(1);
        String currentBranchID = query.uniqueResult();

        transaction.commit();
        session.close();

        if (currentBranchID != null) {
            return splitBranchID(currentBranchID);
        } else {
            return splitBranchID(null);
        }
    }

    private String splitBranchID(String currentBranchID) {
        if (currentBranchID != null) {
            String[] split = currentBranchID.split("R");

            int id = Integer.parseInt(split[1]);
            id++;
            return String.format("R%03d", id);
        } else {
            return "R001";
        }
    }
}
