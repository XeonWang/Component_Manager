package xeon.cm.model;

import javax.persistence.*;
import java.util.Map;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 12:13 PM
 */
@Entity
@Table(name = "Component_out")
public class ComponentOut extends ComponentChange {
    private String eId;
    private Person person;
    private Map<String, Integer> actionIds;

    public String getEId() {
        return eId;
    }

    public void setEId(String eId) {
        this.eId = eId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ElementCollection
    @JoinTable(name = "out_action", joinColumns = @JoinColumn(name = "out_id"))
    @MapKey(name = "id")
    @Column(name = "count")
    public Map<String, Integer> getActionIds() {
        return actionIds;
    }

    public void setActionIds(Map<String, Integer> actionIds) {
        this.actionIds = actionIds;
    }

}
