package org.hibernate.objects;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table
//@Table(name = "cities",schema="tourism")
@Table(name = "criterias")
public class Criteria {
    @Id
    @GeneratedValue
    private Integer id;

    private String type_of;
    private String label;

    
    private Date created_at;
    private Date updated_at;
    

    private Integer interest_id;  
    
  


    
    public Criteria() {
    	super();
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the type_of
     */
    public String getType_of() {
        return type_of;
    }

    /**
     * @param type_of the type_of to set
     */
    public void setType_of(String type_of) {
        this.type_of = type_of;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the created_at
     */
    public Date getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the updated_at
     */
    public Date getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    /**
     * @return the interest_id
     */
    public Integer getInterest_id() {
        return interest_id;
    }

    /**
     * @param interest_id the interest_id to set
     */
    public void setInterest_id(Integer interest_id) {
        this.interest_id = interest_id;
    }

  

    





    
}
