package xeon.cm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 12:12 PM
 */
@Entity
@Table(name = "Component_in")
public class ComponentIn extends ComponentChange {
    private double price;
    private Company company;
    private String actionId;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @OneToOne
    @Column(name = "company_id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }
}
