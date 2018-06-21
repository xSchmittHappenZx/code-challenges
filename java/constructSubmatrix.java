/* Main class and Main() not included */
int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {
    
    int removalSize = rowsToDelete.length;
    int matrixSize = matrix.length;
    
    int[][] res = new int[matrixSize - removalSize][matrix[0].length - columnsToDelete.length];
    int resPointer = 0;
    int subResPointer = 0;
    
    HashSet<Integer> rdSet = new HashSet<Integer>();
    HashSet<Integer> cdSet = new HashSet<Integer>();
    
    buildDeleteSet(rdSet, rowsToDelete);
    buildDeleteSet(cdSet, columnsToDelete);
    
    for(int i = 0; i < matrixSize; i++){
        
        if(!rdSet.contains(i)){
            
            for(int j = 0; j < matrix[i].length; j++){
                
                if(!cdSet.contains(j)){
                    res[resPointer][subResPointer] = matrix[i][j];
                    subResPointer++;
                }
            }
            subResPointer = 0;
            resPointer++;
        }
    }
    
    return res;
}

void buildDeleteSet(HashSet<Integer> set, int[] a){
    
    for(int val : a){
        set.add(val);
    }
}
