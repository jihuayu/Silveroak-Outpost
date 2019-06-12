package roito.silveroakoutpost.common.register;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SilveroakRegistry
{
	String modid();

	String name() default "";

	RegisterType registerType();
}