package xeon.hibernate.model;

import javax.persistence.Embeddable;

/**
 * User: xeon
 * Date: 2/27/13
 * Time: 10:24 PM
 */
@Embeddable
public class Address {
    private String addr1;
    private String addr2;

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }
}
