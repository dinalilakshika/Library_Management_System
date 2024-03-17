package org.example.dao.custom;

import org.example.dao.CrudDAO;
import org.example.entity.Branches;

public interface BranchesDAO extends CrudDAO<Branches> {
    public String getLastBranchId();
}
