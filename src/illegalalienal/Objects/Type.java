package illegalalienal.Objects;

import illegalalienal.Constants;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;

import static illegalalienal.Constants.*;


public class Type {
    private int id = -1;
    private ArrayList<Integer> effectiveAgainst = new ArrayList<>(), notEffectiveAgainst = new ArrayList<>(),
            resistantTo = new ArrayList<>(), weakTo = new ArrayList<>(), cantHit = new ArrayList<>(),
            immuneTo = new ArrayList<>();

    public Type(int id) throws Exception
    {
        this.id = id;
        Constants.init();
        initEfficacy();
    }

    public Type(String name) throws Exception
    {
        Constants.init();
        for(int i = 0; i < typeRecords.size(); i++) {
            String typeName = typeRecords.get(i).get(1);
            if (typeName.equals(name)) {
                id = Integer.parseInt(typeRecords.get(i).get(0));
                break;
            }
        }

        initEfficacy();
    }

    @Override
    public String toString()
    {
        try {
            return typeRecords.get(id-1).get(1);
        }catch (Exception ignored){}
        return "Invalid Type!";
    }

    public ArrayList<String> getWeakTo()
    {
        ArrayList<String> weakToString = new ArrayList<>();

        for(Integer id: weakTo)
            weakToString.add(typeRecords.get(id-1).get(1));

        return weakToString;
    }

    public ArrayList<String> getResistantTo()
    {
        ArrayList<String> resistantToString = new ArrayList<>();

        for(Integer id: resistantTo)
            resistantToString.add(typeRecords.get(id-1).get(1));

        return resistantToString;
    }

    public ArrayList<String> getImmuneTo()
    {
        ArrayList<String> immuneToString = new ArrayList<>();

        for(Integer id: immuneTo)
            immuneToString.add(typeRecords.get(id-1).get(1));

        return immuneToString;
    }

    public ArrayList<String> getEffectiveAgainst()
    {
        ArrayList<String> effectiveAgainstString = new ArrayList<>();

        for(Integer id: effectiveAgainst)
            effectiveAgainstString.add(typeRecords.get(id-1).get(1));

        return effectiveAgainstString;
    }

    public ArrayList<String> getNotEffectiveAgainst()
    {
        ArrayList<String> notEffectiveAgainstString = new ArrayList<>();

        for(Integer id: notEffectiveAgainst)
            notEffectiveAgainstString.add(typeRecords.get(id-1).get(1));

        return notEffectiveAgainstString;
    }

    public ArrayList<String> getCantHit()
    {
        ArrayList<String> cantHitString = new ArrayList<>();

        for(Integer id: cantHit)
            cantHitString.add(typeRecords.get(id-1).get(1));

        return cantHitString;
    }

    private void initEfficacy()
    {
        for(int i = 0; i < typeEfficacyRecords.size(); i++)
        {
            CSVRecord currRecord = typeEfficacyRecords.get(i);

            if(Integer.parseInt(currRecord.get(1)) == id && Integer.parseInt(currRecord.get(2)) != 100)
            {
                if(Integer.parseInt(currRecord.get(2)) == 200)
                    weakTo.add(Integer.parseInt(currRecord.get(0)));
                else if(Integer.parseInt(currRecord.get(2)) == 50)
                    resistantTo.add(Integer.parseInt(currRecord.get(0)));
                else if(Integer.parseInt(currRecord.get(2)) == 0)
                    immuneTo.add(Integer.parseInt(currRecord.get(0)));
            }

            if(Integer.parseInt(currRecord.get(0)) == id && Integer.parseInt(currRecord.get(2)) != 100)
            {
                if(Integer.parseInt(currRecord.get(2)) == 200)
                    effectiveAgainst.add(Integer.parseInt(currRecord.get(1)));
                else if(Integer.parseInt(currRecord.get(2)) == 50)
                    notEffectiveAgainst.add(Integer.parseInt(currRecord.get(1)));
                else if(Integer.parseInt(currRecord.get(2)) == 0)
                    cantHit.add(Integer.parseInt(currRecord.get(1)));
            }
        }
    }
}
