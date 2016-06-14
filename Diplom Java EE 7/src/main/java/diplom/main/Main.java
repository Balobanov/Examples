package diplom.main;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import diplom.calculate.grade.CalculateGrade;
import diplom.ejbs.UserEjb;
import diplom.entities.Address;
import diplom.entities.CardiovascularSystem;
import diplom.entities.Diabet;
import diplom.entities.Groups;
import diplom.entities.Saturation;
import diplom.entities.User;

public class Main {
//
//	public static void main(String[] args) {
//		
//		Map<String, Object> properties = new HashMap<>();
//		properties.put(EJBContainer.MODULES, new File("target/classes"));
//		
//		try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
//			Context ctx = ec.getContext();
//			
//			UserEjb uEjb = (UserEjb) ctx.lookup("java:global/classes/UserEjb!diplom.ejbs.UserEjb");
//			
//			Address adr = new Address("wadawd");
//			Groups grp = new Groups(2, "Patient");
//			
//			User user = new User("name", "wdaw", "log", "pass", adr, grp);  
//			
//			uEjb.insertOrUpdate(user);
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}

}
