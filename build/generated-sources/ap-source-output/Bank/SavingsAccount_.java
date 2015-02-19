package Bank;

import Bank.SavingsAccount.SavingsAccountType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-02-19T15:53:57")
@StaticMetamodel(SavingsAccount.class)
public class SavingsAccount_ extends Account_ {

    public static volatile SingularAttribute<SavingsAccount, SavingsAccountType> type;
    public static volatile SingularAttribute<SavingsAccount, Double> interest_rate;

}