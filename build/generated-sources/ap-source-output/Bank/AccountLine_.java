package Bank;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-02-19T15:53:57")
@StaticMetamodel(AccountLine.class)
public class AccountLine_ { 

    public static volatile SingularAttribute<AccountLine, Long> id;
    public static volatile SingularAttribute<AccountLine, Float> amount;
    public static volatile SingularAttribute<AccountLine, Date> bank_transfer_date;
    public static volatile SingularAttribute<AccountLine, Date> transfer_date;
    public static volatile SingularAttribute<AccountLine, String> label;

}