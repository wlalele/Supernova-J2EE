package Bank.classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author dev
 */
@Entity
public class Client implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long num_client;
    private String lastname;
    private String firstname;
    private String address;
    private String postal_code;
    private String city;
    private String mail;
    private String password;

    public static Client factory(Long num_client, String lastname, String firstname, String address, String postal_code, String city, String mail, String password)
    {
        Client client = new Client();
        client.num_client = num_client;
        client.lastname = lastname;
        client.firstname = firstname;
        client.address = address;
        client.postal_code = postal_code;
        client.city = city;
        client.mail = mail;
        client.password = password;
        return client;
    }
    
    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Long getNumClient()
    {
        return this.num_client;
    }
    
    public void setNumClient(Long num_client)
    {
        this.num_client = num_client;
    }
    
    public String getLastname()
    {
        return this.lastname;
    }
    
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
    
    public String getFirstname()
    {
        return this.firstname;
    }
    
    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getPostalCode()
    {
        return this.postal_code;
    }
    
    public void setPostalCode(String postal_code)
    {
        this.postal_code = postal_code;
    }
    
    public String getCity()
    {
        return this.city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getMail()
    {
        return this.mail;
    }
    
    public void setMail(String mail)
    {
        this.mail = mail;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Bank.Client[ id=" + this.id + ";"
                + " num_client=" + this.num_client + ";"
                + " lastname=" + this.lastname + ";"
                + " firstname=" + this.firstname + ";"
                + " address=" + this.address + ";"
                + " postal_code=" + this.postal_code + ";"
                + " city=" + this.city + ";"
                + " mail=" + this.mail + ";"
                + " password=" + this.password + " ]";
    }
}
