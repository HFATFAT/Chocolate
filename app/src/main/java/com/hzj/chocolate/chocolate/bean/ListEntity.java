package com.hzj.chocolate.chocolate.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ff on 15/8/11.
 */
public interface ListEntity<T extends Entity> extends Serializable {

    public List<T> getList();
}
