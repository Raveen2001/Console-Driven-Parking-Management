package com.raveen.parkingManagement;

import java.util.*;

public class Data {
	static Map<Integer, String> admin = new HashMap<>();
	static Map<Integer, String> worker = new HashMap<>();
	static int[][] spaceForPark;
	static int floors;
	static float amount;
	static Map<String, int[]> preCus = new HashMap<>();
	static Map<String, Date[]> checkInData = new HashMap<>();
	static Map<String, int[]> slotsData = new HashMap<>();
	static List<String> parkingIds = new ArrayList<>();
	static List<ReportData> report = new ArrayList<>();
	static float totalAmount = 0;
}

