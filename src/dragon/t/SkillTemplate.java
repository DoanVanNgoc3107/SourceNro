package dragon.t;

/**
 *
 * @author Admin
 */
public class SkillTemplate {
    
    public boolean isBuffToPlayer() {
        return this.type == 2;
    }
    
    public boolean isUseAlone() {
        return this.type == 3;
    }
    
    public boolean isAttackSkill() {
        return this.type == 1;
    }
    
    public byte id;
    public String name;
    public int maxPoint;
    public int manaUseType;
    public int type;
    public int iconId;
    public String description;
    public Skill[] skills;
    public String damInfo;
    
    public Skill getSkill(int point) {
        int i;
        for (i = 0; i < this.skills.length; i++) {
            if (this.skills[i].point == point) {
                return this.skills[i];
            }
        }
        return null;
    }
    
    
}
