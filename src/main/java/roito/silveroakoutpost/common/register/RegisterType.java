package roito.silveroakoutpost.common.register;

public enum RegisterType
{
	BLOCK,
	ITEM,
	POTION,
	ENTITY,
	TILEENTITY;

	public String toString()
	{
		return name().toLowerCase();
	}
}
