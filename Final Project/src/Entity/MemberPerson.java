package Entity;

public class MemberPerson {
private String MemberID;
private String MemberName;
private String MemberGender;
private String MemberType;
private Integer MemberPoint;
public MemberPerson(String memberID, String memberName, String memberGender, String memberType,Integer MemberPoint) {
	super();
	MemberID = memberID;
	MemberName = memberName;
	MemberGender = memberGender;
	MemberType = memberType;
	this.setMemberPoint(MemberPoint);
}
public String getMemberID() {
	return MemberID;
}
public void setMemberID(String memberID) {
	MemberID = memberID;
}
public String getMemberName() {
	return MemberName;
}
public void setMemberName(String memberName) {
	MemberName = memberName;
}
public String getMemberGender() {
	return MemberGender;
}
public void setMemberGender(String memberGender) {
	MemberGender = memberGender;
}
public String getMemberType() {
	return MemberType;
}
public void setMemberType(String memberType) {
	MemberType = memberType;
}
public Integer getMemberPoint() {
	return MemberPoint;
}
public void setMemberPoint(Integer memberPoint) {
	MemberPoint = memberPoint;
}

	

}
