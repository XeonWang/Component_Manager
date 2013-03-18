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
    private Map<String, Action> actions;

    public String getEId() {
        return eId;
    }

    public void setEId(String eId) {
        this.eId = eId;
    }
    
    @OneToOne
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ElementCollection
    @JoinTable(name = "Out_action", joinColumns = @JoinColumn(name = "out_id"))
    @MapKey(name = "actionId")
    @Column(name = "count")
    public Map<String, Action> getActionIds() {
        return actions;
    }

    public void setActionIds(Map<String, Action> actions) {
        this.actions = actions;
    }

}
