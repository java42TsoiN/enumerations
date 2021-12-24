package telran.util;

public enum LengthUnit {
	MM(1f), CM(10f), INC(25.4f), FT(304.8f), M(1000f), KM(10000000f);
	float value;
	private LengthUnit(float value) {
		this.value = value;
	}
	public float getValue() {
		return value;
	}
	/**
	 * 
	 * @param l1
	 * @param l2 
	 * @return Length object with amount of the LengthUnit
	 * LengthUnit.M.between(new Length(200f,LengthUnit.CM), new Length(1f,LengthUnit.M))) -> Length(1,LengthUnit.M)
	 */
	public Length between(Length l1, Length l2) {
		Length length = new Length(0,LengthUnit.MM);
		float l1MM = l1.unit.value*l1.amount;
		float l2MM = l2.unit.value*l2.amount;
		float subtracted = Math.abs(l1MM-l2MM);
		System.out.println(length.unit);
		return new Length(subtracted/this.value,this);
	}
	
}
