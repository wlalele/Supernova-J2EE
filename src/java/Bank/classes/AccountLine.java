/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bank.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author dev
 */
@Entity
public class AccountLine implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transfer_date;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date bank_transfer_date;
    private Float amount;

    public static AccountLine factory(String label, Date transfer_date, Date bank_transfer_date, Float amount)
    {
        AccountLine account_line = new AccountLine();
        account_line.label = label;
        account_line.transfer_date = transfer_date;
        account_line.bank_transfer_date = bank_transfer_date;
        account_line.amount = amount;
        return account_line;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLabel()
    {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getTransferDate()
    {
        return this.transfer_date;
    }

    public void setTransferDate(Date transfer_date)
    {
        this.transfer_date = transfer_date;
    }

    public Date getBankTransferDate()
    {
        return this.bank_transfer_date;
    }

    public void setBankTransferDate(Date bank_transfer_date)
    {
        this.bank_transfer_date = bank_transfer_date;
    }
    
    public Float getAmount()
    {
        return amount;
    }

    public void setAmount(Float amount)
    {
        this.amount = amount;
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
        if (!(object instanceof AccountLine)) {
            return false;
        }
        AccountLine other = (AccountLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Bank.AccountLine[ id=" + id + ";"
                + " label=" + this.label + ";"
                + " transfer_date=" + this.transfer_date + ";"
                + " bank_transfer_date=" + this.bank_transfer_date + ";"
                + " amount=" + this.amount + "€ ]";
    }
}
