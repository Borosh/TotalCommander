package navigacio;

import java.nio.file.*;

public class Navigacio {
	static void lefele(int helyzet, int hossz) {
		if(helyzet + 1 < hossz) {
    		helyzet++;
    	}
    	else {
    		helyzet = 0;
    	}
    }
    
    static void felfele(int helyzet, int hossz) {
    	if(helyzet - 1 >= 0) {
    		helyzet--;
    	}
    	else {
    		helyzet = hossz-1;
    	}
    }
    
    static void visszalep(String utvonal) {
    	//Path subpath(0, getNameCount()-1);
    }
}