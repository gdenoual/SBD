import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LaunchMe {

	private int cardinality;
	private int parameter;
	private int max;
	private int min;

	public LaunchMe(int cardinality, int parameter, int max, int min) {
		this.cardinality = cardinality;
		this.parameter = parameter;
		this.max = max;
		this.min = min;
	}

	public int getCardinality() {
		return cardinality;
	}

	public void setCardinality(int cardinality) {
		this.cardinality = cardinality;
	}

	public int getParameter() {
		return parameter;
	}

	public void setParameter(int parameter) {
		this.parameter = parameter;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	// public static String[] tri(String[] tab){
	//
	// String[] newTAb = new String[tab.length];
	//
	// newTAb[1] = "Age , Salaire";
	//
	//
	// for(int i=1; i<tab.length-1; i++){
	//
	//
	// String Acomparer = newTAb[i];
	// String Acomparer2 = newTAb[i+1];
	// String serapareteur =",";
	// int ok= 0;
	// int j=0;
	// while(serapareteur != ","){
	//
	//
	// ok = (int)Acomparer.charAt(j);
	// j++;
	//
	// }
	//
	// int ok2= 0;
	// while(serapareteur != ","){
	//
	//
	// ok2 = (int)Acomparer2.charAt(i);
	// i++;
	//
	// }
	//
	//
	// if(ok < ok2){
	//
	// newTAb[i] = tab[i];
	//
	// }
	// else {
	// newTAb[i] = tab[i+1];
	// }
	//
	// }
	//
	//
	// for(int p =0 ; p < newTAb.length; p++){
	// System.out.println("ok" +newTAb[p]);
	// }
	//
	// return newTAb;
	// }

	private static HashMap sortByValues(Map<Integer, Integer> hashmap) {
		List list = new LinkedList(hashmap.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

	private static HashMap sortByKeys(Map<Integer, Integer> hashmap) {
		List list = new LinkedList(hashmap.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getKey()).compareTo(((Map.Entry) (o2)).getKey());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
	
	public static HashMap mondrian(Map<Integer, Integer> hashmap,int k){
		// dimension à choisir (Age,Salire)
		// mediane
		
		return mondrianHashmap;
		
	}

	public static void main(String[] args) throws IOException {

		LaunchMe lm = new LaunchMe(1000, 2, 80, 16);

		int[] age = new int[lm.getCardinality()];

		for (int i = 0; i < lm.getCardinality(); i++) {

			age[i] = (int) (Math.random() * (lm.getMax() - lm.getMin()));

		}
		for (int i = 0; i < lm.getCardinality(); i++) {
			// System.out.println(age[i]);
		}

		LaunchMe lm2 = new LaunchMe(1000, 2, 10000, 1100);
		int[] salaire = new int[lm2.getCardinality()];

		for (int i = 0; i < lm2.getCardinality(); i++) {
			salaire[i] = (int) (Math.random() * (lm2.getMax() - lm2.getMin()));
		}

		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> sortedHashmapSalary = new HashMap<Integer, Integer>();
		Map<Integer, Integer> sortedHashmapAge = new HashMap<Integer, Integer>();
		Map<Integer, Integer> hashmapAge = new HashMap<Integer, Integer>();

		String[] donnees = new String[lm.getCardinality()];
		donnees[0] = "Age , Salaire";
		for (int i = 1; i < lm.getCardinality(); i++) {
			donnees[i] = (String) (age[i] + " , " + salaire[i]);
			hashmap.put(age[i], salaire[i]);
		}

		sortedHashmapSalary = sortByValues(hashmap);
		sortedHashmapAge = sortByKeys(hashmap);

		/*
		 * BufferedWriter bw = new BufferedWriter( new FileWriter( new File (
		 * "./myData3.csv" ),false) ); for(int k =0 ; k < lm.getCardinality();
		 * k++){ bw.append ( donnees[k] + "\n"); } bw.flush(); bw.close();
		 */

		System.out.println("Before Sorting Salary:");
		Set set = hashmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println("After Sorting Salary:");
		Set set2 = sortedHashmapSalary.entrySet();
		Iterator iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry me2 = (Map.Entry) iterator2.next();
			System.out.print(me2.getKey() + ": ");
			System.out.println(me2.getValue());
		}

		System.out.println("Before Sorting Age:");
		Set set5 = hashmap.entrySet();
		Iterator iterator3 = set5.iterator();
		while (iterator.hasNext()) {
			Map.Entry me3 = (Map.Entry) iterator.next();
			System.out.print(me3.getKey() + ": ");
			System.out.println(me3.getValue());
		}
		System.out.println("After Sorting Age:");
		Set set6 = sortedHashmapAge.entrySet();
		Iterator iterator4 = set6.iterator();
		while (iterator4.hasNext()) {
			Map.Entry me4 = (Map.Entry) iterator4.next();
			System.out.print(me4.getKey() + ": ");
			System.out.println(me4.getValue());
		}
	}

}
