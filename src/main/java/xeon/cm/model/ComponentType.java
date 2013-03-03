package xeon.cm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 11:57 AM
 */
@Entity
@Table(name = "Component_type")
public class ComponentType {
    private int id;
    private String name;
    private List<TypeField> fields = new ArrayList<TypeField>();

    @Id
    @GeneratedValue
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

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "Type_field", joinColumns = @JoinColumn(name = "type_id"))
    public List<TypeField> getFields() {
        return fields;
    }

    public void setFields(List<TypeField> fields) {
        this.fields = fields;
    }
}
