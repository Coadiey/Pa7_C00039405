// Your Name: Coadiey Bryan
// Your ID: C00039405
// CMPS 260
// Programming Assignment : #7
// Due Date : 4/28/18 
// Program Description: sorts through text file and filters for the data the user wants. Uses increasingly smaller arrays to filter down the information.
// Certificate of Authenticity:
// I certify that the code in the method function main of this project is entirely my own
// work.
package pa7_c00039405;

import java.io.File;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;

public class Pa7_C00039405 {

    public static void main(String[] args) {
        ArrayList<CrimeClass> crimeArray = new ArrayList();

        String filename = "oncampuscrime.txt";
        File file = new File(filename);
        try (Scanner filereader = new Scanner(file);) {
            while (filereader.hasNextLine()) {
                String line = filereader.nextLine();
                crimeArray.add(new CrimeClass(line));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Total or Percent: ");
        int summaryType;
        if (input.nextLine().equalsIgnoreCase("percent")) {
            summaryType = 1;
        } else {
            summaryType = 0;
        }
        System.out.println();
        System.out.println("Enter Crime Type (Murder, NegHomicide, Rape, AgAssault, All): ");
        String crimeSelection = input.next();
        System.out.println();
        int crimeType = 0;
        if (crimeSelection.equalsIgnoreCase("murder")) {
            crimeType = 1;
        } else if (crimeSelection.equalsIgnoreCase("neghomicide")) {
            crimeType = 2;
        } else if (crimeSelection.equalsIgnoreCase("rape")) {
            crimeType = 3;
        } else if (crimeSelection.equalsIgnoreCase("agassault")) {
            crimeType = 4;
        } else {
            crimeType = 0;
        }
        System.out.println("Enter Year (20l4, 2015, 2016, All): ");
        String yearSelection = input.next();
        System.out.println();
        int yearType = 0;
        if (yearSelection.equalsIgnoreCase("2014")) {
            yearType = 1;
        } else if (yearSelection.equalsIgnoreCase("2015")) {
            yearType = 2;
        } else if (yearSelection.equalsIgnoreCase("2016")) {
            yearType = 3;
        } else {
            yearType = 0;
        }
        System.out.println("0-All,  1-Pub4yr,  2-PriNoProf,  3-PriProf4yr,  4-Pub2yr, \n"
                + "5-PriNoProf2yr,  6-PriPro2yr,  7-Pub<2yr,  8-PriNoPro<2yr,  9-PriProf \n"
                + "Enter Campus Type Number:  ");
        int campusSelection = input.nextInt();
        int campusType = campusSelection;
        System.out.println();
        System.out.println("AL AK AZ AR CA CO CT DE FL GA \n"
                + "HI ID IL IN IA KS KY LA ME MD \n"
                + "MA MI MN MS MO MT NE NV NH NJ \n"
                + "NM NY NC ND OH OK OR PA RI SC \n"
                + "SD TN TX UT VT VA WA WV WI WY \n"
                + "Enter State Abbreviation or All: ");
        String stateSelection = input.next();
        System.out.println();
        ArrayList<CrimeClass> crimeArray2 = new ArrayList();
        if (stateSelection.equalsIgnoreCase("all")) {
            for (CrimeClass c : crimeArray) {
                crimeArray2.add(c.clone());
            }
        } else {
            int i;
            for (i = 0; i < crimeArray.size(); i++) {
                if ((crimeArray.get(i).getState()).equalsIgnoreCase(stateSelection)) {
                    crimeArray2.add(crimeArray.get(i));
                }
            }
        }
        ArrayList<CrimeClass> crimeArray3 = new ArrayList();
        if (campusType == 0) {
            for (CrimeClass c : crimeArray2) {
                crimeArray3.add(c.clone());
            }
        } else {
            int i;
            for (i = 0; i < crimeArray2.size(); i++) {
                if ((crimeArray2.get(i).getCampusType()) == campusType) {
                    crimeArray3.add(crimeArray2.get(i));
                }
            }
        }
        ArrayList<CrimeClass> crimeArray4 = new ArrayList();
        int totalMales = 0;
        int totalFemales = 0;
        int totalCrime = 0;
        if (crimeType == 0) {
            for (CrimeClass c : crimeArray3) {
                crimeArray4.add(c.clone());
            }
        } else {
            int i;
            for (CrimeClass c : crimeArray3) {
                if (crimeType == 1) {
                    if (c.getMurders() > 0) {
                        crimeArray4.add(c);
                        totalCrime += (c.getMurders());
                    }
                } else if (crimeType == 2) {
                    if (c.getHomicides() > 0) {
                        crimeArray4.add(c);
                        totalCrime += (c.getHomicides());
                    }
                } else if (crimeType == 3) {
                    if (c.getRapes() > 0) {
                        crimeArray4.add(c);
                        totalCrime += (c.getRapes());
                    }
                } else if (crimeType == 4) {
                    if (c.getAssaults() > 0) {
                        crimeArray4.add(c);
                        totalCrime += (c.getAssaults());
                    }
                }
            }

        }
        int totalStudents = 0;
        for (CrimeClass c : crimeArray4) {
            totalMales += c.getMales();
            totalFemales += c.getFemales();
            if (crimeType == 0) {
                totalCrime += c.totalCrimes();
            }
            if (summaryType == 1) {
                totalStudents += c.totalStudents();
            }
        }
        System.out.println("Male students: " + totalMales);
        System.out.println("Female Students: " + totalFemales);
        if (summaryType == 0) {
            if (crimeType == 0) {
                System.out.println("Total all crime: " + totalCrime);
            } else if (crimeType == 1) {
                System.out.println("Total murders: " + totalCrime);
            } else if (crimeType == 2) {
                System.out.println("Total negligent homicides: " + totalCrime);
            } else if (crimeType == 3) {
                System.out.println("Total rapes: " + totalCrime);
            } else if (crimeType == 4) {
                System.out.println("Total aggravated assaults: " + totalCrime);
            }
        } else {
            int percentCrime;
            int percentStudents;
            if (totalCrime != 0 && totalStudents != 0) {
                percentStudents = totalStudents / totalCrime;
                percentCrime = 1;
            } else if (totalCrime == 0 && totalStudents != 0) {
                percentStudents = totalStudents;
                percentCrime = 0;
            } else {
                percentCrime = 0;
                percentStudents = 0;
            }
            if (crimeType == 0) {
                System.out.printf("%d crime for every %d students ", percentCrime, percentStudents);
            } else if (crimeType == 1) {
                System.out.printf("%d murder for every %d students ", percentCrime, percentStudents);
            } else if (crimeType == 2) {
                System.out.printf("%d negligent homicide for every %d students ", percentCrime, percentStudents);
            } else if (crimeType == 3) {
                System.out.printf("%d rape for every %d students ", percentCrime, percentStudents);
            } else if (crimeType == 4) {
                System.out.printf("%d aggravated assault for every %d students ", percentCrime, percentStudents);
            }
        }

    }

}
