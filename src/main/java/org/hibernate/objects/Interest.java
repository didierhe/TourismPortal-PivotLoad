package org.hibernate.objects;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
//@Table
//@Table(name = "cities",schema="tourism")
@Table(name = "interests")
public class Interest {
    @Id
    @GeneratedValue
    private Integer id;

    private String cgt_code;
    private String name;
    @Column(name = "description")
    @Type(type="text")
    private String description;
    private String address;
    private Integer zip;
    private String mobile;
    private String phone;
    private String email;
    private String website;
    private String source;
            
            
    private Float latitude;
    private Float longitude;
    
    private Date created_at;
    private Date updated_at;
    
    private Integer category_id;
    private Integer source_id; 
    private Integer city_id;
  



    
    public Interest() {
    	super();
    }

    
	/*public Interest(String city, Float latitude, Float longitude, Date create_at, Date update_at) throws Exception{
		this.city = city;
		this.latitude=latitude;
		this.longitude=longitude;
                this.created_at=create_at;
                this.updated_at=update_at;

    }*/
    
	/*public void update (String city, Float latitude, Float longitude) throws Exception{
		if (city!=null) this.setCity(city);
		if (latitude!=null) this.setLatitude(latitude);
		if (longitude!=null) this.setLongitude(longitude);
                this.setUpdated_at(new Date());
    }*/

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
     * @return the cgt_code
     */
    public String getCgt_code() {
        return cgt_code;
    }

    /**
     * @param cgt_code the cgt_code to set
     */
    public void setCgt_code(String cgt_code) {
        this.cgt_code = cgt_code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
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
     * @return the category_id
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
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

    /**
     * @return the city_id
     */
    public Integer getCity_id() {
        return city_id;
    }

    /**
     * @param city_id the city_id to set
     */
    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }




    
}
