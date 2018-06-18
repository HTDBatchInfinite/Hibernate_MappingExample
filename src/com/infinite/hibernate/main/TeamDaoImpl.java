package com.infinite.hibernate.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;

import com.infinite.hibernate.Component.Student;
import com.infinite.hibernate.Component.StudentAddress;
import com.infinite.hibernate.JoinusingCriteria.Uni_Student;
import com.infinite.hibernate.JoinusingCriteria.University;
import com.infinite.hibernate.Versioning.Product;
import com.infinite.hibernate.bidirection.Department;
import com.infinite.hibernate.bidirection.Employee;
import com.infinite.hibernate.criteria.Cri_Employee;
import com.infinite.hibernate.customgenerator.Book;
import com.infinite.hibernate.inheritance.ContractEmployee;
import com.infinite.hibernate.inheritance.EmployeeInheritance;
import com.infinite.hibernate.inheritance.RegularEmployee;
import com.infinite.hibernate.merge.Order;
import com.infinite.hibernate.one_to_one.primarykey.ProductDetail;
import com.infinite.hibernate.pojo.Address;
import com.infinite.hibernate.pojo.Bord;
import com.infinite.hibernate.pojo.Player;
import com.infinite.hibernate.pojo.Team;
import com.infinite.hibernate.test.Person;
import com.infinite.hibernate.thirdTable.Bank;
import com.infinite.hibernate.thirdTable.Customer;
import com.infinite.hibernate.timerstamp.User;
import com.infinite.hibernate.utill.HibernateUtill;

public class TeamDaoImpl implements TeamDao {
	Session session = HibernateUtill.getsession();
	Transaction tx = session.beginTransaction();

