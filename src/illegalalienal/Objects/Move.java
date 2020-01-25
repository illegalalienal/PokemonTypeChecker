package illegalalienal.Objects;


import illegalalienal.Constants;
import org.apache.commons.csv.CSVRecord;

import static illegalalienal.Constants.*;


public class Move {
    int id = -1, generationID = -1, typeID = -1, power = -1, pp = -1, priority = -1, targetID = -1,
    damageClassID = -1, effectID = -1, effectChance = -1, contestTypeID = -1, contestEffectID = -1,
    superContestEffectID = -1, index = -1;
    String identifier = null;

    /*
        ID:                 Identification Number
        Generation ID:      Generation Identifier
        Type ID:            Type Identifier
        Power:              Move Power
        PP:                 Power Points
        Priority:           Moves' Priority in Battle
        Target ID:          What Pokemon The Move Will Attack
        Damage Class ID:    Status, Physical or Special
        Effect ID:          Effect Identifier
        Effect Chance:      Chance of Effect Occuring
     */

    public Move(int id) throws Exception
    {
        Constants.init();

        for(int i = 0; i < moveRecords.size(); i++) {
            if (Integer.parseInt(moveRecords.get(i).get("id")) == id) {
                this.id = Integer.parseInt(moveRecords.get(i).get("id"));
                index = i;
                break;
            }
        }

        if(id != -1)
        {
            generationID = Integer.parseInt(moveRecords.get(index).get("generation_id"));
            typeID = Integer.parseInt(moveRecords.get(index).get("type_id"));
            pp = Integer.parseInt(moveRecords.get(index).get("pp"));
            priority = Integer.parseInt(moveRecords.get(index).get("priority"));
            targetID = Integer.parseInt(moveRecords.get(index).get("target_id"));
            damageClassID = Integer.parseInt(moveRecords.get(index).get("damage_class_id"));
            effectID = Integer.parseInt(moveRecords.get(index).get("effect_id"));
            identifier = moveRecords.get(index).get("identifier");

            try
            {
                power = Integer.parseInt(moveRecords.get(index).get("power"));
                effectChance = Integer.parseInt(moveRecords.get(index).get("effect_chance"));
                contestTypeID = Integer.parseInt(moveRecords.get(index).get("contest_type_id"));
                contestEffectID = Integer.parseInt(moveRecords.get(index).get("contest_effect_id"));
                superContestEffectID = Integer.parseInt(moveRecords.get(index).get("super_contest_effect_id"));

            }catch(NumberFormatException ignored){}
        }
    }

    public Move(String identifier) throws Exception
    {
        Constants.init();

        for(int i = 0; i < moveRecords.size(); i++)
        {
            if(identifierEquals(moveRecords.get(i).get("identifier"), identifier))
            {
                //this.identifier = moveRecords.get(i).get("identifier");
                this.id = Integer.parseInt(moveRecords.get(i).get("id"));
                index = i;
                break;
            }
        }

        if(id != -1)
        {
            generationID = Integer.parseInt(moveRecords.get(index).get("generation_id"));
            typeID = Integer.parseInt(moveRecords.get(index).get("type_id"));
            priority = Integer.parseInt(moveRecords.get(index).get("priority"));
            targetID = Integer.parseInt(moveRecords.get(index).get("target_id"));
            damageClassID = Integer.parseInt(moveRecords.get(index).get("damage_class_id"));
            effectID = Integer.parseInt(moveRecords.get(index).get("effect_id"));
            this.identifier = moveRecords.get(index).get("identifier");

            try
            {
                pp = Integer.parseInt(moveRecords.get(index).get("pp"));
                power = Integer.parseInt(moveRecords.get(index).get("power"));
                effectChance = Integer.parseInt(moveRecords.get(index).get("effect_chance"));
                contestTypeID = Integer.parseInt(moveRecords.get(index).get("contest_type_id"));
                contestEffectID = Integer.parseInt(moveRecords.get(index).get("contest_effect_id"));
                superContestEffectID = Integer.parseInt(moveRecords.get(index).get("super_contest_effect_id"));

            }catch(NumberFormatException ignored){}
        }



    }

    @Override
    public String toString()
    {
        return identifier;
    }

    private boolean identifierEquals(String a, String b) //a is the identifier, b is the user string
    {
        String bFixed = "", aFixed;

        aFixed = a.replace("-", "");

        for(int i = 0; i < b.length(); i++)
        {
            if((b.charAt(i) + "").matches("[a-zA-Z0-9]+"))
            {
                bFixed += (b.charAt(i) + "");
            }

        }

        return bFixed.equals(aFixed);
    }

}
