package telran.util;

import org.junit.platform.commons.util.ToStringBuilder;

public class Length implements Comparable<Length>{
	float amount;
	LengthUnit unit;
	public Length(float value,LengthUnit unit) {
		this.amount = value;
		this.unit = unit;
	}
	@Override
	/**
	 * equals two length objects according to LengthUnit
	 * 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		float l1 = getLengthMM(this);
		if(this==obj) return true;
		if (obj instanceof Length) {
			float objL =getLengthMM((Length) obj);
			if(l1==objL) {
				return true;
			}
		}
		return false;
	}
	private float getLengthMM(Length length) {
		return length.amount*length.unit.value;
	}
	@Override
	public int compareTo(Length o) {
		float thisL = getLengthMM(this);
		float oL = getLengthMM(o);
		
		return Float.compare(thisL, oL);
	}
	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit
	 * convert(LengthUnit.M) returns Length in meters
	 */
	public Length convert(LengthUnit unit) {
		float value = getLengthMM(this)/unit.value;
		return new Length(value, unit);
	}

	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20M (string expression of Length object designed 20 meters)
	 */
	@Override
	public String toString() {
		return String.format("%.1f", amount)+unit.toString();
		
	}
}
