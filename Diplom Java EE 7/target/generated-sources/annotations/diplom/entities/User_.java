package diplom.entities;

import diplom.entities.Address;
import diplom.entities.CardiovascularSystem;
import diplom.entities.Diabet;
import diplom.entities.Groups;
import diplom.entities.Saturation;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-06-13T13:05:49")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Saturation> saturation;
    public static volatile SingularAttribute<User, String> user_password;
    public static volatile SingularAttribute<User, Address> address;
    public static volatile SingularAttribute<User, Integer> user_id;
    public static volatile SingularAttribute<User, String> user_name;
    public static volatile SingularAttribute<User, String> user_lastname;
    public static volatile SingularAttribute<User, Float> grade;
    public static volatile SingularAttribute<User, String> login;
    public static volatile SingularAttribute<User, Diabet> diabet;
    public static volatile SingularAttribute<User, CardiovascularSystem> cardiovascularSystem;
    public static volatile SingularAttribute<User, Groups> group;

}