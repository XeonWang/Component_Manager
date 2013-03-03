package xeon.cm.model;

import javax.persistence.Embeddable;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 11:58 AM
 */
@Embeddable
public class TypeField {
    private int id;
    private String name;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
