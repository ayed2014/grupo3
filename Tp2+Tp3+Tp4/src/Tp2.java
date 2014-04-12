/**
 * Created by Fran on 11/03/14.
 */
class Merge<T> {
        public Comparable<T>[] merge(Comparable<T> firstArray[], Comparable <T> secondArray[]){

            int lengthArrays= firstArray.length+secondArray.length;

            Comparable[] thirdArray = new Comparable[lengthArrays];

            int countThirdA=0;
            int countFirstA=0;
            int countSecondA=0;
            firstArray=sort(firstArray);
            secondArray=sort(secondArray);

            while(countFirstA<firstArray.length&&countSecondA<secondArray.length){
                    if(secondArray[countSecondA].compareTo((T) firstArray[countFirstA])==0){
                        thirdArray[countThirdA]=secondArray[countSecondA];
                        countThirdA++;
                        countFirstA++;
                        countSecondA++;
                    }
                    else if(secondArray[countSecondA].compareTo((T) firstArray[countFirstA])<0){
                        thirdArray[countThirdA]=secondArray[countSecondA];
                        countThirdA++;
                        countSecondA++;
                    }
                    else if(secondArray[countSecondA].compareTo((T) firstArray[countFirstA])>0){
                        thirdArray[countThirdA]=firstArray[countFirstA];
                        countFirstA++;
                        countThirdA++;
                    }
            }
               if (firstArray.length>countFirstA){
                   while(firstArray.length>countFirstA){
                    thirdArray[countThirdA]= firstArray[countFirstA];
                    countFirstA++;
                    countThirdA++;
                   }
                }
                else if (secondArray.length>countSecondA){
                   while(secondArray.length>countSecondA){
                    thirdArray[countThirdA]=secondArray[countSecondA];
                    countSecondA++;
                    countThirdA++;
                   }
                }
                                  return thirdArray;
        }





    private Comparable<T>[] sort(Comparable<T> array[]){

        int min;
        for (int i = 0; i < array.length; i++) {

            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo((T) array[min])<0) {
                    min = j;

                }
            }
            if (min != i) {
                final Comparable<T> temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
            return array;


    }
}
class Tester{
    public static void main(String[] args) {
        Merge merge=new Merge();
        Colectivo[] colectivos=new Colectivo[2];
        Colectivo[] colectivos1=new Colectivo[2];
        Colectivo uno=new Colectivo(210,21,30,true);
        Colectivo dos=new Colectivo(400,32,40,false);
        Colectivo tres=new Colectivo(500,40,20,false);
        Colectivo cuatro=new Colectivo(210,22,30,true);
        colectivos[0]=uno;
        colectivos[1]=dos;
        colectivos1[0]=tres;
        colectivos1[1]=cuatro;
        Integer[] a={6,7,8,10,9,12,11} ;
        String[] f={"hola","chau","mia","tuyo"};
        String[] g={"caca","popo","salame","mostadela"};
        Integer[] b={3,1,5,4,2} ;

        Comparable [] c=  merge.merge(f,a);
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }
}
