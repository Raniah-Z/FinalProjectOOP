package Entity;

import java.util.Vector;

public class SilverMember implements Member{

	@Override
	public Vector<MemberPerson> memberlist(Vector<MemberPerson> persons) {
		// TODO Auto-generated method stub
		Vector<MemberPerson> silverlist = new Vector<>();
		for(MemberPerson mp : silverlist)
		{
			if(mp.getMemberType().equalsIgnoreCase("Silver")) // (Filter Pattern) dikelompokkan ke criteria silver
			{
				silverlist.add(mp);
			}
		}
		return silverlist;
		
	}

	@Override
	public Integer SetMemberPoints() {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public void MemberCard() {
		// TODO Auto-generated method stub
		System.out.println("Silver Member Card");
	}

	

	

}
