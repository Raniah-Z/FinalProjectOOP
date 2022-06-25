package Entity;

import java.util.Vector;

public interface Member {
	/*
	 * pada class MemberPerson, BronzeMember, SilverMember, GoldMember, dan interface Member
	 * menggunakan Structural Design Pattern: Filter Pattern.
	 * gunanya adalah untuk memungkinkan kita memfilter dan mengelompokkan sekumpulan objek menggunakan kriteria.
	 * pada kasus ini yaitu kriteria member ada: bronze, silver, gold.
	 */

public Vector<MemberPerson> memberlist (Vector<MemberPerson> persons);
public Integer SetMemberPoints();
public void MemberCard();

}
