package algorithm;

import bean.*;

import java.util.*;

public class CMetricsFactorsimpl extends CMetricsFactors{
    public CMetricsFactorsimpl(ClassDiagram diagram){super(diagram);}

    public List<CClass> classs(){
        List<CClass> classs=diagram.getClasses();
        return classs;
    }

    public void getDIT(){
        List<CGeneralization> generalizations=diagram.getGeneralizations();
        Map<String,String> geneMap = new HashMap<String , String>();
        if(generalizations != null){
            for(int i=0;i<generalizations.size();i++){
                geneMap.put(generalizations.get(i).getObject2().getName(),generalizations.get(i).getObject1().getName());
            }
        }
        for(int i=0;i<classs().size();i++){
            int dit=0;
            String className = new String();
            int flag = 0;
            className=classs().get(i).getName();
            do{
                if(geneMap.containsKey(className)){
                    dit++;
                    className = geneMap.get(className);
                }
                else{
                    flag = 1;
                }
            }while(flag == 0);
            System.out.println(classs().get(i).getName()+":"+dit);
        }
    }

    public void getCBO(){
        List<CAssociation> associations = diagram.getAssociations();
        for(int i=0;i<classs().size();i++){
            int cbo = 0;
            if(associations != null){
                for(int k=0;k<associations.size();k++){
                    if(classs().get(i).equals(associations.get(k).getObject1()) || classs().get(i).equals(associations.get(k).getObject2())){
                        cbo++;
                    }
                }
            }
            System.out.println(classs().get(i).getName()+":"+cbo);
        }

    }

    //获得度量因子PIM 类中公有实例方法
    public void getPIM(){
        for(int i=0;i<classs().size();i++){
            int pim = 0;
            for(int k=0;k<getNCM().get(classs().get(i)).size();k++){
                if(getNCM().get(classs().get(i)).get(k).getVisibility().equals(COperation.VISIBILITY.PUBLIC)){
                    pim++;
                }
            }
            System.out.println(classs().get(i).getName()+":"+pim);
        }
    }

    /**获得度量因子NIM 为类实例定义的⽅法的总数**/
    public void getNIM(){
        for(int i=0;i<classs().size();i++){
            if(classs().get(i).getOperations()!=null){
                System.out.println(classs().get(i).getName()+":"+classs().get(i).getOperations().size());
            }
            else{
                System.out.println(classs().get(i).getName()+":"+0);
            }
        }
    }

    //获得度量因子NCM 类的全部⽅法数
    public Map<CClass, List<COperation>> getNCM(){
        Map<CClass,List<COperation>> ncmMap = new HashMap<CClass, List<COperation>>();
        List<CGeneralization> generalizations=diagram.getGeneralizations();
        Map<CClass,CClass> geneMap = new HashMap<CClass,CClass>();
        if(generalizations != null){
            for(int i=0;i<generalizations.size();i++){
                geneMap.put((CClass)generalizations.get(i).getObject2(),(CClass) generalizations.get(i).getObject1());
            }
        }
        for(int i=0;i<classs().size();i++){
            List<COperation> allOperations = new ArrayList<COperation>();
            if(classs().get(i).getOperations()!=null){
                for(int k=0;k<classs().get(i).getOperations().size();k++){
                    allOperations.add(classs().get(i).getOperations().get(k));
                }
            }
            int flag = 0;
            CClass cClass = classs().get(i);
            do{
                if(geneMap.containsKey(cClass)){
                    List<COperation> operations = geneMap.get(cClass).getOperations();
                    if(operations!=null){
                        for(int k=0;k<operations.size();k++){
                            if(!operations.get(k).getVisibility().equals(COperation.VISIBILITY.PRIVATE)){
                                List<String> operationName = new ArrayList<String>();
                                for(int j=0;j<allOperations.size();j++){
                                    operationName.add(allOperations.get(j).getName());
                                }
                                if(!operationName.contains(operations.get(k).getName())){
                                    allOperations.add(operations.get(k));
                                }
                            }
                        }
                    }
                    cClass = geneMap.get(cClass);
                }
                else{
                    flag = 1;
                }
            }while(flag == 0);
            //System.out.println(classs().get(i).getName()+":"+allOperations.size());
            ncmMap.put(classs().get(i),allOperations);
        }
        return ncmMap;
    }

