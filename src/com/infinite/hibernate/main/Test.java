package com.infinite.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infinite.hibernate.pojo.Address;
import com.infinite.hibernate.pojo.Bord;
import com.infinite.hibernate.pojo.Player;
import com.infinite.hibernate.pojo.Team;
import com.infinite.hibernate.utill.HibernateUtill;

public class Test {
	public static void main(String[] args) {

		TeamDao dao = new TeamDaoImpl();

		 dao.insert();

		// dao.getData();

		// dao.getjoinqueryData();

		// dao.loadmethodGETdata();

		 //dao.deleteTeamById();

		// dao.deleteBordRecord();

		// dao.deleteTeamToPlayer();

		// dao.UpdateBordRecord();

		// dao.updateToPlayer();

		// dao.addPlayerToTeam();

		// dao.cacheExample();

		// dao.oneTOmanyBidirection();

		// dao.ComponentExample();

		// dao.getDataComponentExample();

		// dao.getDataSpecificeComponentExample();

		// dao.TablePerClassHierarchyExample();

		// dao.TableForSubClassHierarchyExample();

		// dao.TablePerConcreteClassHierarchyExample();

		// dao.getDateTablePerClassHierarchyExample();

		// dao.getDataSubClasClassHierarchyExample1();

		// dao.TestPersonInsert();

		// dao.getDataPerson();

		// dao.testUpdatePerson();

		// dao.HibernateVersoning();

		// dao.getProductData();

		// dao.productUpdate();

		// dao.UserTimerStamp();

		// dao.UserUpdateTimerstamp();

		// dao.InserForMerge();

		// dao.MergeExample();

		// dao.oneToonePrimaryKeyMappingExample();

		//dao.insertCri_Employee();

		// dao.getCritariaData();

		// dao.CriteriaMultipleData();

		// dao.UniqueCriteriaExample();

		 //dao.pagenationCriteria();

		// dao.DesUsingCriteria();

		// dao.AscUsingCriteria();

		// dao.RowCountUsingCriteria();

		 //dao.SelectAllNameusing();

		 dao.Max_Min_ValueUsingCriteria();

		 //dao.insertUsingCriteriaQuery();

		// dao.OrUsingCriteriaExample();

		// dao.AndUsingCriteriaExample();

		// dao.DisjunctionUsingHibernateCriteria();

		// dao.SqlRestrictionsUsingCriteria();

		// dao.Example();

		// dao.ThirdTable();

		// dao.insertJoinCriteria();
		
		//dao.getDataUsingCriteriaJoin();
		
		//dao.getDataUsingRestrictions();
		
		//dao.getDataUsingRestrictionsConditions();
		
		//dao.CustomDefinedGenerator();
		
	}
}
