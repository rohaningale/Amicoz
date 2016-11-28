package org.amicoz.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.amicoz.model.User;
import org.amicoz.model.UserInfo;
import org.amicoz.ui.model.GeneralSettingsInfoImpl;
import org.amicoz.ui.model.Group;
import org.amicoz.ui.model.PasswordResetSettingsInfoImpl;
import org.amicoz.ui.model.PrivacySettingsInfoImpl;
import org.amicoz.ui.model.RegistrationInfo;
import org.amicoz.ui.model.SearchResults;
import org.amicoz.ui.model.UserDetails;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="userDao")
public class UserDaoImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	//private static int sequenceNumber=1;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	@Transactional
	public int addUser(RegistrationInfo registrationInfo) {
		// TODO Auto-generated method stub
		User user = new User();
		//user.setUserID(sequenceNumber);
		user.setPassword(registrationInfo.getPassword());
		user.setPrimaryEmailId(registrationInfo.getEmailId());
		user.setSecretQuestion(registrationInfo.getQuestions());
		user.setSecondaryEmailId(registrationInfo.getSecondaryEmail());
		user.setSecretQuestionAnswer(registrationInfo.getSecretAnswer());
		user.setCreatedBy("Admin");
		user.setCreationDate(new Date());
		user.setUpdatedBy("Admin");
		user.setUpdateDate(new Date());
		user.setRecoveryBit(0);
		
		
		
		UserInfo userInfo = new UserInfo();
		//userInfo.setUserId(sequenceNumber++);
		userInfo.setFirstName(registrationInfo.getFirstname());
		userInfo.setLastName(registrationInfo.getLastname());
		userInfo.setCreatedBy("Admin");
		userInfo.setCreationDate(new Date());
		userInfo.setUpdatedBy("Admin");
		userInfo.setUpdateDate(new Date());
		
		
		Session session = sessionFactory.openSession();
		try{
			
			Query query = session.createQuery("from User where Primary_Email_Id=?");
			query.setParameter(0, user.getPrimaryEmailId());
			List<User> list = query.list();
			if(list!=null && list.size()>=1){
				return 0;
			}
			
			session.save(user);
			System.out.println("Entered in User table.");
			query = session.createQuery("from User where Primary_Email_Id=?");
			query.setParameter(0, user.getPrimaryEmailId());
			list = query.list();
			
			if(list==null){
				return 0;
			}
			session.close();
			session = sessionFactory.openSession();
			
			String insertQuery = "INSERT INTO `user_info` (`User_Id`, `FIRST_NAME`, `LAST_NAME`)"
					+ " VALUES (?, ?, ?)";
			query = session.createSQLQuery(insertQuery);
			query.setParameter(0, list.get(0).getUserID());
			query.setParameter(1, userInfo.getFirstName());
			query.setParameter(2, userInfo.getLastName());
			System.out.println("Entering into UserInfo "+ list.get(0).getUserID());
			userInfo.setUserId(list.get(0).getUserID());
			
			query.executeUpdate();
			System.out.println("Done.");
			
//			session.save(user);
			//session.save(userInfo);
			return 1;
		}catch(HibernateException e){
			System.out.println("Error while inserting in UserDaoImpl -> addUser");
			e.printStackTrace();
			return -1;
		}finally{
			session.close();
		}
		
	}
	
	@Transactional
	public Integer checkLogin(String userName, String password){
		Session session = sessionFactory.openSession();
		try{
			String sqlQuery = "from User where Primary_Email_Id =? and Password=?";
			Query query = session.createQuery(sqlQuery);
			query.setParameter(0, userName);
			query.setParameter(1, password);
			List<User> list = query.list();
			if(list!=null && list.size()==1){
				return list.get(0).getUserID();
			}
			return Integer.MIN_VALUE;
		} catch (HibernateException e) {
			System.out.println(e.getStackTrace());
			return Integer.MIN_VALUE;
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional
	public ArrayList<String> getSecurityQueAndAnswer(String emailId, boolean alternate) {
		// TODO Auto-generated method stub
		List<String> retVal;
		Session session = sessionFactory.openSession();
		try{
			String sqlQuery;
			if(!alternate) {
				sqlQuery = "from User where Primary_Email_Id =?";
			} else {
				sqlQuery = "from User where secondaryEmailId =?";
			}
			System.out.println(sqlQuery);
			
			Query query = session.createQuery(sqlQuery);
			query.setParameter(0, emailId);
			List<User> list = query.list();
			if(list!=null && list.size()==1){
				retVal = new ArrayList<String>();
				retVal.add(String.valueOf(list.get(0).getUserID()));
				retVal.add(list.get(0).getSecretQuestion());
				retVal.add(list.get(0).getSecretQuestionAnswer());
				retVal.add(list.get(0).getPrimaryEmailId());
				//System.out.println(retVal.toString());
				return (ArrayList<String>) retVal;
			}
			return null;
		} catch (HibernateException e) {
			System.out.println(e.getStackTrace());
			return null;
		} finally {
			//session.close();
		}
	}

	@Override
	@Transactional
	public void updateRecoveryBitAndPassword(int userId, int recoveryBit, String encryptPassword) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		try {
			System.out.println(userId);
			
			Query query = session.createQuery("update User set recoveryBit = :recoveryBit, "
					+" password = :password"
					+" where userID = :userID");
			
			query.setParameter("recoveryBit", recoveryBit);
			query.setParameter("password", encryptPassword);
			query.setParameter("userID", userId);
			int updateResult = query.executeUpdate();
			System.out.println("Updated records : "+updateResult);
			
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@Override
	@Transactional
	public ArrayList<String> getSettingsData(int userId) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		List<String> retVal;
		
		try {
			
			Query query = session.createQuery("from User where userID= :userID");
			query.setParameter("userID", userId);
			
			List<User> l = query.list();
			if(l!=null && l.size()==1){
				retVal = new ArrayList<String>();
				
				retVal.add(String.valueOf(l.get(0).getUserID()));
				
				retVal.add(l.get(0).getSecondaryEmailId());
				
				query = session.createQuery("from UserInfo where User_Id= :userID");
				query.setParameter("userID", userId);
				List<UserInfo> list = query.list();
				
				UserInfo uInfo = list.get(0);
				
				if(uInfo.getFirstName() != null)
					retVal.add(uInfo.getFirstName());
				else
					retVal.add("");
				
				if(uInfo.getLastName() != null)
					retVal.add(uInfo.getLastName());
				else
					retVal.add("");
				
				if(!uInfo.getContactNumber().equalsIgnoreCase("123-456-7890"))
					retVal.add(uInfo.getContactNumber());
				else
					retVal.add("");
				
				
				if(uInfo.getDateOfBirth() != null)
					retVal.add(uInfo.getDateOfBirth().toString());
				else
					retVal.add("");
				

				if(uInfo.getBio() != null)
					retVal.add(uInfo.getBio());
				else
					retVal.add("");
				
				
				if(uInfo.getGender() != null)
					retVal.add(uInfo.getGender());
				else
					retVal.add("");
				
				if(uInfo.getProfileVisibility() != null) 
					retVal.add(uInfo.getProfileVisibility());
				else
					retVal.add("Y");
				
				if(uInfo.getProfilePictureURL() != null)
					retVal.add(uInfo.getProfilePictureURL());
				else
					retVal.add("");
				System.out.println(uInfo.getFirstName());
				
				
				if(uInfo.getCity() != null)
					retVal.add(uInfo.getCity());
				else
					retVal.add("");
				
				if(uInfo.getState() != null)
					retVal.add(uInfo.getState());
				else
					retVal.add("");
				
				if(uInfo.getCountry() != null)
					retVal.add(uInfo.getCountry());
				else
					retVal.add("");
				
				if(uInfo.getSchool() != null)
					retVal.add(uInfo.getSchool());
				else
					retVal.add("");
				//System.out.println("got from db: "+retVal.toString());
				return (ArrayList<String>) retVal;
			}
			
			return null;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public boolean saveGeneralSettings(GeneralSettingsInfoImpl generalSettings, int userId) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		try {
			
			String queryString = "update UserInfo "
					+ "set firstName = :fname,"
					+ "lastName = :lname,"
					+ "contactNumber = :contact,"
					+ "dateOfBirth = :dob,"
					+ "gender = :gender,"
					+ "bio = :bio,"
					+ "city = :city,"
			        + "state = :state,"
			        + "country = :country,"
			        + "school = :school"
					+ " where userId = :userID";
			
			Query query = session.createQuery(queryString);
			query.setParameter("fname", generalSettings.getFname());
			
			if(!generalSettings.getLname().trim().isEmpty())
				query.setParameter("lname", generalSettings.getLname());
			else
				query.setParameter("lname","");
			
			query.setParameter("contact", generalSettings.getPhonenum());
			

/*			
			String date = new SimpleDateFormat("yyyy-MM-dd").parse(generalSettings.getDob()).toString();
			if(!date.trim().isEmpty())
				query.setParameter("dob", date);
			else
				query.setParameter("dob",null);*/
			if(generalSettings.getDob() != null && !generalSettings.getDob().trim().equals("")) 
				query.setParameter("dob",new SimpleDateFormat("yyyy-MM-dd").parse(generalSettings.getDob()));
			else
				query.setParameter("dob",null);
			
			query.setParameter("gender", generalSettings.getGender());
			query.setParameter("bio", generalSettings.getBio());
			query.setParameter("userID", userId);
			query.setParameter("city", generalSettings.getCity());
			query.setParameter("state", generalSettings.getState());
			query.setParameter("country", generalSettings.getCountry());
			query.setParameter("school", generalSettings.getSchool());
			//query.setParameter("sec_userID", generalSettings.getEmail());
			
			int updateResult = query.executeUpdate();
			
			System.out.println("Rows affected : "+updateResult);
			
			if(updateResult==1)
				return true;
			return false;
			
		} catch(HibernateException | ParseException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		
		//return false;
	}

	@Override
	@Transactional
	public boolean savePrivacySettings(PrivacySettingsInfoImpl privacySettings, int userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
		
			Query query = session.createQuery("update UserInfo set Profile_Visibility = :visibility "
					+ " where User_Id = :userID");
			query.setParameter("userID", userId);
			query.setParameter("visibility", privacySettings.getPrivacy());
			int updatedRows = query.executeUpdate();
			if(updatedRows > 0)
				return true;
			return false;
		} catch(HibernateException e) {
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional
	public boolean savePasswordResetSettings(String username, PasswordResetSettingsInfoImpl passwordResetSettings, int userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		try {
			
			int _userId = checkLogin(username, passwordResetSettings.getCurrentPassword());
			if(_userId != Integer.MIN_VALUE) {
				//System.out.println(passwordResetSettings.getConfirmPassword());
//				 such user exists, so update the password 
				Query query = session.createQuery("update User set recoveryBit = :recoveryBit,"
						+ " password = :password"
						+ " where userID = :userID "
						+ "and password = :curr_password");
				query.setParameter("recoveryBit", 0);
				query.setParameter("password", passwordResetSettings.getConfirmPassword());
				query.setParameter("curr_password", passwordResetSettings.getCurrentPassword());
				query.setParameter("userID", _userId);
				int updatedRows = query.executeUpdate();
				return true;
			}
			
			return false;
			
			
		} catch(HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional
	public boolean saveProfilePictureSettings(ProfilePictureSettingsImpl profilePictureSettings, int userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		try {
			
		} catch(HibernateException e) {
			
		} finally {
			session.close();
		}
		
		
		return false;
	}

	@Override
	@Transactional
	public String getUserFullname(int _userId) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		try {
			System.out.println(_userId);
			Query query = session.createQuery("from UserInfo where userId = :userId");
			query.setParameter("userId", _userId);
			List<UserInfo> retVal = query.list();
			if(retVal != null && retVal.size() != 0 ) {
				return retVal.get(0).getFirstName() +" "+ retVal.get(0).getLastName(); 
			}
			
			return null;
		} catch(HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional
	public ArrayList<SearchResults> search(String keyword) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();

		String queryText1 = "Primary_Email_Id";
		String queryText2 = "City";
		String queryText3 = "Full_Name";
	
		ArrayList<String> retVal = new ArrayList<String>();
		ArrayList<SearchResults> results = new ArrayList<SearchResults>();
		HashSet<Integer> userIds = new HashSet<Integer>();
		try {
			Query q = session.createSQLQuery("SELECT * FROM `user_search_v` WHERE "+queryText3+ " like '"+keyword+"%'");
			//q.setParameter(1, "1");
			//q.setParameter(0, "1");
			List<Object[]> l = q.list();
			if(l!=null){
				Iterator iterator = l.iterator();
				while (iterator.hasNext()) {
				    Object[] row = (Object[])iterator.next();
				    /*for (int col = 0; col < row.length; col++) {
				        System.out.println(row[col]);
				        retVal.add(e)
				    }*/
				    
				    if(!userIds.contains(row[0])){
				    	userIds.add((Integer) row[0]);
				    	retVal.add(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[6]);
				    	String livesIn = "";
				    	if((String) row[3] != null && (String) row[3] != "") {
				    		livesIn = "Lives in " + (String) row[3];
				    	}
				    	results.add(new SearchResults( (Integer) row[0], (String) row[1],
				    			(String)row[2], livesIn, (String)row[6]));
				    	
				    }
				}
			}
			
			
			q = session.createSQLQuery("SELECT * FROM `user_search_v` WHERE upper("+queryText1+") like '"+keyword+"%'");
			//q.setParameter(1, "1");
			//q.setParameter(0, "1");
			l = q.list();
			if(l!=null){
				Iterator iterator = l.iterator();
				while (iterator.hasNext()) {
				    Object[] row = (Object[])iterator.next();
				    /*for (int col = 0; col < row.length; col++) {
				        System.out.println(row[col]);
				        retVal.add(e)
				    }*/
				    
				    if(!userIds.contains(row[0])){
				    	userIds.add((Integer) row[0]);
				    	retVal.add(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[6]);
				    	String livesIn = "";
				    	if((String) row[3] != null && (String) row[3] != "") {
				    		livesIn = "Lives in " + (String) row[3];
				    	}
				    	results.add(new SearchResults( (Integer) row[0], (String) row[1],
				    			(String)row[2], livesIn, (String)row[6]));
				    	
				    }
				}
			}
			
			q = session.createSQLQuery("SELECT * FROM `user_search_v` WHERE "+queryText2+ " like '"+keyword+"%'");
			//q.setParameter(1, "1");
			//q.setParameter(0, "1");
			l = q.list();
			if(l!=null){
				Iterator iterator = l.iterator();
				while (iterator.hasNext()) {
				    Object[] row = (Object[])iterator.next();
				    /*for (int col = 0; col < row.length; col++) {
				        System.out.println(row[col]);
				        retVal.add(e)
				    }*/
				    
				    if(!userIds.contains(row[0])){
				    	userIds.add((Integer) row[0]);
				    	retVal.add(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[6]);
				    	String livesIn = "";
				    	if((String) row[3] != null && (String) row[3] != "") {
				    		livesIn = "Lives in " + (String) row[3];
				    	}
				    	results.add(new SearchResults( (Integer) row[0], (String) row[1],
				    			(String)row[2], livesIn, (String)row[6]));
				    	
				    }
				}
			}
			
			//return retVal;
			return results;
		} catch(HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public String getProfilePicURL(int _userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String path = null;
		try {
			System.out.println(_userId);
			Query query = session.createQuery("from UserInfo where userId = :userId");
			query.setParameter("userId", _userId);
			List<UserInfo> retVal = query.list();
			if(retVal != null && retVal.size() != 0 ) {
				path = retVal.get(0).getProfilePictureURL(); 
			}
			System.out.println(path);
			return path;
		} catch(HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}

	@Transactional
	public List<Group> displayGroups(int userId)
	{
//		System.out.println("inside displayGroups");
		Session session = sessionFactory.openSession();
		//String sqlQuery = " from UserGroups ug inner join ug.userGroup.group" ;
		//Query query = session.createQuery(sqlQuery);
		//query.setParameter(0, 565);
		
		//List<Group> groupList = new ArrayList();
		//List<Object[]>/*<UserGroups>*/ groupsList = query.list(); 
		
		String sql ="select u.Group_Id,g.Group_Name from User_Groups u, Groups g where u.Group_id = g.Group_Id and u.User_id = ?";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, userId);
		List list = query.list(); 
		
		List<Group> groupList= new ArrayList<Group>();
		
		/*for( int i=0; i<list.size();i++ ){
			System.out.println(groupList.get(i));
		}*/
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
		{
			Object[] row = (Object[])it.next();
		    Group group = new Group();
		    group.setGroupId((int) row[0]);
			group.setGroupName((String) row[1]);
			groupList.add(group);
		}
		   
		return groupList;
	}
	
	@Transactional
	public List<UserDetails> suggestFriends(int userId)
	{
		List<UserDetails> suggestionList = new ArrayList<UserDetails>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			String sql = "select user_id, FIRST_NAME, LAST_NAME, ProfilePic_URL from user_info"
				+" where user_id in (select p.suggest_id from ("
				+" select Receiver_Id As suggest_id from friends where sender_id in ("
				+" select s.id from ("
				+" select receiver_id As id from friends where sender_id = ?"
				+" union"
				+" select sender_id As id from friends where receiver_id = ?"
				+" ) s"
				+" ) "
				+" UNION"
				+" select sender_Id As suggest_id from friends where Receiver_Id in ("
				+" select s.id from ("
				+" select receiver_id As id from friends where sender_id = ?"
				+" union"
				+" select sender_id As id from friends where receiver_id = ?"
				+" ) s"
				+" )"
				+" ) p"
				+" where p.suggest_id <> ?"
				+" and p.suggest_id not in("
				+" select sender_id from friends where receiver_id = ?"
				+" UNION"
				+" select receiver_id from friends where sender_id = ?" 
				+" )"
				+" and p.suggest_id not in("
				+" select sender_id from friend_request where receiver_id = ?"
				+" UNION"
				+" select receiver_id from friend_request where sender_id = ?" 
				+" ))";
			
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, userId);
			query.setParameter(1, userId);
			query.setParameter(2, userId);
			query.setParameter(3, userId);
			query.setParameter(4, userId);
			query.setParameter(5, userId);
			query.setParameter(6, userId);
			query.setParameter(7, userId);
			query.setParameter(8, userId);
			List resultList = query.list();
			
			if(resultList.size() > 0){
				addIntoList(resultList, suggestionList);
			}
			//System.out.println("After 1 query "+suggestionList.size());
			if(resultList.size() < 4){
				sql = "select user_id, FIRST_NAME, LAST_NAME, ProfilePic_URL from user_info where User_Id <> ? " 
					+" and ( city in (select city from user_info where user_id = ?) OR city is null) "
					+" and not EXISTS"
					+" (select 1 from friend_request f where f.sender_id = user_id and f.Receiver_Id = ?"
					+" UNION"
					+" select 1 from friend_request f where f.Receiver_Id = user_id and f.Sender_Id = ? "
					+" )and not EXISTS"
					+" ("
					+" select 1 from friends f where f.sender_id = user_id and f.Receiver_Id = ?"
					+" UNION"
					+" select 1 from friends f where f.Receiver_Id = user_id and f.Sender_Id = ?"
					+" )"	;
				query=session.createSQLQuery(sql);
				query.setParameter(0, userId);
				query.setParameter(1, userId);
				query.setParameter(2, userId);
				query.setParameter(3, userId);
				query.setParameter(4, userId);
				query.setParameter(5, userId);
				List citylist = query.list();
				if(citylist.size() > 0){
					addIntoList(citylist, suggestionList);
				}
			}
			
			Set<UserDetails> suggestfriendsSet = new HashSet<UserDetails>(suggestionList);
			suggestionList.clear();
			suggestionList.addAll(suggestfriendsSet);
			
			
		} // end of try
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		 return suggestionList ;
	}
	
	@Transactional
	public List<UserDetails> showPendingFriends(int userId)
	{
		//System.out.println("userId: "+userId);
		List<UserDetails> pendingReqList = new ArrayList<UserDetails>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			String sql = "select user_id, FIRST_NAME, LAST_NAME, ProfilePic_URL from user_info where user_id in" 
					+"( select sender_id from friend_request where receiver_id = ? ) ";
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, userId);
			List list = query.list();
			//System.out.println("query list size"+list.size());
			if(list.size()>0){
				addIntoList(list,pendingReqList);
			}
		}catch(Exception e){
				e.printStackTrace();
				return null;
		}
		return pendingReqList;
	}
	
	@Transactional
	public List<UserDetails> showFriends(int userId)
	{
		System.out.println("userId: "+userId);
		List<UserDetails> friendsList = new ArrayList<UserDetails>();
		try
		{
		Session session = sessionFactory.getCurrentSession();
		String sql = 	"select User_Id, First_Name, Last_Name, ProfilePic_URL from User_Info where User_id in ("
				+" select sender_id  As id from friends f where f.receiver_id = ?"
						+" UNION"		
						+" select receiver_id As id from friends f where f.sender_id = ?"
						+" )";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, userId);
		query.setParameter(1, userId);
		List list = query.list();
		//System.out.println("query list size"+list.size());
		if(list.size()>0){
			addIntoList(list,friendsList);
		}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return friendsList;
	}
	
	public void addIntoList(List inputList, List<UserDetails> suggestionList){
		
		Iterator it = inputList.iterator();
		
		while(it.hasNext()){
			Object[] row = (Object[])it.next();
			UserDetails userdtls = new UserDetails();
			userdtls.setUserId((int) row[0]);
			userdtls.setFirstName((String) row[1]);
			userdtls.setLastName((String)row[2]);
			userdtls.setProfilePicUrl((String)row[3]);
			suggestionList.add(userdtls);
		}
	}
	
}