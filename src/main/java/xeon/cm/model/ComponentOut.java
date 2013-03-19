package xeon.cm.model;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Map;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 12:13 PM
 */
@Entity
@Table(name = "Component_out")
public class ComponentOut extends ComponentChange {
    private String eid;
    private Person person;
    private Map<String, Integer> actions;

    @Column(name="eid")
    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
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
    @CollectionTable(name = "Out_action", joinColumns = @JoinColumn(name = "out_id"))
    @MapKeyJoinColumn(name = "actionId")
    @Column(name = "count")
    public Map<String, Integer> getActionIds() {
        return actions;
    }

    public void setActionIds(Map<String, Integer> actions) {
        this.actions = actions;
    }

}
