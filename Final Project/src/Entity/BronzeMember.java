package Entity;

import java.util.Vector;

public class BronzeMember implements Member{

	@Override
	public Vector<MemberPerson> memberlist(Vector<MemberPerson> persons) {
		// TODO Auto-generated method stub
		Vector<MemberPerson> bronzelist = new Vector<>();
		for(MemberPerson mp : bronzelist)
		{
			if(mp.getMemberType().equalsIgnoreCase("Bronze")) // (Filter Pattern) dikelompokkan ke criteria bronze
			{
				bronzelist.add(mp);
			}
		}
		return bronzelist;
	}

	@Override
	public Integer SetMemberPoints() {
		// TODO Auto-generated method stub
		return 200;
	}

	@Override
	public void MemberCard() {
		// TODO Auto-generated method stub
		System.out.println("Bronze Member Card");
	}



	
}
