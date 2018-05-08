package com.lorin.deadlineschmedline.models;

import java.util.Date;

/**
 * Created by Lorin on 5/9/2018.
 */

public interface Addable {

    void add(String name, String type, Date createdDate, Date dueDate);

    void delete(double id);

}
