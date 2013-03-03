package xeon.cm.model;

import javax.persistence.*;
import java.util.Date;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 12:05 PM
 */

public class ComponentChange {
    private int id;
    private Component component;
    private Date date;
    private int count;
    private String mark;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "component_id")
    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    @Column(name = "change_date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
