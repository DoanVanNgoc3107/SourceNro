package dragon.t;

/**
 *
 * @author TGDD
 */
public class MapTask {
    
    public static boolean isNextMap(Char charz, int mapId) {
        switch (mapId) {
            // Trái đất
//            case 0:
//                return charz.ctaskId > 1 || (charz.ctaskId == 1 && charz.ctaskIndex >= 0);
//            case 1:
//                return charz.ctaskId > 2 || (charz.ctaskId == 2 && charz.ctaskIndex >= 0);
//            case 2: 
//                return charz.ctaskId > 6 || (charz.ctaskId == 6 && charz.ctaskIndex >= 0);
//            case 3: 
//                return charz.ctaskId > 7 || (charz.ctaskId == 7 && charz.ctaskIndex >= 0);
//            case 4: 
//                return charz.ctaskId > 8 || (charz.ctaskId == 8 && charz.ctaskIndex >= 0);
//            case 5: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
//            case 6: 
//                return charz.ctaskId > 16 || (charz.ctaskId == 16 && charz.ctaskIndex >= 0);
//            case 27: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
//            case 28: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
//            case 29: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
            case 30: 
                return charz.ctaskId > 15 || (charz.ctaskId == 15 && charz.ctaskIndex >= 0);
            case 47: 
                return charz.ctaskId > 8 || (charz.ctaskId == 8 && charz.ctaskIndex >= 3);
//            case 42:
//                return charz.ctaskId > 3 || (charz.ctaskId == 3 && charz.ctaskIndex >= 1);
            case 45: 
                return charz.ctaskId > 10 || (charz.ctaskId == 10 && charz.ctaskIndex >= 3);
            case 46: 
                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 2);
            case 111: 
                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
            //Namek   
//            case 7:
//                return charz.ctaskId > 1 || (charz.ctaskId == 1 && charz.ctaskIndex >= 0);
//            case 8:
//                return charz.ctaskId > 2 || (charz.ctaskId == 2 && charz.ctaskIndex >= 0);
//            case 9: 
//                return charz.ctaskId > 6 || (charz.ctaskId == 6 && charz.ctaskIndex >= 0);
//            case 11: 
//                return charz.ctaskId > 6 || (charz.ctaskId == 6 && charz.ctaskIndex >= 0);
//            case 12:
//                return charz.ctaskId > 8 || (charz.ctaskId == 8 && charz.ctaskIndex >= 0);
//            case 13: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
//            case 34: 
//                return charz.ctaskId > 14 || (charz.ctaskId == 14 && charz.ctaskIndex >= 0);
//            case 31: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
//            case 32: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
            case 33: 
                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
            case 10: 
                return charz.ctaskId > 15 || (charz.ctaskId == 15 && charz.ctaskIndex >= 0);    
//            case 43:
//                return charz.ctaskId > 3 || (charz.ctaskId == 3 && charz.ctaskIndex >= 1);
                
            // Xayda
//            case 14:
//                return charz.ctaskId > 1 || (charz.ctaskId == 1 && charz.ctaskIndex >= 0);
//            case 15:
//                return charz.ctaskId > 2 || (charz.ctaskId == 2 && charz.ctaskIndex >= 0);
//            case 16: 
//                return charz.ctaskId > 6 || (charz.ctaskId == 6 && charz.ctaskIndex >= 0);
//            case 17: 
//                return charz.ctaskId > 6 || (charz.ctaskId ==6 && charz.ctaskIndex >= 0);
//            case 20: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
//            case 19: 
//                return charz.ctaskId > 14 || (charz.ctaskId == 14 && charz.ctaskIndex >= 0);
//            case 18: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
//                
//            case 35: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
//            case 36: 
//                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
            case 37:
                return charz.ctaskId > 9 || (charz.ctaskId == 9 && charz.ctaskIndex >= 0);
            case 38: 
                return charz.ctaskId > 15 || (charz.ctaskId == 15 && charz.ctaskIndex >= 0);
            case 44:
                return charz.ctaskId > 3 || (charz.ctaskId == 3 && charz.ctaskIndex >= 1);
                
            //nappa
            case 63:
                return charz.ctaskId > 23 || (charz.ctaskId == 23 && charz.ctaskIndex >= 0);
            case 64:
                return charz.ctaskId > 23 || (charz.ctaskId == 23 && charz.ctaskIndex >= 0);
             case 65:
                return charz.ctaskId > 23 || (charz.ctaskId == 23 && charz.ctaskIndex >= 0);
            case 66:
                return charz.ctaskId > 23 || (charz.ctaskId == 23 && charz.ctaskIndex >= 0);
            case 67:
                return charz.ctaskId > 23 || (charz.ctaskId == 23 && charz.ctaskIndex >= 0);
            case 68:
                return charz.ctaskId > 22 || (charz.ctaskId == 22 && charz.ctaskIndex >= 0);
            case 69:
                return charz.ctaskId > 22 || (charz.ctaskId == 22 && charz.ctaskIndex >= 0);
             case 70:
                return charz.ctaskId > 22 || (charz.ctaskId == 22 && charz.ctaskIndex >= 0);
            case 71:
                return charz.ctaskId > 22 || (charz.ctaskId == 22 && charz.ctaskIndex >= 0);
            case 72:
                return charz.ctaskId > 22 || (charz.ctaskId == 22 && charz.ctaskIndex >= 0);
            case 73:
                return charz.ctaskId > 23 || (charz.ctaskId == 23 && charz.ctaskIndex >= 0);
            case 74:
                return charz.ctaskId > 23 || (charz.ctaskId == 23 && charz.ctaskIndex >= 0);
                
                 
            case 75:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 76:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 77:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 78:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 79:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 80:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 81:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 82:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 83:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            
             //tuong lai
            case 102:
                return charz.ctaskId > 25 || (charz.ctaskId == 25 && charz.ctaskIndex >= 0);
            case 103:
                return charz.ctaskId > 31 || (charz.ctaskId == 31 && charz.ctaskIndex >= 0);
            case 92:
                return charz.ctaskId > 25 || (charz.ctaskId == 25 && charz.ctaskIndex >= 0);
            case 93:
                return charz.ctaskId > 27 || (charz.ctaskId == 27 && charz.ctaskIndex >= 0);
            case 94:
                return charz.ctaskId > 27 || (charz.ctaskId == 27 && charz.ctaskIndex >= 0);
            case 95:
                return charz.ctaskId > 25 || (charz.ctaskId == 25 && charz.ctaskIndex >= 0);
            case 96:
                return charz.ctaskId > 27 || (charz.ctaskId == 27 && charz.ctaskIndex >= 0);
            case 97:
                return charz.ctaskId > 29 || (charz.ctaskId == 29 && charz.ctaskIndex >= 0);
            case 98:
                return charz.ctaskId > 29 || (charz.ctaskId == 29 && charz.ctaskIndex >= 0);
            case 99:
                return charz.ctaskId > 29 || (charz.ctaskId == 29 && charz.ctaskIndex >= 0);
            case 100:
                return charz.ctaskId > 30 || (charz.ctaskId == 30 && charz.ctaskIndex >= 0);
                
            //coler    
            case 105:
                return charz.ctaskId > 31 || (charz.ctaskId == 31 && charz.ctaskIndex >= 0);
            case 106:
                return charz.ctaskId > 31 || (charz.ctaskId == 31 && charz.ctaskIndex >= 0);
            case 107:
                return charz.ctaskId > 31 || (charz.ctaskId == 31 && charz.ctaskIndex >= 0);
            case 108:
                return charz.ctaskId > 31 || (charz.ctaskId == 31 && charz.ctaskIndex >= 0);
            case 109:
                return charz.ctaskId > 31 || (charz.ctaskId == 31 && charz.ctaskIndex >= 0);
            case 110:
                return charz.ctaskId > 31 || (charz.ctaskId == 31 && charz.ctaskIndex >= 0);
               
            case 155:
                return charz.ctaskId > 25 || (charz.ctaskId == 25 && charz.ctaskIndex >= 0);
            case 166:
                return charz.ctaskId > 25 || (charz.ctaskId == 25 && charz.ctaskIndex >= 0); 
                
            case 52:
                return charz.ctaskId > 11 || (charz.ctaskId == 11 && charz.ctaskIndex >= 0);
            case 160:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 161:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 162:
                return charz.ctaskId > 24 || (charz.ctaskId == 24 && charz.ctaskIndex >= 0);
            case 163:
                return charz.ctaskId > 34 || (charz.ctaskId == 34 && charz.ctaskIndex >= 0);    
        }
        return true;
    }
    
    
}
