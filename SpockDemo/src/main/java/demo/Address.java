package demo;

/**
 * ClassName: Address <br/>
 * Description: TODO <br/>
 * Date: 2016-04-12 17:29 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-04-12 jdai@ created. <br/>
 */
public class Address {

    private String country;

    private String city;

    private String district;

    private String street;

    private String subdistrict;

    private String zipCode;

/*    public Address(String country, String zipCode, String city, String district, String street, String subdistrict) {
        this.country = country;
        this.zipCode = zipCode;
        this.city = city;
        this.district = district;
        this.street = street;
        this.subdistrict = subdistrict;
    }*/

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
