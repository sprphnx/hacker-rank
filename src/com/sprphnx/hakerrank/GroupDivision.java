package com.sprphnx.hakerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupDivision {

	public static void main(String[] args) {
		Integer level[] = {1,4,7,3,4};
		System.out.println("Number of classes required: "+getNumberOfClassesRequired(5, level, 2));
		
	}
	
	public static int getNumberOfClassesRequired(int numberOfStudents, Integer level[], int maxSpread) {
		List<Integer> levelArray = Arrays.asList(level).stream().sorted().collect(Collectors.toList());
		
		int counter = 0;
		
		List<List<Integer>> classes = new ArrayList<>();
		
		List<Integer> studentsRanksInGroup = new ArrayList<>(); 
		int maxLevelInGroup = maxSpread;
		
		while(counter <= numberOfStudents-1) {
			
			if(studentsRanksInGroup.isEmpty() && levelArray.get(counter)<=maxLevelInGroup) {
				studentsRanksInGroup.add(levelArray.get(counter));
				maxLevelInGroup = levelArray.get(counter)+maxSpread;
				counter++;
				continue;
			} 
			
			if(levelArray.get(counter)<=maxLevelInGroup) {
				studentsRanksInGroup.add(levelArray.get(counter));
				counter++;
				continue;
			}
			
			if(levelArray.get(counter)>maxLevelInGroup) {
				classes.add(studentsRanksInGroup);
				studentsRanksInGroup = new ArrayList<>();
				studentsRanksInGroup.add(levelArray.get(counter));
				maxLevelInGroup = levelArray.get(counter)+maxSpread;
				counter++;
				continue;
			}
			
			counter++;
		}
		classes.add(studentsRanksInGroup);
		
		System.out.println("Classes: "+classes);
		
		return classes.size();
		
	}
}
