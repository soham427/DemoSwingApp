package com.pass;

import java.io.Serializable;

public class UserRecord implements Serializable {
    public int userCount;
    public int adminCount;
    public int superUserCount;
    public int godCount;

    public UserRecord(int uCount, int aCount, int suCount, int gCount) {
        userCount = uCount;
        adminCount = aCount;
        superUserCount = suCount;
        godCount = gCount;
    }
}