	public void insert() {

		System.out.println("**" + session);
		System.out.println("after  Session method ");

		System.out.println("in main method");
		// List object creation
		List<Player> pla = new ArrayList<Player>();

		// Bord Object creation
		Bord b = new Bord();
		b.setBordName("PCCI");

		// Address Object Creation
		Address a = new Address();
		a.setState("A");
		a.setCountry("PAK");
		a.setPin(5236);

		Address a1 = new Address();
		a1.setState("B");
		a1.setCountry("PAK");
		a1.setPin(5236);

		Address a2 = new Address();
		a2.setState("C");
		a2.setCountry("PAK");
		a2.setPin(5236);

		Address a3 = new Address();
		a3.setState("D");
		a3.setCountry("PAK");
		a3.setPin(8236);

		// Player Object creation
		Player player = new Player();
		player.setPlayerName("Younus Khan");
		player.setPlayerScore(10000);
		player.setPlayerAvarage(30);
		player.setPlayerWickets(70);
		player.setAddress(a);
		/* session.save(player); */
		Player player1 = new Player();
		player1.setPlayerName("Shoaib Malik");
		player1.setPlayerScore(11000);
		player1.setPlayerAvarage(37);
		player1.setPlayerWickets(180);
		player1.setAddress(a1);

		/* session.save(player1); */
		Player player2 = new Player();
		player2.setPlayerName("Shahid Afridi");
		player2.setPlayerScore(11300);
		player2.setPlayerAvarage(39);
		player2.setPlayerWickets(14);
		player2.setAddress(a2);

		/* session.save(player2); */
		Player player3 = new Player();
		player3.setPlayerName("Misbah-ul-Haq");
		player3.setPlayerScore(5000);
		player3.setPlayerAvarage(22);
		player3.setPlayerWickets(16);
		player3.setAddress(a3);

		/* session.save(player3); */
		// add the players to the list
		pla.add(player);
		pla.add(player1);
		pla.add(player2);
		pla.add(player3);

		// Team object creation
		Team team = new Team();
		team.setTeamName("PAKISTAN");
		// set the bord object
		team.setBord(b);

		// Player set to team
		team.setPlayers(pla);

		try {
			System.out.println("before session ....................");
			session.save(team);

			System.out.println("hai");
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

	public void getData() {

		System.out.println("Enter the sid ...........");

		Scanner s = new Scanner(System.in);
		// read the Id
		int id = s.nextInt();
		// Hql query
		String hql = " from Team t where t.teamNo=?";
		// create query
		Query query = session.createQuery(hql);
		// set parameter
		query.setParameter(0, id);
		System.out.println(id);
		System.out.println(query);

		List<Team> list = query.list();
		// for each loop
		for (Team team : list) {
			System.out.println("******************************************");
			System.out.println(" ");

			System.out.println("Team Id is.........." + team.getTeamNo());
			System.out.println("Team Name is........." + team.getTeamName());

			System.out.println(" ");
			System.out.println("********************************************");

			System.out.println(" ");
			System.out
					.println("********************************************* ");
			System.out.println();

			System.out.println("bord id is........"
					+ team.getBord().getBordId());
			System.out.println("Bord Name is..........."
					+ team.getBord().getBordName());

			System.out.println(" ");
			System.out
					.println("********************************************* ");

			System.out.println(" ");

			System.out
					.println("************************************************");
			System.out.println(" ");

		}

	}
	public void getjoinqueryData() {

		// select all data...query
		String hql = "from Team";

		// select specific team

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Team No.......");

		int teamno = s.nextInt();

		String hql1 = "from Team t where t.teamNo=?";

		Query query = session.createQuery(hql1);
		query.setParameter(0, teamno, Hibernate.INTEGER);

		// hql hibernate query
		// Query query=session.createQuery(hql);

		// get Team object
		List<Team> list = query.list();

		// iterator the team
		Iterator<Team> itr = list.iterator();
		while (itr.hasNext()) {
			Team t = itr.next();
			// align purpose
			System.out.println();
			System.out
					.println("****************** Team Details ***********************");
			System.out.println();

			System.out.println("Team No: " + t.getTeamNo());
			System.out.println("Team Name is: " + t.getTeamName());

			System.out.println();

			// align purpose
			System.out
					.println("**************** Bord Details *****************************");
			System.out.println();

			System.out.println("Bord Id is" + t.getBord().getBordId());
			System.out.println("Bord name is" + t.getBord().getBordName());

			System.out.println();

			// Assign list of players
			List<Player> list2 = t.getPlayers();
			// iterator the players
			Iterator<Player> itr2 = list2.iterator();

			while (itr2.hasNext()) {

				Player p = itr2.next();

				System.out.println();

				// align purpose
				System.out.println();
				System.out
						.println("********************** Player Details ************************");
				System.out.println();

				System.out.println("Player Id is....." + p.getPlayerId());
				System.out.println("Player Nmae is...." + p.getPlayerName());
				System.out.println("Player Score is...." + p.getPlayerScore());
				System.out.println("player Avarsge is..."
						+ p.getPlayerAvarage());
				System.out.println("player Wickets is...."
						+ p.getPlayerWickets());

				System.out.println();

				// align purpose
				System.out.println();
				System.out
						.println("******************* Address Details *******************************");
				System.out.println();
				System.out.println("Player Address id is.........."
						+ p.getAddress().getId());
				System.out.println("Player Address Country is......"
						+ p.getAddress().getCountry());
				System.out.println("Player Address State is.........."
						+ p.getAddress().getState());
				System.out.println("Player Address Pin is............."
						+ p.getAddress().getPin());

				System.out.println();
				System.out.println();
			}

		}

		/*
		 * String hql1 = "from Team t left join  t.players ";
		 * 
		 * Query query = session.createQuery(hql1);
		 * 
		 * List<Team> list = query.list();
		 * 
		 * for (Team team : list) {
		 * 
		 * System.out.println("******************************************");
		 * System.out.println();
		 * System.out.println("Team No is.................." +
		 * team.getTeamNo()); System.out.println("Team Name is ..............."
		 * + team.getTeamName()); System.out.println(); System.out
		 * .println("************************************************");
		 * 
		 * System.out.println(""); System.out
		 * .println("*************************************************");
		 * System.out.println(); System.out.println("Bord id is............" +
		 * team.getBord().getBordId());
		 * System.out.println("Bord name is..........." +
		 * team.getBord().getBordName()); System.out.println(); System.out
		 * .println("****************************************************");
		 * System.out.println();
		 * 
		 * System.out.println("Hai");
		 * System.out.println("Player id is...................." +
		 * team.getPlayers().get(0).getPlayerId());
		 * System.out.println("player name is..................." +
		 * team.getPlayers().get(0).getPlayerName());
		 * System.out.println("player name is..................." +
		 * team.getPlayers().get(0).getPlayerAvarage());
		 * System.out.println("player name is..................." +
		 * team.getPlayers().get(0).getPlayerScore());
		 * System.out.println("player name is..................." +
		 * team.getPlayers().get(0).getPlayerWickets());
		 * 
		 * System.out.println();
		 * 
		 * System.out.println("player address..............." +
		 * team.getPlayers().get(0).getAddress().getCountry());
		 * System.out.println("player address..............." +
		 * team.getPlayers().get(0).getAddress().getId());
		 * System.out.println("player address..............." +
		 * team.getPlayers().get(0).getAddress().getState());
		 * System.out.println("player address..............." +
		 * team.getPlayers().get(0).getAddress().getPin()); }
		 */

	}

	public void loadmethodGETdata() {
		// scanner
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the  Team No.......");
		// read the team No
		int no = s.nextInt();
		// load the Team
		if (no == 1) {
			System.out.println(" if block" + no);
			Team team = (Team) session.load(Team.class, no);

			System.out.println();
			System.out
					.println("******************Team Details***************************");
			System.out.println();

			System.out.println("Team no is........." + team.getTeamNo());
			System.out.println("team Name is......." + team.getTeamName());

			System.out.println();
			System.out
					.println("********************************************************");
			System.out.println();

			System.out.println();
			System.out
					.println("*********************** Bord Details ********************************");
			System.out.println();
			System.out.println("Bord id is.............."
					+ team.getBord().getBordId());
			System.out.println("bord name is............"
					+ team.getBord().getBordName());
			System.out.println("");
			System.out
					.println("*******************************************************");
			System.out.println();

			// get the Player size.....
			for (int i = 1; i <= team.getPlayers().size(); i++) {

				System.out.println();
				System.out
						.println("*************************Player Details******************");
				System.out.println();

				System.out.println(i);
				// load the player
				Player p = (Player) session.load(Player.class, i);

				System.out.println("Player id is.........." + p.getPlayerId());
				System.out.println("player Name is........."
						+ p.getPlayerName());
				System.out.println("player Score is........."
						+ p.getPlayerScore());
				System.out.println("player Avarage is........"
						+ p.getPlayerAvarage());
				System.out.println("player wickets is........."
						+ p.getPlayerWickets());
				System.out.println();

				System.out
						.println("***************** Player Address Details***************************");
				System.out.println();

				System.out.println("player Address id..........."
						+ p.getAddress().getId());
				System.out.println("player Address country......."
						+ p.getAddress().getCountry());
				System.out.println("player Address State........."
						+ p.getAddress().getState());
				System.out.println("player Address pin............."
						+ p.getAddress().getPin());
			}
		}

		else {

			System.out.println("Else block" + no);

			Team team = (Team) session.load(Team.class, no);

			System.out.println();
			System.out
					.println("******************Team Details***************************");
			System.out.println();

			System.out.println("Team no is........." + team.getTeamNo());
			System.out.println("team Name is......." + team.getTeamName());

			System.out.println();
			System.out
					.println("********************************************************");
			System.out.println();

			System.out.println();
			System.out
					.println("*********************** Bord Details ********************************");
			System.out.println();
			System.out.println("Bord id is.............."
					+ team.getBord().getBordId());
			System.out.println("bord name is............"
					+ team.getBord().getBordName());
			System.out.println("");
			System.out
					.println("*******************************************************");
			System.out.println();

			System.out.println(team.getPlayers().size());
			// get the Player size.....
			for (int i = 1; i <= team.getPlayers().size(); i++) {

				System.out.println(i);

				System.out.println();
				System.out
						.println("*************************Player Details******************");
				System.out.println();

				System.out.println(i);
				// load the player
				Player p = (Player) session.load(Player.class, i);

				System.out.println("Player id is.........." + p.getPlayerId());
				System.out.println("player Name is........."
						+ p.getPlayerName());
				System.out.println("player Score is........."
						+ p.getPlayerScore());
				System.out.println("player Avarage is........"
						+ p.getPlayerAvarage());
				System.out.println("player wickets is........."
						+ p.getPlayerWickets());
				System.out.println();

				System.out
						.println("***************** Player Address Details***************************");
				System.out.println();

				System.out.println("player Address id..........."
						+ p.getAddress().getId());
				System.out.println("player Address country......."
						+ p.getAddress().getCountry());
				System.out.println("player Address State........."
						+ p.getAddress().getState());
				System.out.println("player Address pin............."
						+ p.getAddress().getPin());
			}

		}

	}

	public void deleteTeamById() {
		// Scanner class
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the id..............");

		int did = s.nextInt();

		Team team = (Team) session.load(Team.class, did);

		// delete data
		session.delete(team);
		tx.commit();

	}

	public void deleteBordRecord() {
		// scanner class
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the id.....");

		int cid = s.nextInt();

		Team team = (Team) session.load(Team.class, cid);

		int bid = team.getBord().getBordId();

		Bord delid = (Bord) session.load(Bord.class, bid);

		session.delete(delid);
		tx.commit();

	}

	public void deleteTeamToPlayer() {

		Scanner s = new Scanner(System.in);

		System.out.println("Which team want to delete player............");

		int teamNo = s.nextInt();

		// load the Team
		Team team = (Team) session.load(Team.class, teamNo);

		System.out
				.println("which player you want delete Enter player no........");

		int playerNo = s.nextInt();

		Player delplayer = (Player) session.load(Player.class, playerNo);

		session.delete(delplayer);
		tx.commit();
		System.out.println("delete method..................");
	}

	public void UpdateBordRecord() {
		// scanner class
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the id.....");

		int cid = s.nextInt();

		Team team = (Team) session.load(Team.class, cid);

		int bid = team.getBord().getBordId();

		Bord updateRecord = (Bord) session.load(Bord.class, bid);

		updateRecord.setBordId(2);
		updateRecord.setBordName("GCCI");

		tx.commit();
	}

	public void addPlayerToTeam() {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter the team no............");

		int teamNo = s.nextInt();

		Team team = (Team) session.load(Team.class, teamNo);

		List<Player> list = new ArrayList<Player>();
		System.out
				.println("*****************************  Enter Player Address Details *****************************");
		System.out.println();

		System.out.println("Enter the counter of Player.....................");

		String country = s.next();

		System.out
				.println("Enter the State of the Player........................");

		String state = s.next();

		System.out
				.println("Address pin No......................................");

		int pin = s.nextInt();
		Address address = new Address();
		address.setCountry(country);
		address.setState(state);
		address.setPin(pin);
		System.out.println();
		System.out
				.println("******************** Enter the Player Details *****************************");
		System.out.println();

		System.out.println("Enter the player Name..........................");

		String pname = s.next();

		System.out.println("Enter the Player Score........................");

		int pscore = s.nextInt();
		System.out
				.println("Enter the Player Avarage..........................");

		int pavg = s.nextInt();

		System.out
				.println("Enter the Player Wickets..........................");

		int pwick = s.nextInt();

		System.out.println();
		Player player = new Player();
		player.setPlayerName(pname);
		player.setPlayerScore(pscore);
		player.setPlayerAvarage(pavg);
		player.setPlayerWickets(pwick);
		player.setAddress(address);

		list.add(player);

		team.setPlayers(list);

		tx.commit();

	}

	public void updateToPlayer() {

		Scanner s = new Scanner(System.in);

		System.out.println("which team player player want to update..........");

		int teamNo = s.nextInt();

		Team team = (Team) session.load(Team.class, teamNo);

		System.out.println("which player data want to update...............");

		int playerNo = s.nextInt();

		Player player = (Player) session.load(Player.class, playerNo);

		System.out.println("Enter the Player Score.............");

		int updatescore = s.nextInt();

		player.setPlayerScore(updatescore);

		tx.commit();
	}

	public void cacheExample() {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Address Id..........");

		int addressid = s.nextInt();

		System.out
				.println("************************First time Hit Data base**********************");

		System.out.println();

		Address address = (Address) session.load(Address.class, addressid);

		System.out.println("Address id........." + address.getId());
		System.out.println("State is..........." + address.getState());
		System.out.println("Country is.........." + address.getCountry());
		System.out.println("Pine is............." + address.getPin());

		System.out
				.println("**************************** second time  **************************");

		Address address1 = (Address) session.load(Address.class, addressid);

		System.out.println("Address id........." + address1.getId());
		System.out.println("State is..........." + address1.getState());
		System.out.println("Country is.........." + address1.getCountry());
		System.out.println("Pine is............." + address1.getPin());

		session.clear();

		Address address2 = (Address) session.load(Address.class, addressid);

		System.out.println("Address id........." + address2.getId());
		System.out.println("State is..........." + address2.getState());
		System.out.println("Country is.........." + address2.getCountry());
		System.out.println("Pine is............." + address2.getPin());

	}

	public void oneTOmanyBidirection() {
		System.out.println("One to many mapping clas");

		List<Employee> list = new ArrayList<Employee>();

		Department department = new Department();

		department.setDepartmentName("CSE");

		Employee employee = new Employee();

		employee.setEmployeeName("suresh");
		employee.setEmployeeSalary(12000);
		employee.setEmployeeAddress("AP");
		/*
		 * employee.setDepartments(department);
		 */
		Employee employee1 = new Employee();

		employee1.setEmployeeName("rakesh");
		employee1.setEmployeeSalary(13000);
		employee1.setEmployeeAddress("AP");
		/*
		 * employee1.setDepartments(department);
		 */
		Employee employee2 = new Employee();

		employee2.setEmployeeName("subhash");
		employee2.setEmployeeSalary(14000);
		employee2.setEmployeeAddress("AP");
		/* employee2.setDepartments(department); */

		Employee employee3 = new Employee();

		employee3.setEmployeeName("varun");
		employee3.setEmployeeSalary(10000);
		employee3.setEmployeeAddress("AP");
		/*
		 * employee3.setDepartments(department);
		 */
		Employee employee4 = new Employee();

		employee4.setEmployeeName("mahesh");
		employee4.setEmployeeSalary(9000);
		employee4.setEmployeeAddress("AP");
		/*
		 * employee4.setDepartments(department);
		 */

		list.add(employee);
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		list.add(employee4);

		System.out.println("BEFORE DEPARTMENT Commented.....");

		department.setEmployees(list);

		employee.setDepartments(department);
		employee1.setDepartments(department);
		employee2.setDepartments(department);
		employee3.setDepartments(department);
		employee4.setDepartments(department);
		try {
			session.save(department);
			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

	public void ComponentExample() {

		List<Student> stulist;

		StudentAddress studentAddress = new StudentAddress();
		studentAddress.setCountry("INDIA");
		studentAddress.setState("AP");
		studentAddress.setCity("ONGOLE");
		studentAddress.setPine(523265);

		StudentAddress studentAddress1 = new StudentAddress();
		studentAddress1.setCountry("INDIA");
		studentAddress1.setState("AP");
		studentAddress1.setCity("KADAPA");
		studentAddress1.setPine(623265);

		StudentAddress studentAddress2 = new StudentAddress();
		studentAddress2.setCountry("INDIA");
		studentAddress2.setState("AP");
		studentAddress2.setCity("NELLORE");
		studentAddress2.setPine(423265);

		StudentAddress studentAddress3 = new StudentAddress();
		studentAddress3.setCountry("INDIA");
		studentAddress3.setState("AP");
		studentAddress3.setCity("ONGOLE");
		studentAddress3.setPine(223263);

		StudentAddress studentAddress4 = new StudentAddress();
		studentAddress4.setCountry("INDIA");
		studentAddress4.setState("AP");
		studentAddress4.setCity("GUNTUR");
		studentAddress4.setPine(323265);

		Student student = new Student();
		student.setStudentName("Suresh");
		student.setStudentAge(23);
		student.setStudentCollege("QIS & ENG");
		student.setStudentDepartment("CSE");
		student.setAddress(studentAddress);

		Student student1 = new Student();
		student1.setStudentName("Rakesh");
		student1.setStudentAge(23);
		student1.setStudentCollege("SSN & ENG");
		student1.setStudentDepartment("CSE");
		student1.setAddress(studentAddress1);

		Student student2 = new Student();
		student2.setStudentName("SuBhash");
		student2.setStudentAge(23);
		student2.setStudentCollege("Naidu & ENG");
		student2.setStudentDepartment("CSE");
		student2.setAddress(studentAddress2);

		Student student3 = new Student();
		student3.setStudentName("Varun");
		student3.setStudentAge(23);
		student3.setStudentCollege("QIS & ENG");
		student3.setStudentDepartment("CSE");
		student3.setAddress(studentAddress3);

		Student student4 = new Student();
		student4.setStudentName("john");
		student4.setStudentAge(23);
		student4.setStudentCollege("Pace & ENG");
		student4.setStudentDepartment("CSE");
		student4.setAddress(studentAddress4);

		stulist = new ArrayList<Student>();
		stulist.add(student);
		stulist.add(student1);
		stulist.add(student2);
		stulist.add(student3);
		stulist.add(student4);

		try {
			session.save(student);
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.save(student4);

			/* session.save(stulist); */
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void getDataComponentExample() {
		String hql = "from Student";

		Query query = session.createQuery(hql);

		List<Student> list = query.list();
		for (Student student : list) {

			System.out
					.println("******************* STUDENT DATA ****************");
			System.out.println();
			System.out.println("STUDENT ID IS......." + student.getStudentId());
			System.out.println("STUDENT NAME IS........"
					+ student.getStudentName());
			System.out.println("STUDENT AGE IS............"
					+ student.getStudentAge());
			System.out.println("STUDENT COLLEGE IS.........."
					+ student.getStudentCollege());
			System.out.println("STUDENT DEPT IS................"
					+ student.getStudentDepartment());

			System.out.println();
			System.out
					.println("*****************Student Address***********************");
			System.out.println();
			System.out.println("COUNTRY is..............."
					+ student.getAddress().getCountry());
			System.out.println("STATE is..................."
					+ student.getAddress().getState());
			System.out.println("CITY is......................."
					+ student.getAddress().getCity());
			System.out.println("PINE is..........................."
					+ student.getAddress().getPine());
		}
	}

	public void getDataSpecificeComponentExample() {
		String hql = "from Student s where s.studentId=?";

		Scanner s = new Scanner(System.in);

		System.out.println("Enter the Student id...........");

		int stuNo = s.nextInt();

		Query query = session.createQuery(hql);
		query.setParameter(0, stuNo, Hibernate.INTEGER);
		List<Student> list = query.list();
		for (Student student : list) {

			System.out
					.println("******************* STUDENT DATA ****************");
			System.out.println();
			System.out.println("STUDENT ID IS......." + student.getStudentId());
			System.out.println("STUDENT NAME IS........"
					+ student.getStudentName());
			System.out.println("STUDENT AGE IS............"
					+ student.getStudentAge());
			System.out.println("STUDENT COLLEGE IS.........."
					+ student.getStudentCollege());
			System.out.println("STUDENT DEPT IS................"
					+ student.getStudentDepartment());

			System.out.println();
			System.out
					.println("*****************Student Address***********************");
			System.out.println();
			System.out.println("COUNTRY is..............."
					+ student.getAddress().getCountry());
			System.out.println("STATE is..................."
					+ student.getAddress().getState());
			System.out.println("CITY is......................."
					+ student.getAddress().getCity());
			System.out.println("PINE is..........................."
					+ student.getAddress().getPine());
		}
	}

	// One Table Per Class Hierarchy example
	public void TablePerClassHierarchyExample() {

		EmployeeInheritance ei = new EmployeeInheritance();

		ei.setEmployeeName("RAMESH");
		ei.setEmployeeAge(22);

		session.save(ei);
		tx.commit();

		RegularEmployee re = new RegularEmployee();

		re.setEmployeeName("VARUN");
		re.setEmployeeAge(24);
		re.setSalary(12000);
		re.setBonus(2000);

		session.save(re);
		tx.commit();

		ContractEmployee ce = new ContractEmployee();

		ce.setEmployeeName("RaMESH");
		ce.setEmployeeAge(23);
		ce.setPay_for_hour(1000);
		ce.setTimePeriode(2);

		session.save(ce);
		tx.commit();
	}

	public void TableForSubClassHierarchyExample() {
		EmployeeInheritance ei = new EmployeeInheritance();

		ei.setEmployeeName("RAMESH");
		ei.setEmployeeAge(22);

		session.save(ei);
		tx.commit();

		RegularEmployee re = new RegularEmployee();
		re.setEmployeeName("VARUN");
		re.setEmployeeAge(24);
		re.setSalary(12000);
		re.setBonus(2000);

		session.save(re);
		tx.commit();

		ContractEmployee ce = new ContractEmployee();

		ce.setEmployeeName("RaMESH");
		ce.setEmployeeAge(23);
		ce.setPay_for_hour(1000);
		ce.setTimePeriode(2);

		session.save(ce);
		tx.commit();
	}

	public void TablePerConcreteClassHierarchyExample() {
		EmployeeInheritance ei = new EmployeeInheritance();

		ei.setEmployeeName("RAMESH");
		ei.setEmployeeAge(22);

		session.save(ei);
		tx.commit();

		RegularEmployee re = new RegularEmployee();
		re.setEmployeeName("VARUN");
		re.setEmployeeAge(24);
		re.setSalary(12000);
		re.setBonus(2000);

		session.save(re);
		tx.commit();

		ContractEmployee ce = new ContractEmployee();
		ce.setEmployeeName("RaMESH");
		ce.setEmployeeAge(23);
		ce.setPay_for_hour(1000);
		ce.setTimePeriode(2);

		session.save(ce);
		tx.commit();
	}

	public void getDateTablePerClassHierarchyExample() {
		String hql = "select * from EmployeeInheritance_table";

		Query query = session.createQuery(hql);

		List<Object> list = query.list();

		EmployeeInheritance ei = (EmployeeInheritance) list;

		System.out.println("EMPLOYEE ID IS.........." + ei.getEmployeeId());

		System.out.println("EMPLOYEE ID IS.........." + ei.getEmployeeName());

		System.out.println("EMPLOYEE ID IS.........." + ei.getEmployeeAge());

		RegularEmployee re = (RegularEmployee) list;

		System.out.println("Employee Id Is........" + re.getEmployeeId());
		System.out.println("Employee Name Is......" + re.getEmployeeName());
		System.out.println("EMPLOYEE AGE Is........" + re.getEmployeeAge());
		System.out.println("Employee Salary is........." + re.getSalary());
		System.out.println("Employee Bouns is......." + re.getBonus());

		ContractEmployee ce = (ContractEmployee) list;

		System.out.println("Employee Id Is........" + ce.getEmployeeId());
		System.out.println("Employee Name Is......" + ce.getEmployeeName());
		System.out.println("EMPLOYEE AGE Is........" + ce.getEmployeeAge());
		System.out.println("EmploYee Hours is......." + ce.getPay_for_hour());
		System.out.println("Employee TIMEPERIOD IS....." + ce.getTimePeriode());

	}

	public void getDataSubClasClassHierarchyExample1() {

		Criteria ca = session.createCriteria(EmployeeInheritance.class);
		ca.add(Restrictions.eq("EmployeeId", 2)).list();
		ca.add(Restrictions.eq("EmployeeId", 3)).list();

		System.out.println(ca);

	}

	public void TestPersonInsert() {
		Person p = new Person();
		p.setPersonId(1);
		p.setPersonName("suresh");
		p.setPersonAge(23);

		int id = (Integer) session.save(p);
		tx.commit();
		if (id > 0) {
			System.out.println("record is insert.................!");
		} else {
			System.out.println("RECORD INSERT IS FAIL..............!");
		}
	}

	public void getDataPerson() {
		Scanner s = new Scanner(System.in);

		System.out.println("ENTER THE PERSON ID...............");

		int pid = s.nextInt();

		try

		{
			Thread.sleep(50000);

			Person p = (Person) session.load(Person.class, pid);

			System.out.println("PERSON ID IS............" + p.getPersonId());
			System.out.println("PERSON NAME IS..............."
					+ p.getPersonName());
			System.out.println("PERSON AGE IS....................."
					+ p.getPersonAge());

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testUpdatePerson() {
		Scanner s = new Scanner(System.in);

		System.out.println("ENTER THE PERSON ID..................");

		int pid = s.nextInt();
		try {
			Thread.sleep(2000);
			Person p1 = (Person) session.load(Person.class, pid);

			p1.setPersonName("HARI");

			tx.commit();
			System.out.println("PERSON ID IS.........." + p1.getPersonId());

			System.out.println("PERSON NAME IS........... "
					+ p1.getPersonName());

			System.out.println("PERSON AGE IS..................."
					+ p1.getPersonAge());

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void HibernateVersoning() {
		Product product = new Product();
		product.setProductName("CELL");
		product.setProductPrice(30000);

		try {
			session.persist(product);

			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void getProductData() {
		Scanner s = new Scanner(System.in);

		System.out.println("ENTER THE PRODUCT ID..........");

		int ProductId = s.nextInt();
		try {
			Thread.sleep(30000);

			Product product = (Product) session.load(Product.class, ProductId);

			System.out.println("");
			System.out
					.println("***************** PRODUCT DETAILS ****************");
			System.out.println();

			System.out
					.println("Product Id is........" + product.getProductId());
			System.out.println("PRODUCT NAME is.........."
					+ product.getProductName());
			System.out.println("PRODUCT PRICE is.............."
					+ product.getProductPrice());

			System.out.println();
			System.out.println();

			System.out.println("Product Version is.........................."
					+ product.getVer());

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void productUpdate() {
		Scanner s = new Scanner(System.in);
		System.out.println("WHICH ID YOU WANT TO UPDATE...........");

		int productId = s.nextInt();

		try {
			Thread.sleep(3000);
			Product p = (Product) session.load(Product.class, productId);

			System.out.println("ENTER THE PRICE OF PRoduct...................");

			int ProductPricre = s.nextInt();

			p.setProductPrice(ProductPricre);
			tx.commit();

			System.out.println();

			System.out.println("************** PRODUCT DETAILS **************");
			System.out.println();

			System.out.println("Product Id is........" + p.getProductId());
			System.out
					.println("PRODUCT NAME is.........." + p.getProductName());
			System.out.println("PRODUCT PRICE is.............."
					+ p.getProductPrice());

			System.out.println();
			System.out.println();

			System.out.println("Product Version is.........................."
					+ p.getVer());

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UserTimerStamp() {

		User u = new User();

		u.setUserName("CHANDU");
		u.setUserAddress("AP");

		try {
			session.save(u);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void getDataTimerStamp() {
		Scanner s = new Scanner(System.in);
		System.out.println("ENTER THE USER ID ................");

		int userId = s.nextInt();
		try {
			Thread.sleep(30000);

			User user = (User) session.load(User.class, userId);

			System.out.println("*********** User Details ************");
			System.out.println();
			System.out.println("USER ID is........" + user.getUserId());
			System.out.println("USER NAME is..........." + user.getUserName());
			System.out.println("USER Address is ............"
					+ user.getUserAddress());

			System.out.println();
			System.out.println();

			System.out.println("USER MODIFYED is..............."
					+ user.getLastModifyedBy());
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UserUpdateTimerstamp() {
		Scanner s = new Scanner(System.in);
		System.out.println("ENTER THE WHICH USER ID UPDATE.............");

		int userId = s.nextInt();
		try {
			Thread.sleep(3000);
			User user = (User) session.load(User.class, userId);

			System.out.println("ENTER THE NAME OF USER...............");

			String userName = s.next();

			user.setUserName(userName);
			tx.commit();

			System.out.println();
			System.out
					.println("****************** USER  DETAILS ******************");

			System.out.println("USER ID is ......................"
					+ user.getUserId());

			System.out.println("USER NAME iS.........................."
					+ user.getUserName());
			System.out.println("USER ADDRESS IS............................"
					+ user.getUserAddress());
			System.out.println();
			System.out.println();
			System.out
					.println("USER LAST MODIFYED BY.............................."
							+ user.getLastModifyedBy());

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void InserForMerge() {
		Order order = new Order();

		order.setOrderName("B");
		order.setOrderCost(2000);

		try {
			session.save(order);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public void MergeExample() {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter the OrderId.......");

		int orderId = s.nextInt();

		Order order = (Order) session.load(Order.class, orderId);

		session.close();

		order.setOrderCost(1500);
		Session session1 = HibernateUtill.getsession();

		Order order1 = (Order) session1.load(Order.class, orderId);

		session1.merge(order);

	}

	public void oneToonePrimaryKeyMappingExample() {

		ProductDetail pd = new ProductDetail();
		pd.setAddress("Hyd");

		com.infinite.hibernate.one_to_one.primarykey.Product1 p = new com.infinite.hibernate.one_to_one.primarykey.Product1();

		p.setPname("Pen");
		p.setPrice(10);
		p.setProductDetail(pd);

		try {

			System.out.println("Inside try block");
			session.save(p);
			tx.commit();
		} catch (HibernateException e) {

			tx.rollback();
			e.printStackTrace();
		}
	}

	public void insertCri_Employee() {

		System.out.println("Inside Criteria Method.........");
		try {

			Cri_Employee ce = new Cri_Employee();

			ce.setEmployeeName("Sivaji");
			ce.setEmployeeDept("Def");
			ce.setEmployeeSalary(10200);

			System.out.println("session............" + session);

			int id = (Integer) session.save(ce);

			System.out.println("Id value is ............" + id);

			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void getCritariaData() {

		Criteria criteria = session.createCriteria(Cri_Employee.class);

		List<Cri_Employee> list = criteria.list();

		for (Cri_Employee cr : list) {

			System.out.println("Employee Id is........" + cr.getEmployeeId());
			System.out.println("Employee Name is.............."
					+ cr.getEmployeeName());
			System.out.println("Employee Department..................."
					+ cr.getEmployeeDept());
			System.out
					.println("Employee Salary is............................."
							+ cr.getEmployeeSalary());

		}

		System.out.println();
		System.out.println();
		System.out
				.println("Employe whose Salary is Gt 12000 and Id is Ge 5......");
		System.out.println();

		Criteria cr = session.createCriteria(Cri_Employee.class);

		cr.add(Restrictions.gt("employeeSalary", 12000));

		List<Cri_Employee> list1 = cr.list();

		for (Cri_Employee ci : list1) {

			System.out.println("Employee Id is........" + ci.getEmployeeId());
			System.out.println("Employee Name is.............."
					+ ci.getEmployeeName());
			System.out.println("Employee Department..................."
					+ ci.getEmployeeDept());
			System.out
					.println("Employee Salary is............................."
							+ ci.getEmployeeSalary());

		}

		System.out.println();
		System.out.println();
		System.out.println("Employe whose Salary is lt 12000 ");
		System.out.println();

		Criteria cr2 = session.createCriteria(Cri_Employee.class);

		cr2.add(Restrictions.lt("employeeSalary", 12000));

		List<Cri_Employee> list11 = cr.list();

		for (Cri_Employee ci2 : list11) {

			System.out.println("Employee Id is........" + ci2.getEmployeeId());
			System.out.println("Employee Name is.............."
					+ ci2.getEmployeeName());
			System.out.println("Employee Department..................."
					+ ci2.getEmployeeDept());
			System.out
					.println("Employee Salary is............................."
							+ ci2.getEmployeeSalary());

		}

	}

	public void CriteriaMultipleData() {

		Criteria cr1 = session.createCriteria(Cri_Employee.class);

		cr1.add(Restrictions.gt("employeeSalary", 12000));
		cr1.add(Restrictions.lt("employeeId", 8));

		List<Cri_Employee> list2 = cr1.list();

		for (Cri_Employee ci1 : list2) {

			System.out.println("Employee Id is........" + ci1.getEmployeeId());
			System.out.println("Employee Name is.............."
					+ ci1.getEmployeeName());
			System.out.println("Employee Department..................."
					+ ci1.getEmployeeDept());
			System.out
					.println("Employee Salary is............................."
							+ ci1.getEmployeeSalary());

		}

		System.out.println();
		System.out.println();
		System.out.println("Employe whose Salary is lt 12000 ");
		System.out.println();

		Criteria cr3 = session.createCriteria(Cri_Employee.class);

		cr3.add(Restrictions.ilike("employeeName", "%%%%sh"));
		cr1.add(Restrictions.gt("employeeSalary", 12000));

		List<Cri_Employee> list3 = cr3.list();

		for (Cri_Employee cri : list3) {

			System.out.println("Employee Id is........" + cri.getEmployeeId());
			System.out.println("Employee Name is.............."
					+ cri.getEmployeeName());
			System.out.println("Employee Department..................."
					+ cri.getEmployeeDept());
			System.out
					.println("Employee Salary is............................."
							+ cri.getEmployeeSalary());
		}

	}

	public void UniqueCriteriaExample() {

		Criteria criteria = session.createCriteria(Cri_Employee.class);
		criteria.add(Restrictions.gt("employeeSalary", 12000));
		criteria.setMaxResults(1);

		Cri_Employee cr4 = (Cri_Employee) criteria.uniqueResult();

		System.out.println("Employee Id is........" + cr4.getEmployeeId());
		System.out.println("Employee Name is.............."
				+ cr4.getEmployeeName());
		System.out.println("Employee Department..................."
				+ cr4.getEmployeeDept());
		System.out.println("Employee Salary is............................."
				+ cr4.getEmployeeSalary());

	}

	public void pagenationCriteria() {
		Criteria cr = session.createCriteria(Cri_Employee.class);
		cr.setFirstResult(1);
		cr.setMaxResults(2);

		List<Cri_Employee> list = cr.list();
		for (Cri_Employee cri : list) {

			System.out.println("Employee Id is........" + cri.getEmployeeId());
			System.out.println("Employee Name is.............."
					+ cri.getEmployeeName());
			System.out.println("Employee Department..................."
					+ cri.getEmployeeDept());
			System.out
					.println("Employee Salary is............................."
							+ cri.getEmployeeSalary());

		}

	}

	public void DistinctCriteria() {

		Criteria cr = session.createCriteria(Cri_Employee.class);

		cr.add(Restrictions.gt("employeeSalary", 9000));
		/*
		 * cr.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		 */
	}

	public void DesUsingCriteria() {
		Criteria cr = session.createCriteria(Cri_Employee.class);

		cr.add(Restrictions.gt("employeeSalary", 9000));
		cr.addOrder(org.hibernate.criterion.Order.asc("employeeSalary"));

		List<Cri_Employee> list = cr.list();

		for (Cri_Employee c : list) {

			System.out.println();
			System.out.println("Employee Salary is............"
					+ c.getEmployeeSalary());
			System.out.println();
		}

	}

	public void AscUsingCriteria() {

		Criteria cr1 = session.createCriteria(Cri_Employee.class);

		cr1.add(Restrictions.gt("employeeSalary", 18000));
		cr1.addOrder(org.hibernate.criterion.Order.desc("employeeSalary"));
        
		List<Cri_Employee> list1 = cr1.list();

		for (Cri_Employee cri : list1) {

			System.out.println("Employee Salary is.................."
					+ cri.getEmployeeSalary());
		}

	}

	public void RowCountUsingCriteria() {
		Criteria criteria = session.createCriteria(Cri_Employee.class);

		criteria.setProjection(Projections.rowCount());

		List<Integer> id = criteria.list();

		System.out.println(id);
	}

	public void SelectAllNameusing() {
		Criteria criteria = session.createCriteria(Cri_Employee.class);

		criteria.setProjection(Projections.property("employeeName"));

		List<String> Names = criteria.list();

		for (String c : Names) {

			System.out.println("Employee name is................"
					+ c.toString());

		}

	}

	public void Max_Min_ValueUsingCriteria() {
		Criteria cri = session.createCriteria(Cri_Employee.class);

		ProjectionList plist = Projections.projectionList();
          
		plist.add(Projections.max("employeeSalary"));
		plist.add(Projections.min("employeeSalary"));
		plist.add(Projections.avg("employeeSalary"));
		plist.add(Projections.count("employeeSalary"));
		plist.add(Projections.sum("employeeSalary"));
		System.out.println("plist:::" + plist);

		cri.setProjection(plist);
		System.out.println("cri:::" + cri);

		List<Object> n = cri.list();
		System.out.println("list:::" + n);

		for (Object object : n) {
			// Cri_Employee c = (Cri_Employee) object;

			System.out.println("Max Salary is ..........." + object.toString());
		}
	}

	public void insertUsingCriteriaQuery() {
		Criteria criteria = session.createCriteria(Cri_Employee.class);

		Cri_Employee ce = new Cri_Employee();
		ce.setEmployeeName("mahesh1");
		ce.setEmployeeDept("hkf");
		ce.setEmployeeSalary(14000);

		criteria.add(Example.create(ce));

		System.out.println("Query is....." + criteria);

		List result = criteria.list();

		System.out.println(result);
	}

	public void OrUsingCriteriaExample() {
		Criteria criteria = session.createCriteria(Cri_Employee.class);

		Criterion cr = Restrictions.gt("employeeSalary", 12000);
		Criterion cr1 = Restrictions.like("employeeName", "%%%%sh");

		LogicalExpression orExr = Restrictions.or(cr, cr1);

		criteria.add(orExr);

		List<Cri_Employee> list = criteria.list();

		for (Cri_Employee c : list) {

			System.out.println("Employee Id is................."
					+ c.getEmployeeId());
			System.out.println("Employee Name is..................."
					+ c.getEmployeeName());
			System.out.println("Employee Dept is......................."
					+ c.getEmployeeDept());
			System.out.println("Employee Salsry  is ........................."
					+ c.getEmployeeSalary());

			System.out.println();

		}
	}

	public void AndUsingCriteriaExample() {
		Criteria criteria = session.createCriteria(Cri_Employee.class);

		Criterion cr = Restrictions.gt("employeeSalary", 10000);
		Criterion cr1 = Restrictions.like("employeeName", "%%%%sh");

		LogicalExpression orExr = Restrictions.and(cr, cr1);

		criteria.add(orExr);

		List<Cri_Employee> list = criteria.list();

		for (Cri_Employee c : list) {

			System.out.println("Employee Id is................."
					+ c.getEmployeeId());
			System.out.println("Employee Name is..................."
					+ c.getEmployeeName());
			System.out.println("Employee Dept is......................."
					+ c.getEmployeeDept());
			System.out.println("Employee Salsry  is ........................."
					+ c.getEmployeeSalary());

			System.out.println();

		}
	}

	public void DisjunctionUsingHibernateCriteria() {
		Criteria criteria = session.createCriteria(Cri_Employee.class);

		Criterion cr = Restrictions.gt("employeeSalary", 10000);
		Criterion cr1 = Restrictions.like("employeeName", "%%%%sh");

		Disjunction dis = Restrictions.disjunction();

		dis.add(cr);
		dis.add(cr1);

		criteria.add(dis);

		List<Cri_Employee> list = criteria.list();

		for (Cri_Employee c : list) {

			System.out.println("Employee Id is................."
					+ c.getEmployeeId());
			System.out.println("Employee Name is..................."
					+ c.getEmployeeName());
			System.out.println("Employee Dept is......................."
					+ c.getEmployeeDept());
			System.out.println("Employee Salsry  is ........................."
					+ c.getEmployeeSalary());

			System.out.println();

		}
	}

	public void SqlRestrictionsUsingCriteria() {
		Criteria criteria = session.createCriteria(Cri_Employee.class);

		criteria.add(Restrictions
				.sqlRestriction("select * from Cri_employee_table"));

		List<Cri_Employee> list = criteria.list();

		for (Cri_Employee c : list) {

			System.out.println("Employee Id is................."
					+ c.getEmployeeId());
			System.out.println("Employee Name is..................."
					+ c.getEmployeeName());
			System.out.println("Employee Dept is......................."
					+ c.getEmployeeDept());
			System.out.println("Employee Salsry  is ........................."
					+ c.getEmployeeSalary());

			System.out.println();

		}

	}

	public void Example() {
		Criteria crit = session.createCriteria(Player.class);
		Criteria addCrit = crit.createCriteria("Address");
		addCrit.add(Restrictions.gt("id", 2));
		List<Player> results = crit.list();

		for (Player p : results) {
			System.out.println("Player name is.................."
					+ p.getPlayerName());
		}

	}

	public void ThirdTable() {

		try {
			Customer cus = new Customer();
			cus.setCustomer_Name("Rakesh");
			cus.setCustomer_AccNo(123);
			cus.setCustomer_Ph(24245);

			Customer cus1 = new Customer();
			cus1.setCustomer_Name("sukesh");
			cus1.setCustomer_AccNo(345);
			cus1.setCustomer_Ph(27245);

			List<Customer> list = new ArrayList<Customer>();
			list.add(cus);
			list.add(cus1);

			Bank b = new Bank();
			b.setBank_Name("HDFC");
			b.setCustomers(list);

			Bank b1 = new Bank();
			b1.setBank_Name("SBI");
			b1.setCustomers(list);

			int id = (Integer) session.save(b);
			tx.commit();

			int id1 = (Integer) session.save(b1);

			tx.commit();

			if (id > 0) {
				System.out.println("Record is insert successfull......");
			} else {
				System.out.println("Record insert is fail......");
			}

			if (id1 > 0) {
				System.out.println("Record is insert *************");
			} else {
				System.out.println("record insert is fail ***********");
			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void insertJoinCriteria() {
		Uni_Student us = new Uni_Student();

		us.setStudent_Name("sukesh");
		us.setStudent_Address("Ap");
		us.setStudent_Ph(2345);

		Uni_Student us1 = new Uni_Student();

		us1.setStudent_Name("Rakesh");
		us1.setStudent_Address("Mp");
		us1.setStudent_Ph(3348);

		Uni_Student us2 = new Uni_Student();

		us2.setStudent_Name("Varun");
		us2.setStudent_Address("Ap");
		us2.setStudent_Ph(3455);

		Uni_Student us3 = new Uni_Student();

		us3.setStudent_Name("Venkey");
		us3.setStudent_Address("Ap");
		us3.setStudent_Ph(6535);

		List<Uni_Student> list = new ArrayList<Uni_Student>();
		list.add(us);
		list.add(us1);

		List<Uni_Student> list1 = new ArrayList<Uni_Student>();
		list1.add(us2);
		list1.add(us3);

		University u = new University();
		u.setUniversity_Name("JNTU_K");
		u.setStudents(list);

		University u1 = new University();

		u1.setUniversity_Name("JNTU_H");
		u1.setStudents(list1);

		try {
			int id = (Integer) session.save(u);
			tx.commit();
			if (id > 0) {
				System.out.println("Record insert SuccessFully.............");
			} else {
				System.out
						.println("Record insert is fail.....................");
			}

			int id1 = (Integer) session.save(u1);
			tx.commit();
			if (id1 > 0) {
				System.out.println("Record insert SuccessFully.............");
			} else {
				System.out
						.println("Record insert is fail.....................");
			}

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void getDataUsingCriteriaJoin() {

		Criteria cr = session.createCriteria(University.class);
		cr.setFetchMode("Uni_Student", FetchMode.JOIN);

		System.out.println(cr);

		List list = cr.list();

		for (Object object : list) {

			University u = (University) object;

			System.out.println("University Id is.............."
					+ u.getUniversity_ID());
			System.out.println("University name is...................."
					+ u.getUniversity_Name());

			List<Uni_Student> list1 = u.getStudents();

			for (Uni_Student us : list1) {

				System.out.println("Student ID is..........."
						+ us.getStudent_Id());
				System.out.println("Student Name is................"
						+ us.getStudent_Name());
				System.out.println("Student Address is..................."
						+ us.getStudent_Address());
				System.out
						.println("Student Ph No..............................."
								+ us.getStudent_Ph());
			}
		}
	}

	public void getDataUsingRestrictions() {
		Criteria cr = session.createCriteria(University.class, "u");
		cr.setFetchMode("Uni_Student", FetchMode.SELECT);
		cr.createAlias("u.students", "s");

		cr.add(Restrictions.eq("u.University_Fk", "s.student_Id"));

		List list = cr.list();

		for (Object object : list) {

			University un = (University) object;

			System.out.println("University Id is.............."
					+ un.getUniversity_ID());
			System.out.println("University name is...................."
					+ un.getUniversity_Name());

			List<Uni_Student> list1 = un.getStudents();

			for (Uni_Student us : list1) {

				System.out.println("Student ID is..........."
						+ us.getStudent_Id());
				System.out.println("Student Name is................"
						+ us.getStudent_Name());
				System.out.println("Student Address is..................."
						+ us.getStudent_Address());
				System.out
						.println("Student Ph No..............................."
								+ us.getStudent_Ph());
			}

		}

	}

	public void getDataUsingRestrictions1() {
		// Parent Class
		Criteria cr = session.createCriteria(University.class, "u");

		// Child Class
		cr.setFetchMode("Uni_Student", FetchMode.SELECT);
		// Child Class Alias
		cr.createAlias("u.students", "s");

		// condition for parent Class
		cr.add(Restrictions.eq("u.university_Name", "JNTU_H"));

		// Condition for Chaild Class
		cr.add(Restrictions.eq("s.student_Name", "Varun"));

		List list = cr.list();

		for (Object object : list) {

			University un = (University) object;

			System.out.println("University Id is.............."
					+ un.getUniversity_ID());
			System.out.println("University name is...................."
					+ un.getUniversity_Name());

			List<Uni_Student> list1 = un.getStudents();

			for (Uni_Student us : list1) {

				System.out.println("Student ID is..........."
						+ us.getStudent_Id());
				System.out.println("Student Name is................"
						+ us.getStudent_Name());
				System.out.println("Student Address is..................."
						+ us.getStudent_Address());
				System.out
						.println("Student Ph No..............................."
								+ us.getStudent_Ph());
			}

		}
	}

	public void getDataUsingRestrictionsConditions() {
		
		System.out.println("Inside Method...........");
		
		Criteria cr = session.createCriteria(University.class);
		cr.add(Restrictions.eq("university_Name", "JNTU_H"));
		Criteria cr1=cr.createCriteria("students");
		cr1.add(Restrictions.eq("student_Id",3));

		 System.out.println("Before Criteria query...........");
		List<University> list = cr1.list();

	
		System.out.println("List Data is.........."+list.toString());
		
		for (University u : list) {
			
			System.out.println("University Id is........"+u.getUniversity_ID());
			
			System.out.println("University Name is.............."+u.getUniversity_Name());
			
			List<Uni_Student> list1=u.getStudents();
			
			for (Uni_Student un : list1) {
				
				System.out.println("Student  Name is"+un.getStudent_Name());
			}
			
		}
		
	}
	
	public void CustomDefinedGenerator()
	{
		try
		{
			Book b=new Book();
			     b.setBookName("Java");
			     b.setBookPrice(300);
			     tx.commit();
			   int id =(Integer) session.save(b);
			   
			    if(id>0)
			    {
			    	System.out.println("Record is insert...........!");
			    }else
			    {
			    	System.out.println("Record insert fail.........!");
			    }
			    
		}catch(HibernateException e)
		{  tx.rollback();
			e.printStackTrace();
		}
	}
}
