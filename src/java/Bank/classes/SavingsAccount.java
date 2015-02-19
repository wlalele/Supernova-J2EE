/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bank.classes;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author dev
 */
@Entity
public class SavingsAccount extends Account implements Serializable 
{
    public static enum SavingsAccountType {
        LIVRET_A,
        LDD
    };
    
    private Double interest_rate;
    private SavingsAccountType type;

    public static SavingsAccount factorySavings(Long num_account, Double interest_rate, SavingsAccountType type)
    {
        SavingsAccount savings_account = new SavingsAccount();
        savings_account.setNumAccount(num_account);
        savings_account.setInterestRate(interest_rate);
        savings_account.setType(type);
        return savings_account;
    }

    public Double getInterestRate()
    {
        return interest_rate;
    }

    public void setInterestRate(Double interest_rate)
    {
        this.interest_rate = interest_rate;
    }
    
    public SavingsAccountType getType()
    {
        return type;
    }

    public void setType(SavingsAccountType type)
    {
        this.type = type;
    }
    
    @Override
    public String toString() 
    {
        return "Bank.SavingsAccount[ id=" + this.id + ";"
                + " num_account=" + this.num_account + ";"
                + " interest_rate=" + this.interest_rate + ";"
                + " type=" + this.type + " ]";
    }
    
}
