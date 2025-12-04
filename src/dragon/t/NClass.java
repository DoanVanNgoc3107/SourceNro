package dragon.t;

/**
 *
 * @author Admin
 */
public class NClass {
    
    public int classId;
    public String name;
    public SkillTemplate[] skillTemplates;
    
    public SkillTemplate getTemplate(int id) {
        int i;
        for (i = 0; i < this.skillTemplates.length; i++) {
            if (this.skillTemplates[i].id == id) {
                return this.skillTemplates[i];
            }
        }
        return null;
    }
    
}
