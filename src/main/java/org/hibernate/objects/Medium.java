package org.hibernate.objects;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table
//@Table(name = "cities",schema="tourism")
@Table(name = "media")
public class Medium {
    @Id
    @GeneratedValue
    private Integer id;

    private String type;
    private String url;

    
    private Date created_at;
    private Date updated_at;
    

    private Integer interest_id;  
    
 



    
    public Medium() {
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
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
