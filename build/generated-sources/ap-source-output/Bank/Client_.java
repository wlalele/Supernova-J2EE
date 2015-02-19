package Bank;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-02-19T15:53:57")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Long> id;
    public static volatile SingularAttribute<Client, String> mail;
    public static volatile SingularAttribute<Client, String> address;
    public static volatile SingularAttribute<Client, String> postal_code;
    public static volatile SingularAttribute<Client, String> lastname;
    public static volatile SingularAttribute<Client, String> firstname;
    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, Long> num_client;
    public static volatile SingularAttribute<Client, String> city;

}