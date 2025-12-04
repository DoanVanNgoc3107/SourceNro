package dragon.t;

/**
 *
 * @author Admin
 */
public class NpcTemplate {
    
    public byte npcTemplateId;
    public String name;
    public short headId;
    public short bodyId;
    public short legId;
    public String[][] menu;
    
    
    public boolean isNpcDua() {
        return this.npcTemplateId == 50 || this.npcTemplateId == 51;
    }
}