    //获得度量因子NCV 类的全部属性数
    public void getNCV(){
        for(int i=0;i<classs().size();i++){
            if(classs().get(i).getAttributes()!=null){
                System.out.println(classs().get(i).getName()+":"+classs().get(i).getAttributes().size());
            }
            else{
                System.out.println(classs().get(i).getName()+":"+0);
            }
        }
    }

    //获得度量因子APPM APPM=全部⽅法的参数个数/全部⽅法数
    public void getAPPM(){
        for(int i=0;i<classs().size();i++){
            int parameterSizeA=0;
            double appm = 0;
            for(int j=0;j<getNCM().get(classs().get(i)).size();j++){
                int parameterSizeI=0;
                if(getNCM().get(classs().get(i)).get(j).getParameters()!=null){
                    parameterSizeI=getNCM().get(classs().get(i)).get(j).getParameters().size();
                }
                parameterSizeA=parameterSizeA+parameterSizeI;
            }
            if(getNCM().get(classs().get(i)).size() != 0){
                appm=(double)parameterSizeA/getNCM().get(classs().get(i)).size();
            }
            System.out.println(classs().get(i).getName()+":"+((int)(appm*100))/100.0);
        }
    }

    //获得度量因子NMO 某个类被其⼦类覆盖的⽅法总数
    public void getNMO(){
        List<CGeneralization> generalizations=diagram.getGeneralizations();
        Map<CClass,CClass> geneMap = new HashMap<CClass,CClass>();
        if(generalizations != null){
            for(int i=0;i<generalizations.size();i++){
                geneMap.put((CClass)generalizations.get(i).getObject2(),(CClass) generalizations.get(i).getObject1());
            }
        }
        for(int i=0;i<classs().size();i++){
            int nmo = 0;
            int flag = 0;
            List<CClass> subClass = new ArrayList<CClass>();
            List<CClass> subClass1 = new ArrayList<CClass>();
            List<CClass> subClass2 = new ArrayList<CClass>();
            for(CClass getKey : geneMap.keySet()){
                if(geneMap.get(getKey).equals(classs().get(i))){
                    subClass.add(getKey);
                }
            }
            subClass1.addAll(subClass);
            do{
                for(CClass c : subClass1){
                    for(CClass getKey : geneMap.keySet()){
                        if(geneMap.get(getKey).equals(c)){
                            subClass.add(getKey);
                            flag = 1;
                        }
                        else {
                            flag = 0;
                        }
                    }
                }
                subClass2.addAll(subClass);
                subClass2.removeAll(subClass1);
                subClass1 = subClass2;
            }while(flag == 1);
            List<String> operations = new ArrayList<String>();
            if(classs().get(i).getOperations() != null){
                for(int k=0;k<classs().get(i).getOperations().size();k++){
                    operations.add(classs().get(i).getOperations().get(k).getName());
                }
            }
            for(CClass c : subClass){
                for(int k=0;k<c.getOperations().size();k++){
                    if(operations.contains(c.getOperations().get(k).getName())){
                        operations.remove(c.getOperations().get(k).getName());
                        nmo++;
                    }
                }
            }
            System.out.println(classs().get(i).getName()+":"+nmo);
        }
    }

    //获得度量因子NMA ⼀个⼦类中定义的⽅法总数
    public void getNMA(){
        List<CGeneralization> generalizations=diagram.getGeneralizations();
        Map<CClass,CClass> geneMap = new HashMap<CClass,CClass>();
        if(generalizations != null){
            for(int i=0;i<generalizations.size();i++){
                geneMap.put((CClass)generalizations.get(i).getObject2(),(CClass) generalizations.get(i).getObject1());
            }
        }
        for(int i=0;i<classs().size();i++){
            if(geneMap.containsKey(classs().get(i))){
                System.out.println(classs().get(i).getName()+":"+classs().get(i).getOperations().size());
            }
        }
    }

    //获得度量因子NOC 某个类直接派⽣的⼦类个数
    public void getNOC(){
        List<CGeneralization> generalizations=diagram.getGeneralizations();
        Map<CClass,CClass> geneMap = new HashMap<CClass,CClass>();
        if(generalizations != null){
            for(int i=0;i<generalizations.size();i++){
                geneMap.put((CClass)generalizations.get(i).getObject2(),(CClass) generalizations.get(i).getObject1());
            }
        }
        for(int i=0;i<classs().size();i++){
            int noc=0;
            for(CClass c : geneMap.keySet()){
                if(classs().get(i).getName() == geneMap.get(c).getName()){
                    noc++;
                }
            }
            System.out.println(classs().get(i).getName()+":"+noc);
        }
    }
}
