package com.slager.datasource.dao;

import com.slager.datasource.queryhelper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.xml.crypto.*;

public abstract class DataAccessObject {

    protected QueryHelper queryHelper;

    public DataAccessObject(QueryHelper queryHelper) {
        this.queryHelper = queryHelper;
    }
}
