package Entity;

import java.util.Vector;

public class GoldMember implements Member{

	@Override
	public Vector<MemberPerson> memberlist(Vector<MemberPerson> persons) {
		// TODO Auto-generated method stub
		Vector<MemberPerson> goldlist = new Vector<>();
		for(MemberPerson mp : goldlist)
		{
			if(mp.getMemberType().equalsIgnoreCase("Gold")) // (Filter Pattern) dikelompokkan ke criteria gold
			{
				goldlist.add(mp);
			}
		}
		return goldlist;
		
	}

	@Override
	public Integer SetMemberPoints() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public void MemberCard() {
		// TODO Auto-generated method stub
		System.out.println("Gold Member Card");
	}

	

	
}
