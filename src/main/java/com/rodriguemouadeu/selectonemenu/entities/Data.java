package com.rodriguemouadeu.selectonemenu.entities;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class Data {

    public Status[] getStatuses() {
        return Status.values();
    }

}
