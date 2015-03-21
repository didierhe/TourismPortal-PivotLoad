package org.hibernate.objects;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table
//@Table(name = "cities",schema="tourism")
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue
    private Integer id;

    private String city;
    private Float latitude;
    private Float longitude;
    private Date created_at;
    private Date updated_at;
    
    private Integer zip;
    private Integer source_id;

    
    public City() {
    	super();
    }

    
	public City(String city, Float latitude, Float longitude, Date create_at, Date update_at) throws Exception{
		this.city = city;
		this.latitude=latitude;
		this.longitude=longitude;
                this.created_at=create_at;
                this.updated_at=update_at;

    }
    
	public void update (String city, Float latitude, Float longitude) throws Exception{
		if (city!=null) this.setCity(city);
		if (latitude!=null) this.setLatitude(latitude);
		if (longitude!=null) this.setLongitude(longitude);
                this.updated_at=new Date();
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
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the latitude
     */
    public Float getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public Float getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
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
     * @return the zip
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    /**
     * @return the source_id
     */
    public Integer getSource_id() {
        return source_id;
    }

    /**
     * @param source_id the source_id to set
     */
    public void setSource_id(Integer source_id) {
        this.source_id = source_id;
    }


    




    
}
