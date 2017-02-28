package assignment1;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Daria Davydenko 
 * Student number: 200335788
 *
 * Test Change Address does not pass because you put wrong Postal Code there.
 * There is "K9LW2S", but the format should be
 * [letter][number][letter][number][letter][number]
 *
 */
public class Person {

    private String firstName, lastName, streetAddress, city, province, postalCode;
    private LocalDate birthday;

    /**
     * This is a constructor for the class Person
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param province
     * @param postalCode validates the postal code - 6 characters long
     * @param birthday
     */
    public Person(String firstName, String lastName, String address,
            String city, String province, String postalCode, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = address;
        this.city = city;
        this.province = province;
        setPostalCode(postalCode);
        this.birthday = birthday;
    }

    /**
     * This method validates if the postal code contain 6 characters and if it
     * is the pattern of [letter][number][letter][number][letter][number]
     *
     * All setters should be private, but in this case test gave an error if I
     * made the setters private, so it is protected
     *
     * @param pCode
     */
    protected void setPostalCode(String pCode) {
        Pattern pattern = Pattern.compile("^[(a-z)][\\d][(a-z)][\\d][(a-z)][\\d]",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(pCode);

        if (pCode.length() == 6) {
            if (matcher.find()) {
                postalCode = pCode.toUpperCase();
            } else {
                throw new IllegalArgumentException("Postal code  pattern is not matched");
            }
        } else {
            throw new IllegalArgumentException("Postal code must be 6 character length");
        }
    }

    /**
     * This method changes address of person. It accepts street name, city,
     * province, postal code
     *
     * @param street
     * @param city
     * @param province
     * @param postalCode validates the postal code - 6 characters long
     */
    public void changeAddress(String street, String city,
            String province, String postalCode) {
        this.streetAddress = street;
        this.city = city;
        this.province = province;
        setPostalCode(postalCode);
    }

    /**
     * This method calculates the age of the person by using Period class.
     *
     * @return int age
     */
    public int getAge() {
        LocalDate today = LocalDate.now();
        Period years = Period.between(birthday, today);
        int age = years.getYears();
        return age;
    }

    /**
     * This method calculate the year person was born
     *
     * @return int year of born
     */
    public int getYearBorn() {
        return birthday.getYear();
    }

    /**
     * This method save the full address of the person in the format "street
     * name, city, province, postal code"
     *
     * @return String full address
     *
     */
    public String getFullAddress() {
        String fullAddress = streetAddress + ", " + city + ", " + province + ", " + postalCode;
        return fullAddress;
    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    protected void setCity(String city) {
        this.city = city;
    }

    protected void setProvince(String province) {
        this.province = province;
    }

    protected void setBirthday(LocalDate birthdate) {
        this.birthday = birthdate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
