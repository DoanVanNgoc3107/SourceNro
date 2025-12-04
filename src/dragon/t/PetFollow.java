package dragon.t;

/**
 *
 * @author TGDD
 */
public class PetFollow {
    
    public short smallID;
    public int fimg = -1;
    public int wimg;
    public int himg;
    public int[] frame = new int[]
    {
        0,
        1,
        2,
        1
    };
    
    public int time;
    
    public PetFollow(int smallID, int fimg, int[] frameNew, int wimg, int himg, int second) {
        this.smallID = (short) smallID;
        if (fimg > 0) {
            this.fimg = fimg;
            this.frame = frameNew;
            this.himg = himg;
            this.wimg = wimg;
        } else {
            this.himg = 32;
            this.wimg = 32;
        }
        this.time = 1000 * second;
    }
    
}
