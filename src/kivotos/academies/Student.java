package kivotos.academies;

import mindustry.type.UnitType;

public class Student extends UnitType {
    public float healthLevelMultiplier, armorLevelMultiplier, exSkillLevelMultiplier, attackLevelMultiplier = 1.0f;
    protected int exSkillLevelLimit = 5;
    public int exSkillLevel = 1;
    public int level = 1;
    protected int exp = 0;
    public Student(String name) {
        super(name);
    }

    public void LevelUp(){
        level++;
        healthLevelMultiplier *= level;
        armorLevelMultiplier *= level;
        attackLevelMultiplier *= level;
    }
    public void ExSkillUpgraded(){
        if(exSkillLevel >= exSkillLevelLimit){return;}
        exSkillLevel++;
        exSkillLevelMultiplier *= exSkillLevel;
    }
}
