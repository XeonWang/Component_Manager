package xeon.cm.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 12:13 PM
 */
@Entity
@Table(name = "Component_modify")
public class ComponentModify extends ComponentChange {
    private boolean lost;

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }
}
