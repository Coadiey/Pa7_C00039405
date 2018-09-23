package pa7_c00039405;

import java.util.ArrayList;

public class CrimeClass implements Cloneable {

    private String line;
    private ArrayList<CrimeClass> list = new ArrayList();

    public CrimeClass(String line) {
        this.line = line;
    }

    public int getYear() {
        String[] strArray = line.trim().split(" ");
        int year = Integer.parseInt(strArray[0]);
        return year;
    }

    public String getState() {
        String[] strArray = line.trim().split(" ");
        String state = strArray[1];
        return state;
    }

    public int getCampusType() {
        String[] strArray = line.trim().split(" ");
        int campusType = Integer.parseInt(strArray[2]);
        return campusType;
    }

    public int getMales() {
        String[] strArray = line.trim().split(" ");
        int males = Integer.parseInt(strArray[3]);
        return males;
    }

    public int getFemales() {
        String[] strArray = line.trim().split(" ");
        int females = Integer.parseInt(strArray[4]);
        return females;
    }

    public int getMurders() {
        String[] strArray = line.trim().split(" ");
        int murders = Integer.parseInt(strArray[5]);
        if (murders < 0) {
            return 0;
        }
        return murders;
    }

    public int getHomicides() {
        String[] strArray = line.trim().split(" ");
        int homicides = Integer.parseInt(strArray[6]);
        if (homicides < 0) {
            return 0;
        }
        return homicides;
    }

    public int getRapes() {
        String[] strArray = line.trim().split(" ");
        int rapes = Integer.parseInt(strArray[7]);
        if (rapes < 0) {
            return 0;
        }
        return rapes;
    }

    public int getAssaults() {
        String[] strArray = line.trim().split(" ");
        int assaults = Integer.parseInt(strArray[8]);
        if (assaults < 0) {
            return 0;
        }
        return assaults;
    }

    public int totalStudents() {
        return getMales() + getFemales();
    }

    public int totalCrimes() {
        return getMurders() + getHomicides() + getRapes() + getAssaults();
    }

    @Override //advanced copy
    public CrimeClass clone() {
        try {
            CrimeClass cc = (CrimeClass) super.clone();
            cc.list = new ArrayList();
            for (CrimeClass c : list) {
                cc.list.add(c.clone());
            }
            return cc;
        } catch (Exception e) {
            return null;
        }
    }

}
