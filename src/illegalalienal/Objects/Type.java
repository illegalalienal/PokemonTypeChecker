package illegalalienal.Objects;

import illegalalienal.Constants;

import java.util.ArrayList;

import static illegalalienal.Constants.typeRecords;
import static illegalalienal.Constants.typesParser;


public class Type {
    private int id = -1;
    private ArrayList<Integer> effectiveAgainst = new ArrayList<>(), notEffectiveAgainst = new ArrayList<>(),
            resistantTo = new ArrayList<>(), weakTo = new ArrayList<>();
    public Type(int id) throws Exception
    {
        this.id = id;
        Constants.init();
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
    }

    @Override
    public String toString()
    {
        try {
            return typeRecords.get(id-1).get(1);
        }catch (Exception ignored){}
        return "Invalid Type!";
    }

    private void initEfficacy()
    {

    }
}
