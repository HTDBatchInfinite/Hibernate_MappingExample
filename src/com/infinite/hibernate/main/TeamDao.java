package com.infinite.hibernate.main;

import com.infinite.hibernate.pojo.Team;

public interface TeamDao {
	public void insert();

	public void getData();

	public void getjoinqueryData();

	public void loadmethodGETdata();

	public void deleteTeamById();

	public void deleteBordRecord();

	public void deleteTeamToPlayer();

	public void UpdateBordRecord();

	public void updateToPlayer();

	public void addPlayerToTeam();

	public void cacheExample();

	public void oneTOmanyBidirection();

	public void ComponentExample();

	public void getDataComponentExample();

	public void getDataSpecificeComponentExample();

	public void TablePerClassHierarchyExample();

	public void TableForSubClassHierarchyExample();

	public void TablePerConcreteClassHierarchyExample();

	public void getDateTablePerClassHierarchyExample();

	public void getDataSubClasClassHierarchyExample1();

	public void TestPersonInsert();

	public void getDataPerson();

	public void testUpdatePerson();

	public void HibernateVersoning();

	public void getProductData();

	public void productUpdate();

	public void UserTimerStamp();

	public void getDataTimerStamp();

	public void UserUpdateTimerstamp();
	
	public void InserForMerge();
	
	public void MergeExample();

	public void oneToonePrimaryKeyMappingExample();
	
	public void insertCri_Employee();
	
	public void getCritariaData();
	
	 public void CriteriaMultipleData();
	 
	public void UniqueCriteriaExample();
	
	public void pagenationCriteria();
	
	public void DesUsingCriteria();
	
	public void AscUsingCriteria() ;
	
	public void RowCountUsingCriteria();
	
	public void SelectAllNameusing();
	
	public void Max_Min_ValueUsingCriteria();
	
	public void insertUsingCriteriaQuery();
	
	public void AndUsingCriteriaExample();
	
	public void OrUsingCriteriaExample();
	
	public void DisjunctionUsingHibernateCriteria();
	
	public void SqlRestrictionsUsingCriteria();
	
	public void Example();
	
	public void ThirdTable();
	
	public void insertJoinCriteria();
	
	public void getDataUsingCriteriaJoin();
	
	public void getDataUsingRestrictions();
	
	public void getDataUsingRestrictionsConditions();
	
	public void CustomDefinedGenerator();

}
