package diplom.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import diplom.entities.Diabet;

public class SugarSizeConstraint implements ConstraintValidator<SugarSize, Float>{

	@Override
	public void initialize(SugarSize arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Float arg0, ConstraintValidatorContext arg1) {
		if(arg0 < 3.5f)
		return false;
		else
			return true;
	}

}
