package 오목;

public class mokcontroll {
	boolean turn=true; //
	int blackarray[][]=new int[19][19]; //
	int whitearray[][]=new int[19][19]; //
	
	int addarray(int x,int y) {
		if(turn) {
			blackarray[x][y]=1;
			int z=checkWinner(turn,x,y);
			return z;
			
		}
		else {
			
			whitearray[x][y]=1;
			int z=checkWinner(turn,x,y);
			return z;
		}	
	}

	int checkWinner(boolean turn,int x,int y) {
		
		int array[][];
		if(turn) {
			array=blackarray;			
		}
		else {
			array=whitearray;
		}
		int i=x;
		int j=y;
		int count[]= {-1,-1,-1,-1};
		
		try {
		while(checkdol(array,i,j)) {			
			i++; 
			j--;
			count[0]++;		
		}}
		catch(ArrayIndexOutOfBoundsException e){
		}
		 i=x;
		 j=y;
		try {
			while(checkdol(array,i,j)) {			
				i--; 
				j++;
				count[0]++;		
			}}
			catch(ArrayIndexOutOfBoundsException e){
			}
		 i=x;
		 j=y;
		try {
			while(checkdol(array,i,j)) {	
				j--;
				count[1]++;		
			}}
			catch(ArrayIndexOutOfBoundsException e){
			}
		 i=x;
		 j=y;
		try {
			while(checkdol(array,i,j)) {		
				j++;
				count[1]++;		
			}}
			catch(ArrayIndexOutOfBoundsException e){
			}
		 i=x;
		 j=y;
		try {
			while(checkdol(array,i,j)) {		
				i--;
				j--;
				count[2]++;		
			}}
			catch(ArrayIndexOutOfBoundsException e){
			}
		 i=x;
		 j=y;
		try {
			while(checkdol(array,i,j)) {		
				i++;
				j++;
				count[2]++;		
			}}
			catch(ArrayIndexOutOfBoundsException e){
			}
		 i=x;
		 j=y;
		try {
			while(checkdol(array,i,j)) {	
				i--;
				
				count[3]++;		
			}}
			catch(ArrayIndexOutOfBoundsException e){
			}
		 i=x;
		 j=y;
		try {
			while(checkdol(array,i,j)) {//	
				i++;
				
				count[3]++;		
			}}
			catch(ArrayIndexOutOfBoundsException e){
			}
		 i=x;
		 j=y;
		
		for(int z=0;z<4;z++) {
			if(count[z]>=5) {
				return count[z];
				
			}
		}
		return -1;
	}
	void resetArray() {
		
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				blackarray[i][j]=0;
				whitearray[i][j]=0;
			}
		}	
		turn=true;
	}
	
	boolean checkdol(int array[][],int x,int y) {
		
		if(array[x][y]==1) {
			return true;
		}
		return false;	
	}
}
